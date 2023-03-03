package com.example.Book_My_Show.Entities;


import com.example.Book_My_Show.Enums.SeatType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "theatre_seat")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TheatreSeatEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private SeatType seatType;

    private String seatNo;

    @ManyToOne
    @JoinColumn
    private TheatreEntity theatreEntity;
}
