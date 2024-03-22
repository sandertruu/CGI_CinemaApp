package com.cgi.cinemabackend.models.filters;

import lombok.Getter;

import java.time.LocalTime;

//Samuti võetud Apollo kino filtrite eeskujul

@Getter
public enum StartTime {
    TIME_9_00(LocalTime.of(9,0), 1),
    TIME_10_00(LocalTime.of(10,0), 2),
    TIME_11_00(LocalTime.of(11,0),3 ),
    TIME_12_00(LocalTime.of(12,0),4),
    TIME_13_00(LocalTime.of(13,0),5),
    TIME_14_00(LocalTime.of(14,0),6),
    TIME_15_00(LocalTime.of(15,0),7),
    TIME_16_00(LocalTime.of(16,0),8),
    TIME_17_00(LocalTime.of(17,0),9),
    TIME_18_00(LocalTime.of(18,0),10),
    TIME_19_00(LocalTime.of(19,0),11);

    private final LocalTime localTime;

    private final int id;

    StartTime(LocalTime localTime, int id) {
        this.id = id;
        this.localTime = localTime;
    }

    public int getHour() {
        return localTime.getHour();
    }
}
