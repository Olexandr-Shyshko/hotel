package com.robor_dreams.hotel.service;

import com.robor_dreams.hotel.domain.Reservation;
import com.robor_dreams.hotel.dto.ReservDto;
import com.robor_dreams.hotel.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationService {
    private final ReservationRepository reservationRepository;

    public void saveReservation(Reservation reservation) {
        reservationRepository.save(reservation);
    }

    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }

    public void cancelReservation(Long idReservation) {
        var reservation = reservationRepository.findById(idReservation).get();
        reservation.setIsClose(1);
        reservationRepository.save(reservation);
    }
    public List<ReservDto> findAllReservation() {
        return reservationRepository.findAllReservation();
    }
}
