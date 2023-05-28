package com.robor_dreams.hotel.dto;

import java.time.LocalDate;

public interface ReservDto {
    Long getId();
    String getGuestName();
    String getRoomName();
    LocalDate getDateBegin();
    LocalDate getDateEnd();
    Integer getIsClose();
}
