package com.example.Book_My_Show.convertors;

import com.example.Book_My_Show.Entities.TheatreEntity;
import com.example.Book_My_Show.EntryDtos.TheatreEntryDto;

public class TheatreConvertor {
    public static TheatreEntity convertEntryDtoToEntity(TheatreEntryDto theatreEntryDto)
    {
                TheatreEntity theatreEntity= TheatreEntity.builder().
                name(theatreEntryDto.getName())
                .location(theatreEntryDto.getLocation()).build();
                return theatreEntity;
    }
}
