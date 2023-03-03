package com.example.Book_My_Show.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "theaters")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class TheatreEntity {

            @Id
         @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        private String name;

        private String location;

        @OneToMany(mappedBy = "theatreEntity",cascade = CascadeType.ALL)
        private List<TheatreSeatEntity>theatreSeatEntityList=new ArrayList<>();


    @OneToMany(mappedBy = "theatreEntity",cascade = CascadeType.ALL)
    private List<ShowEntity>showEntityList=new ArrayList<>();

}
