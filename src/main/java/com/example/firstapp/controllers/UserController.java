package com.example.firstapp.controllers;

import com.example.firstapp.services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    private BookService bookService;

    public UserController(BookService bookService) {
        this.bookService = bookService;
    }


    @PutMapping(value = "/add-book/{title}/{mail}")
    ResponseEntity addBookToProfile(@PathVariable("title") String title, @PathVariable("mail") String mail ){


            try {
                bookService.addToProfile(title,mail);
                return new ResponseEntity("Added to Profile", HttpStatus.OK);
            } catch (Exception e) {
                return ResponseEntity.unprocessableEntity().build();
            }



    }
}
