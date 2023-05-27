package com.robor_dreams.hotel.repository;

import com.robor_dreams.hotel.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room,Long> {
}
