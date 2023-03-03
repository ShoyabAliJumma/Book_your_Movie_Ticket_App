package com.example.Book_My_Show.convertors;

import com.example.Book_My_Show.Entities.MovieEntity;
import com.example.Book_My_Show.EntryDtos.MovieEntryDto;

public class MovieConvertors {

    public static MovieEntity convertEntryDtoToEntity(MovieEntryDto movieEntryDto)
    {

        MovieEntity movieEntity= MovieEntity.builder().movieName(movieEntryDto.getMovieName()).
                duration(movieEntryDto.getDuration()).ratings(movieEntryDto.getRatings()).
                language(movieEntryDto.getLanguage()).genre(movieEntryDto.getGenre()).build();
        return movieEntity;
    }
}
