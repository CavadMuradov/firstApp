package com.example.firstapp.models.Entity;

import com.example.firstapp.models.Dto.BookDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Books")
public class BookEntity  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private UserEntity customer;


    @Column(name = "title" )
    private String title;

    @Column(name = "author")
    private String author;


    public BookEntity(BookDto bookDto) {
        this.author=bookDto.getAuthor();
        this.title=bookDto.getTitle();
    }
}
