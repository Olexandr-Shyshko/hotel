package com.robor_dreams.hotel.dto;

import lombok.*;

import java.time.LocalDate;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDtoImpl implements ReservationDto {
    private Long id;
    private String guestName;
    private String roomName;
    private LocalDate dateBegin;
    private LocalDate dateEnd;
    private Integer isClose;
    }
