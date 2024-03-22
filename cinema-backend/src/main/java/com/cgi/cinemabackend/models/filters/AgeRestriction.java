package com.cgi.cinemabackend.models.filters;

import lombok.Getter;

//Võetud Apollo kino filtrite järgi
@Getter
public enum AgeRestriction {
    PEREFILM(1, "Perefilm"),
    ALLA_12(2, "Alla 12 a. mittesoovitav"),
    ALLA_12_KEELATUD(3, "Alla 12 a. keelatud"),
    ALLA_14_KEELATUD(4, "Alla 14 a. keelatud"),
    ALLA_6(5, "Alla 6 a. mittesoovitav"),
    LUBATUD_KOIGILE(6, "Lubatud kõigile");

    private final int id;
    private final String description;

    AgeRestriction(int id, String description) {
        this.id = id;
        this.description = description;
    }
}
