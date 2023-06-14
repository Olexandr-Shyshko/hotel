package com.robor_dreams.hotel.service;

import com.robor_dreams.hotel.domain.Reservation;
import com.robor_dreams.hotel.domain.Room;
import com.robor_dreams.hotel.dto.ReservationDto;
import com.robor_dreams.hotel.repository.ReservationRepository;
import com.robor_dreams.hotel.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final RoomRepository roomRepository;

    public void saveReservation(Reservation reservation) {
        List<Long> freeRoomIdList = roomRepository.findFreeRoom(reservation.getDateBegin(), reservation.getDateEnd())
                .stream().map(Room::getId).collect(Collectors.toList());
        if (freeRoomIdList.contains(reservation.getRoomId())) {
            reservationRepository.save(reservation);
        } else {
            throw new IllegalArgumentException("Room is occupied!");
        }
    }

    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }

    public void cancelReservation(Long idReservation) {
        var reservation = reservationRepository.findById(idReservation).get();
        reservation.setIsClose(1);
        reservationRepository.save(reservation);
    }

    public List<ReservationDto> findAllReservation() {
        return reservationRepository.findAllReservation();
    }
}
