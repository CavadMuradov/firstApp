package com.example.firstapp.models.Dto;

import com.example.firstapp.models.Entity.UserEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookDto {
    String title;
    String author;
    UserEntity customer;
}
