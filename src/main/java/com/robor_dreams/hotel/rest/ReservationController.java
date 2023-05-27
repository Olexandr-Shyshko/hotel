package com.robor_dreams.hotel.rest;

import com.robor_dreams.hotel.domain.Reservation;
import com.robor_dreams.hotel.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationService reservationService;

    @PostMapping("/reservation")
    public ResponseEntity<Void> saveReservation(@RequestBody Reservation reservation) {
        reservationService.saveReservation(reservation);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PutMapping("/reservation")
    public ResponseEntity<Void> updateReservation(@RequestBody Reservation reservation) {
        reservationService.saveReservation(reservation);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
    @PostMapping("/reservation/{id}")
    public ResponseEntity<Void> cancelReservation(@PathVariable Long id) {
        reservationService.cancelReservation(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @DeleteMapping("/reservation/{id}")
    public void deleteReservation(@PathVariable Long id) {
        reservationService.deleteReservation(id);
    }
}
