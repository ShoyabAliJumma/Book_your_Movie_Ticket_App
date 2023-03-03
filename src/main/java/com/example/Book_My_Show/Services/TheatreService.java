package com.example.Book_My_Show.Services;


import com.example.Book_My_Show.Entities.TheatreEntity;
import com.example.Book_My_Show.Entities.TheatreSeatEntity;
import com.example.Book_My_Show.EntryDtos.TheatreEntryDto;
import com.example.Book_My_Show.Enums.SeatType;
import com.example.Book_My_Show.Repostories.TheatreRepository;
import com.example.Book_My_Show.Repostories.TheatreSeatRepository;
import com.example.Book_My_Show.convertors.TheatreConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheatreService {
    @Autowired
    TheatreSeatRepository theatreSeatRepository;

    @Autowired
    TheatreRepository theatreRepository;

    public String addTheatre(TheatreEntryDto theatreEntryDto) throws Exception
    {

        if(theatreEntryDto.getName()==null|| theatreEntryDto.getLocation()==null)
        {
            throw  new Exception("Name and location should be valid");
        }

        TheatreEntity theatreEntity= TheatreConvertor.convertEntryDtoToEntity(theatreEntryDto);
        List<TheatreSeatEntity>theatreSeatEntityList=createTheatreSeats(theatreEntryDto,theatreEntity);
       theatreEntity.setTheatreSeatEntityList(theatreSeatEntityList);
        theatreRepository.save(theatreEntity);
        return "Theatre Added SuccessFully";

    }
    private List<TheatreSeatEntity> createTheatreSeats(TheatreEntryDto theatreEntryDto,TheatreEntity theatreEntity)
    {
        int noClassicSeats= theatreEntryDto.getClassicSeatsCount();
        int noPremiumSeats= theatreEntryDto.getPremiumSeatsCount();
        List<TheatreSeatEntity>theatreSeatEntityList=new ArrayList<>();

        for (int count =1;count<=noPremiumSeats;count++ )
        {
            //we need to make new theatre seat entity
            TheatreSeatEntity theatreSeatEntity= TheatreSeatEntity.builder().
                    seatType(SeatType.CLASSIC).seatNo(count+ "C").theatreEntity(theatreEntity).build();
            theatreSeatEntityList.add(theatreSeatEntity);
        }
        for(int count=1;count<=noClassicSeats;count++)
        {
            TheatreSeatEntity theatreSeatEntity=TheatreSeatEntity.builder().seatType(SeatType.PREMIUM).seatNo(count+"P").theatreEntity(theatreEntity).build();
            theatreSeatEntityList.add(theatreSeatEntity);
        }
        return theatreSeatEntityList;
    }
}
