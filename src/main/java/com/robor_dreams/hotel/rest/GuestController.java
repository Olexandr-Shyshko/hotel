package com.robor_dreams.hotel.rest;

import com.robor_dreams.hotel.domain.Guest;
import com.robor_dreams.hotel.dto.GuestDto;
import com.robor_dreams.hotel.service.GuestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GuestController {
    private final GuestService guestService;
    @PostMapping("/guest")
    public ResponseEntity<Void> saveGuest(@RequestBody Guest guest){
        guestService.saveGuest(guest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PutMapping("/guest")
    public ResponseEntity<Void> updateGuest(@RequestBody Guest guest){
        guestService.saveGuest(guest);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
    @GetMapping("/guest/{name}/{taxId}")
    public ResponseEntity<List<GuestDto>> findByNameOrTaxId(@PathVariable String name, @PathVariable String taxId){
        return ResponseEntity.ok(guestService.findByNameOrTaxIdNumb(name, taxId));
    }

    @GetMapping("/guest")
    public ResponseEntity<List<GuestDto>> findAll(){
        return ResponseEntity.ok(guestService.findAll());
    }
}
