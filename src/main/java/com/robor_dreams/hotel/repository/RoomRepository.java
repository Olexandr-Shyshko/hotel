package com.robor_dreams.hotel.repository;

import com.robor_dreams.hotel.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface RoomRepository extends JpaRepository<Room,Long> {
    @Query("select r from Room r where r.id not in (select rs.roomId from Reservation rs where rs.isClose=0 and rs.dateBegin < :dateInto and rs.dateEnd > :dateFrom)")
    List<Room> findFreeRoom (@Param("dateFrom") LocalDate dateFrom, @Param("dateInto") LocalDate dateInto);
}
