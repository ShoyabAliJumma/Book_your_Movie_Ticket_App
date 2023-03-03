package com.example.Book_My_Show.Services;

import com.example.Book_My_Show.Entities.MovieEntity;
import com.example.Book_My_Show.EntryDtos.MovieEntryDto;
import com.example.Book_My_Show.Enums.Genre;
import com.example.Book_My_Show.Enums.Language;
import com.example.Book_My_Show.Repostories.MovieRepository;
import com.example.Book_My_Show.convertors.MovieConvertors;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public  String addMovie(MovieEntryDto movieEntryDto)
    {


        MovieEntity movieEntity= MovieConvertors.convertEntryDtoToEntity(movieEntryDto);
        movieRepository.save(movieEntity);
        return "Movie added successFully";

    }
}
