package com.robor_dreams.hotel.rest;

import com.robor_dreams.hotel.domain.Room;
import com.robor_dreams.hotel.dto.RoomDto;
import com.robor_dreams.hotel.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class RoomController {
    private final RoomService roomService;

    @PostMapping("/room")
    public ResponseEntity<Void> saveRoom(@RequestBody Room room) {
        roomService.saveRoom(room);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/room")
    public ResponseEntity<Void> updateRoom(@RequestBody Room room) {
        roomService.saveRoom(room);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
    @DeleteMapping("/room/{id}")
    public ResponseEntity<Void> deleteRoom (@PathVariable Long id){
        roomService.deleteRoom(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
    @GetMapping("/room")
    public ResponseEntity <List<RoomDto>> findAll(){
        return ResponseEntity.ok(roomService.findAll());
    }
    @PostMapping("/room/{idRoom}/reservation/{idReservation}")
    public ResponseEntity<Void> changeRoom (@PathVariable Long idRoom,@PathVariable Long idReservation){
       roomService.changeRoom(idRoom,idReservation);
       return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
    @GetMapping("/room/{dateBegin}/{dateEnd}")
    public ResponseEntity<List<RoomDto>> findFreeRoom(@PathVariable LocalDate dateBegin,@PathVariable LocalDate dateEnd){
        return ResponseEntity.ok(roomService.findFreeRoom(dateBegin, dateEnd));
    }
}
