package com.cgi.cinemabackend.models.filters;

//Võetud Apollo kino filtrite järgi
public enum AgeRestriction {
    PEREFILM(3, "Perefilm"),
    ALLA_12(2, "Alla 12 a. mittesoovitav"),
    ALLA_12_KEELATUD(4, "Alla 12 a. keelatud"),
    ALLA_14_KEELATUD(6, "Alla 14 a. keelatud"),
    ALLA_6(1, "Alla 6 a. mittesoovitav"),
    LUBATUD_KOIGILE(5, "Lubatud kõigile");

    private final int id;
    private final String description;

    AgeRestriction(int id, String description) {
        this.id = id;
        this.description = description;
    }
}
