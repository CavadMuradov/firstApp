package com.example.firstapp.services;

import com.example.firstapp.models.Dto.BookDto;
import com.example.firstapp.models.Entity.BookEntity;
import com.example.firstapp.models.Entity.UserEntity;
import com.example.firstapp.repositories.BookRepository;
import com.example.firstapp.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Service
public class BookService {

    private BookRepository bookRepository;
    private UserRepository userRepository;

    public BookService(BookRepository bookRepository, UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    public void insertBook(BookDto bookDto){
        BookEntity bookEntity= new BookEntity(bookDto);
        if (bookEntity != null )
        bookRepository.save(bookEntity);
    }

    public BookEntity addToProfile(String title, String mail){

        UserEntity userEntity=userRepository.findByUsermail(mail);
        BookEntity bookEntity = bookRepository.findByTitle(title);
        bookEntity.setCustomer(userEntity);
        bookRepository.save(bookEntity);
        return bookEntity;
    }

    public List<BookEntity> showAllBooks(){
        return bookRepository.findAll();
    }

}
