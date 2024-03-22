package com.cgi.cinemabackend.models.filters;

import lombok.Getter;

// Samuti võetud Apollo kino eeskujul
@Getter
public enum WeekDay {
    MONDAY(1, "Esmaspäev"),
    TUESDAY(2, "Teisipäev"),
    WEDNESDAY(3, "Kolmapäev"),
    THURSDAY(4, "Neljapäev"),
    FRIDAY(5, "Reede"),
    SATURDAY(6, "Laupäev"),
    SUNDAY(7, "Pühapäev");

    private final int id;

    private final String day;

    WeekDay(int id, String day) {
        this.id = id;
        this.day = day;
    }
}
