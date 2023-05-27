package com.robor_dreams.hotel.dto;

import com.robor_dreams.hotel.domain.Room;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Builder
public class GuestDto {
    private Long id;
    private String fullName;
    private String taxIdNumb;
    private String tel;
    private String email;
    private List<String> roomName;
}
