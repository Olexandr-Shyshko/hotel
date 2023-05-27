package com.robor_dreams.hotel.service;

import com.robor_dreams.hotel.domain.Reservation;
import com.robor_dreams.hotel.domain.Room;
import com.robor_dreams.hotel.dto.ReservationDto;
import com.robor_dreams.hotel.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReservationService {
    private final ReservationRepository reservationRepository;
    public void saveReservation (Reservation reservation){
        reservationRepository.save(reservation);
    }
    public void deleteReservation (Long id){
        reservationRepository.deleteById(id);
    }
    public void cancelReservation (Long idReservation){
        var reservation = reservationRepository.findById(idReservation).get();
        reservation.setIsClose(1);
        reservationRepository.save(reservation);
    }
    public List<ReservationDto> findAll(){
        return reservationRepository.findAll().stream().map(ReservationService::buildReservationDto).collect(Collectors.toList());
    }

    private static ReservationDto buildReservationDto (Reservation reservation){
        return ReservationDto.builder()
                .id(reservation.getId())
                .dateBegin(reservation.getDateBegin())
                .dateEnd(reservation.getDateEnd())
                .isClose(reservation.getIsClose())
                .build();
    }
}
