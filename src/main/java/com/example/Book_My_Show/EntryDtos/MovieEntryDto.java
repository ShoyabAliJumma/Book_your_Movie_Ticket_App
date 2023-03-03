package com.example.Book_My_Show.EntryDtos;

import com.example.Book_My_Show.Enums.Genre;
import com.example.Book_My_Show.Enums.Language;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class MovieEntryDto {
    private String movieName;

    private double ratings;

    private int duration;

    @Enumerated(value= EnumType.STRING)
    private Language language;

    @Enumerated(value=EnumType.STRING)
    private Genre genre;


}
