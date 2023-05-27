package com.robor_dreams.hotel.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class RoomDto {
    private Long id;
    private String name;
    private int countPerson;
    private int price;
    private List<String> guestName;
}
