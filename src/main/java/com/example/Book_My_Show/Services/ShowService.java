package com.example.Book_My_Show.Services;

import com.example.Book_My_Show.Entities.*;
import com.example.Book_My_Show.EntryDtos.ShowEntryDto;
import com.example.Book_My_Show.Enums.SeatType;
import com.example.Book_My_Show.Repostories.MovieRepository;
import com.example.Book_My_Show.Repostories.ShowRepository;
import com.example.Book_My_Show.Repostories.TheatreRepository;
import com.example.Book_My_Show.convertors.ShowConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowService {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    TheatreRepository theatreRepository;

    @Autowired
    ShowRepository showRepository;

    public String addShow(ShowEntryDto showEntryDto) {
        //1. Create a showEntity
        ShowEntity showEntity = ShowConvertor.convertEntryToEntity(showEntryDto);

        int movieId = showEntryDto.getMovieId();
        int theaterId = showEntryDto.getTheaterId();

        MovieEntity movieEntity = movieRepository.findById(movieId).get();
        TheatreEntity theaterEntity = theatreRepository.findById(theaterId).get();


        //Setting the attribute of foreignKe
        showEntity.setMovieEntity(movieEntity);
        showEntity.setTheatreEntity(theaterEntity);

        //Pending attributes the listOfShowSeatsEnity

        List<ShowSeatEntity> seatEntityList = createShowSeatEntity(showEntryDto,showEntity);

        showEntity.setListOfShowSeats(seatEntityList);


        //Now we  also need to update the parent entities


        showEntity = showRepository.save(showEntity);

        movieEntity.getShowEntityList().add(showEntity);
        theaterEntity.getShowEntityList().add(showEntity);


        movieRepository.save(movieEntity);

        theatreRepository.save(theaterEntity);

        return "The show has been added successfully";

    }
    public  List<ShowSeatEntity> createShowSeatEntity(ShowEntryDto showEntryDto,ShowEntity showEntity)
    {
            TheatreEntity theatreEntity=  showEntity.getTheatreEntity();
           List<TheatreSeatEntity>theatreSeatEntityList=theatreEntity.getTheatreSeatEntityList();
        List<ShowSeatEntity> seatEntityList = new ArrayList<>();
        for(TheatreSeatEntity theatreSeatEntity :theatreSeatEntityList)
        {
            ShowSeatEntity showSeatEntity=new ShowSeatEntity();
            showSeatEntity.setSeatNo(theatreSeatEntity.getSeatNo());
            showSeatEntity.setSeatType(theatreSeatEntity.getSeatType());

            if(theatreSeatEntity.getSeatType().equals(SeatType.CLASSIC))
            {
                showSeatEntity.setPrice(showEntryDto.getClassicSeatPrice());
            }
            else
            {
                showSeatEntity.setPrice(showEntryDto.getPremiumSeatPrice());
            }

            showSeatEntity.setBooked(false);
            showSeatEntity.setShowEntity(showEntity);   //parent : foreign key for the showSeat Entity

            seatEntityList.add(showSeatEntity);


        }
        return seatEntityList;
    }
}
