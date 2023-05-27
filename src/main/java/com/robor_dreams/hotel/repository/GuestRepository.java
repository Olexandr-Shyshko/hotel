package com.robor_dreams.hotel.repository;

import com.robor_dreams.hotel.domain.Guest;
import com.robor_dreams.hotel.dto.GuestDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GuestRepository extends JpaRepository<Guest,Long> {
    @Query("SELECT g FROM Guest g where g.fullName LIKE %?1% or g.taxIdNumb LIKE %?2%")
//    @Query("SELECT g FROM Guest g where g.fullName=?1 or g.taxIdNumb=?2")
    List<Guest> findByFullNameOrTAX (String fullName, String taxIndNumber);

}

