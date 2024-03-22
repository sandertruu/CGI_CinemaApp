package com.cgi.cinemabackend.models.filters;

import lombok.Getter;

//Samuti võetud Apollo kino filtrite eeskujul
@Getter
public enum Language {

    ESTONIAN(1, "Estonian"),
    ENGLISH(2, "English"),
    RUSSIAN(3, "Russian"),
    MULTILINGUAL(4, "Multi-Lingual");

    private final int id;
    private final String language;

    Language(int id, String language) {
        this.id = id;
        this.language = language;
    }
}
