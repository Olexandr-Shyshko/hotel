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
    @Column
    private Long room_id;
    @Column
    private Long guest_id;
    @Column
    private LocalDate dateBegin;
    @Column
    private LocalDate dateEnd;
    @Column
    private Integer isClose;
}
