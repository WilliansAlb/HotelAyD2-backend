package com.ayd2.hotel.service;

import com.ayd2.hotel.dto.PaymentReservationRequest;
import com.ayd2.hotel.dto.PaymentReservationResponse;
import com.ayd2.hotel.exception.HtlException;
import com.ayd2.hotel.model.PaymentReservation;
import com.ayd2.hotel.model.Reservation;
import com.ayd2.hotel.repository.PaymentRepository;
import com.ayd2.hotel.repository.PaymentReservationRepository;
import com.ayd2.hotel.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PaymentService {
    private PaymentRepository paymentRepository;
    private PaymentReservationRepository paymentReservationRepository;
    private ReservationRepository reservationRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository, PaymentReservationRepository paymentReservationRepository,
                          ReservationRepository reservationRepository) {
        this.paymentRepository = paymentRepository;
        this.paymentReservationRepository = paymentReservationRepository;
        this.reservationRepository = reservationRepository;
    }

    public List<PaymentReservationResponse> getPaymentsOfReservation(Long reservationId){
        return this.paymentReservationRepository.findAllByReservationId(reservationId)
                .stream()
                .map(PaymentReservationResponse::new)
                .collect(Collectors.toList());
    }

    public PaymentReservationResponse checkIn(PaymentReservationRequest paymentReservationRequest) throws HtlException{
        Optional<Reservation> reservation = this.reservationRepository.findByReservationIdAndStatusGreaterThanAndStatusLessThan(paymentReservationRequest.getReservation_id(),0,2);
        if (reservation.isEmpty()){
            throw new HtlException("Not found reservation").status(HttpStatus.NOT_FOUND);
        }
        PaymentReservation paymentReservation = new PaymentReservation();
        paymentReservation.setReservationId(paymentReservationRequest.getReservation_id());
        paymentReservation.setDate(paymentReservationRequest.getDate());
        paymentReservation.setDescription(paymentReservationRequest.getDescription());
        paymentReservation.setAccountId(paymentReservationRequest.getAccount_id());
        paymentReservation.setTotal(paymentReservationRequest.getTotal());
        this.paymentReservationRepository.save(paymentReservation);
        reservation.get().setStatus(2);
        reservation.get().setCheckInDate(paymentReservation.getDate());
        this.reservationRepository.save(reservation.get());

        return new PaymentReservationResponse(paymentReservation);
    }
}
