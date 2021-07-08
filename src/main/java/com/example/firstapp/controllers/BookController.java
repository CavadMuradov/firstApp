package com.example.firstapp.controllers;

import com.example.firstapp.models.Dto.BookDto;
import com.example.firstapp.models.Entity.BookEntity;
import com.example.firstapp.services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/book")
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @PostMapping(value = "/insert-book")
    ResponseEntity insertBook(@RequestBody BookDto bookDto ){
        try {
            bookService.insertBook(bookDto);
            return new ResponseEntity("Book added to library", HttpStatus.OK);
        }catch (Exception e){
            return ResponseEntity.unprocessableEntity().build();
        }

    }

    @GetMapping(value = "/show-all")
    ResponseEntity showAllBooks(){
        List<BookEntity> bookEntities=bookService.showAllBooks();
        return new ResponseEntity(bookEntities,HttpStatus.OK);
    }

}
