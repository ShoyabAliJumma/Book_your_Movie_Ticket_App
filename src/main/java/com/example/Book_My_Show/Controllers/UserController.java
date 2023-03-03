package com.example.Book_My_Show.Controllers;


import com.example.Book_My_Show.EntryDtos.UserEntryDto;
import com.example.Book_My_Show.Services.UserService;
import jakarta.xml.ws.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody UserEntryDto userEntryDto)
    {
        try {
            String response= userService.addUser(userEntryDto);
            return new ResponseEntity<String>(response, HttpStatus.CREATED);
        }catch (Exception e)
        {
            String result="user couldn't be added";
            return new ResponseEntity<>(result,HttpStatus.BAD_REQUEST);
        }
    }
}
