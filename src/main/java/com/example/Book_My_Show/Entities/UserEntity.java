package com.example.Book_My_Show.Entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int age;

    @NonNull
    @Column(unique = true) //dont be null
    private String mobNo;


    @Column(unique = true,nullable = false)
    private String email;

    private String address;

  @OneToMany(mappedBy ="userEntity",cascade = CascadeType.ALL)
    private List<TicketEntity>bookedTickets=new ArrayList<>();
}
