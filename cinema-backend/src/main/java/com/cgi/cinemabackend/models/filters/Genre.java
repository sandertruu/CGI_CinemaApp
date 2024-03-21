package com.cgi.cinemabackend.models.filters;

//Samuti võetud Apollo kino filtrite eeskujul
public enum Genre {
    ACTION(1, "Action"),
    COMEDY(2, "Comedy"),
    FAMILY(3, "Family"),
    SCIFI(4, "Sci-Fi"),
    THRILLER(5, "Thriller"),
    ANIMATION(6, "Animation"),
    HORROR(7, "Horror"),
    DRAMA(8, "Drama"),
    DOCUMENTARY(9, "Documentary");


    private final int id;
    private final String value;

    Genre(int id, String value) {
        this.id = id;
        this.value = value;
    }
}
