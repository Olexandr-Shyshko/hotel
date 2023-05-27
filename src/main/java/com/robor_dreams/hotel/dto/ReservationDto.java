package com.robor_dreams.hotel.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Builder
@Getter
@Setter
public class ReservationDto {
    private Long id;
    private Long roomId;
    private Long guestId;
    private LocalDate dateBegin;
    private LocalDate dateEnd;
    private Integer isClose;
    }
