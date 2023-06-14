package com.robor_dreams.hotel.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "room_id")
    private Long roomId;
    @Column(name="guest_id")
    private Long guestId;
    @Column
    private LocalDate dateBegin;
    @Column
    private LocalDate dateEnd;
    @Column
    private Integer isClose;
}
