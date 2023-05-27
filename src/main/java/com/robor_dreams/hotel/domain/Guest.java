package com.robor_dreams.hotel.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String fullName;
    @Column
    private String taxIdNumb;
    @Column
    private String tel;
    @Column
    private String email;
    @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST},fetch = FetchType.LAZY)
    @JoinTable(
            name="reservation",
            joinColumns = @JoinColumn(name="guest_id"),
            inverseJoinColumns = @JoinColumn(name = "room_id"))
    private List<Room> roomList;


}
