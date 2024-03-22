package com.cgi.cinemabackend.models;

import com.cgi.cinemabackend.models.filters.StartTime;
import com.cgi.cinemabackend.models.filters.WeekDay;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "schedule")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "movie_id")
    private Long movieId;

    @Column(name = "start_time")
    private StartTime startTime;

    @Column(name="weekday")
    private WeekDay weekDay;
}
