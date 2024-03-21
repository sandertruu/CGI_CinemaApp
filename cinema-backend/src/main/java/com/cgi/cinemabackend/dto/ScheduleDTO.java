package com.cgi.cinemabackend.dto;


import com.cgi.cinemabackend.models.filters.StartTime;
import com.cgi.cinemabackend.models.filters.WeekDay;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ScheduleDTO {

    private Long id;
    private MovieDTO movie;
    private StartTime startTime;
    private WeekDay weekDay;
}
