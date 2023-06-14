package com.robor_dreams.hotel.repository;

import com.robor_dreams.hotel.domain.Reservation;
import com.robor_dreams.hotel.dto.ReservationDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {
    @Query(value =
            "select res.id,g.full_Name as guestName,rm.name as roomName,date_Begin as dateBegin,date_End as dateEnd,is_Close as isClose\n" +
                    "from Reservation res\n" +
                    "left join Room rm on rm.id=res.room_id\n" +
                    "left join Guest g on g.id=res.guest_id"
            ,nativeQuery = true)
    List<ReservationDto> findAllReservation();
}
