package com.example.firstapp.repositories;

import com.example.firstapp.models.Entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface BookRepository  extends JpaRepository<BookEntity,Long> {
    BookEntity findByTitle(String title);

}
