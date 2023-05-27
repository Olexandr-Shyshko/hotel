package com.robor_dreams.hotel.service;

import com.robor_dreams.hotel.domain.Guest;
import com.robor_dreams.hotel.domain.Room;
import com.robor_dreams.hotel.dto.GuestDto;
import com.robor_dreams.hotel.repository.GuestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GuestService {
    private final GuestRepository guestRepository;

    public void saveGuest(Guest guest){
        guestRepository.save(guest);
    }

    public List<GuestDto> findAll (){
        return guestRepository.findAll().stream()
                .map(GuestService::buildGuestDto).collect(Collectors.toList());
    }
    public List<GuestDto> findByNameOrTaxIdNumb (String name, String taxNumb){
        return guestRepository.findByFullNameOrTAX(name, taxNumb).stream()
                .map(GuestService::buildGuestDto).collect(Collectors.toList());
    }
    private static GuestDto buildGuestDto (Guest guest){
        return GuestDto.builder()
                .id(guest.getId())
                .fullName(guest.getFullName())
                .taxIdNumb(guest.getTaxIdNumb())
                .tel(guest.getTel())
                .email(guest.getEmail())
                .roomName(guest.getRoomList().stream().map(Room::getName).collect(Collectors.toList()))
                .build();
    }

}
