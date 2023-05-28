package com.robor_dreams.hotel.dto;

import jakarta.persistence.Entity;
import lombok.*;

import java.time.LocalDate;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDto implements ReservDto {
    private Long id;
    private String guestName;
    private String roomName;
    private LocalDate dateBegin;
    private LocalDate dateEnd;
    private Integer isClose;
    }
