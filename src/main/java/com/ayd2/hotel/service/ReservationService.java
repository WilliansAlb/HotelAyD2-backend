package com.ayd2.hotel.service;

import com.ayd2.hotel.dto.NewReservationRequest;
import com.ayd2.hotel.dto.ReservationResponse;
import com.ayd2.hotel.model.ClientAccount;
import com.ayd2.hotel.model.PaymentReservation;
import com.ayd2.hotel.model.Reservation;
import com.ayd2.hotel.repository.ClientAccountRepository;
import com.ayd2.hotel.repository.PaymentRepository;
import com.ayd2.hotel.repository.PaymentReservationRepository;
import com.ayd2.hotel.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationService {
    private ReservationRepository reservationRepository;
    private ClientAccountRepository clientAccountRepository;
    private PaymentRepository paymentRepository;
    private PaymentReservationRepository paymentReservationRepository;


    @Autowired
    public ReservationService(ReservationRepository reservationRepository, ClientAccountRepository clientAccountRepository,
                              PaymentRepository paymentRepository, PaymentReservationRepository paymentReservationRepository) {
        this.reservationRepository = reservationRepository;
        this.clientAccountRepository = clientAccountRepository;
        this.paymentRepository = paymentRepository;
        this.paymentReservationRepository = paymentReservationRepository;
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
}
