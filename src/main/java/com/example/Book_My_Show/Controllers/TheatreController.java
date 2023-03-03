package com.example.Book_My_Show.Controllers;


import com.example.Book_My_Show.EntryDtos.TheatreEntryDto;
import com.example.Book_My_Show.Services.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/theatre")
public class TheatreController {

    @Autowired
    TheatreService theatreService;

    @PostMapping("/add")
    public ResponseEntity addTheatre(@RequestBody TheatreEntryDto theatreEntityDto) throws Exception
    {
        try {
           String result= theatreService.addTheatre(theatreEntityDto);
            return new ResponseEntity(result, HttpStatus.CREATED);
        }catch (Exception e)
        {
         return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
