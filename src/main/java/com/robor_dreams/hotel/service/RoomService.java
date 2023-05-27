package com.robor_dreams.hotel.service;

import com.robor_dreams.hotel.domain.Guest;
import com.robor_dreams.hotel.domain.Reservation;
import com.robor_dreams.hotel.domain.Room;
import com.robor_dreams.hotel.dto.GuestDto;
import com.robor_dreams.hotel.dto.RoomDto;
import com.robor_dreams.hotel.repository.ReservationRepository;
import com.robor_dreams.hotel.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoomService {
    private final RoomRepository roomRepository;
    private final ReservationRepository reservationRepository;
    public void saveRoom (Room room){
        roomRepository.save(room);
    }
    public void deleteRoom (Long roomId){

        roomRepository.deleteById(roomId);
    }
    public List<RoomDto> findAll(){
       return roomRepository.findAll().stream().map(RoomService::buildGuestDto).collect(Collectors.toList());
    }

    private static RoomDto buildGuestDto (Room room){
        return RoomDto.builder()
                .id(room.getId())
                .name(room.getName())
                .countPerson(room.getCountPerson())
                .price(room.getPrice())
                .guestName(room.getGuestList().stream().map(Guest::getFullName).collect(Collectors.toList()))
                .build();
    }

    public void changeRoom (Long idRoom, Long idReservation){
        var reservation = reservationRepository.findById(idReservation).get();
        reservation.setRoom_id(idRoom);
        reservationRepository.save(reservation);
    }

}
