package com.ayd2.hotel.service;

import com.ayd2.hotel.dto.NewReservationRequest;
import com.ayd2.hotel.dto.ReservationResponse;
import com.ayd2.hotel.exception.HtlException;
import com.ayd2.hotel.model.ClientAccount;
import com.ayd2.hotel.model.PaymentReservation;
import com.ayd2.hotel.model.Reservation;
import com.ayd2.hotel.model.StatusReservation;
import com.ayd2.hotel.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReservationService {
    private ReservationRepository reservationRepository;
    private ClientAccountRepository clientAccountRepository;
    private PaymentRepository paymentRepository;
    private PaymentReservationRepository paymentReservationRepository;
    private StatusReservationRepository statusReservationRepository;



    @Autowired
    public ReservationService(ReservationRepository reservationRepository, ClientAccountRepository clientAccountRepository,
                              PaymentRepository paymentRepository, PaymentReservationRepository paymentReservationRepository,
                              StatusReservationRepository statusReservationRepository) {
        this.reservationRepository = reservationRepository;
        this.clientAccountRepository = clientAccountRepository;
        this.paymentRepository = paymentRepository;
        this.paymentReservationRepository = paymentReservationRepository;
        this.statusReservationRepository = statusReservationRepository;
    }

    public List<ReservationResponse> getReservations() {
        return reservationRepository.findAll()
                .stream()
                .map(ReservationResponse::new)
                .collect(Collectors.toList());
    }

    public ReservationResponse createNewReservation(NewReservationRequest newReservationRequest) {
        ClientAccount clientAccount = clientAccountRepository.findByClientIdAndActive(newReservationRequest.getClient_id(), true);
        if (clientAccount == null) {
            clientAccount = new ClientAccount();
            clientAccount.setClientId(newReservationRequest.getClient_id());
            clientAccount.setActive(true);
            clientAccount.setStartDate(newReservationRequest.getEntry_date());
            clientAccountRepository.save(clientAccount);
        }
        Reservation newReservation = new Reservation();
        newReservation.setPriceReservation(newReservationRequest.getPrice());
        newReservation.setReservationFrom(newReservationRequest.getReservation_from());
        newReservation.setReservationUntil(newReservationRequest.getReservation_until());
        newReservation.setCreatorUserId(5001L);
        newReservation.setClientId(newReservationRequest.getClient_id());
        newReservation.setEntryDate(newReservationRequest.getEntry_date());
        newReservation.setRoomId(newReservationRequest.getRoom_id());
        newReservation.setStatus(1);
        reservationRepository.save(newReservation);

        PaymentReservation paymentReservation = new PaymentReservation();
        paymentReservation.setReservationId(newReservation.getReservationId());
        paymentReservation.setAccountId(clientAccount.getAccountId());
        paymentReservation.setTotal(newReservationRequest.getPayment());
        paymentReservation.setDescription("Pago de Reserva");
        paymentReservation.setDate(newReservation.getEntryDate());
        paymentReservationRepository.save(paymentReservation);
        return new ReservationResponse((newReservation));
    }

    public Reservation cancelReservation(Long reservation_id) throws HtlException{
        Optional<Reservation> toCancel = reservationRepository.findByReservationIdAndStatusGreaterThanAndStatusLessThan(reservation_id,0,3);
        if (toCancel.isEmpty()){
            throw new HtlException("Not found reservation").status(HttpStatus.NOT_FOUND);
        }
        toCancel.get().setStatus(0);
        reservationRepository.save(toCancel.get());
        ClientAccount account = clientAccountRepository.findByClientIdAndActive(toCancel.get().getClientId(),true);
        if (account == null){
            throw new HtlException("Not found client account").status(HttpStatus.NOT_FOUND);
        }
        account.setActive(false);
        LocalDate currentDate = LocalDate.now();
        account.setEndDate(currentDate);
        clientAccountRepository.save(account);
        return toCancel.get();
    }

    public List<StatusReservation> getAllReservationStatus(){
        return statusReservationRepository.findAll();
    }

}
