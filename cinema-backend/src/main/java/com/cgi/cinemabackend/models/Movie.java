package com.cgi.cinemabackend.models;

import com.cgi.cinemabackend.models.filters.AgeRestriction;
import com.cgi.cinemabackend.models.filters.Genre;
import com.cgi.cinemabackend.models.filters.Language;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "movies")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "genre")
    private Genre genre;

    @Column(name = "age_restriction")
    private AgeRestriction ageRestriction;

    @Column(name = "language")
    private Language language;

}
