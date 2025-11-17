package com.movie.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "movies")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String email;
    private String password;
    private String phoneNumber;

    public Movie(String title, String email, String password, String phoneNumber) {
        this.title = title;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public void update(String title, String email, String password, String phoneNumber) {
        this.title = title;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }
}
