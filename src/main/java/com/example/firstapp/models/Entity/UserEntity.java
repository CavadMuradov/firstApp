package com.example.firstapp.models.Entity;

import com.example.firstapp.models.Dto.UserDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@Data
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "customer_name")
    private String username;

    @Column(name = "customer_lastname")
    private String userlastname;

    @Column(name = "mail")
    private String usermail;

    @OneToMany(mappedBy = "customer",targetEntity = BookEntity.class,cascade =CascadeType.ALL)
    @JsonIgnore
    private Set<BookEntity> books;

    public UserEntity(UserDto userDto){
        this.username=userDto.getName();
        this.userlastname=userDto.getLastname();
        this.usermail=userDto.getEmail();
    }
}
