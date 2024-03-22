package com.cgi.cinemabackend.service;

import com.cgi.cinemabackend.dto.MovieDTO;
import com.cgi.cinemabackend.dto.ScheduleDTO;
import com.cgi.cinemabackend.models.Movie;
import com.cgi.cinemabackend.models.Schedule;
import com.cgi.cinemabackend.models.filters.AgeRestriction;
import com.cgi.cinemabackend.models.filters.Language;
import com.cgi.cinemabackend.models.filters.WeekDay;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public interface MovieService {
    public List<MovieDTO> findAllMovies();

    public MovieDTO findMovieInfoById(int id);

    public List<MovieDTO> findAllMoviesByWeekDay(WeekDay weekDay);

    public List<MovieDTO> findAllMoviesByLanguage(Language language);

    public List<MovieDTO> findAllMoviesByRestriction(AgeRestriction ageRestriction);

    public List<ScheduleDTO> findAllSchedule();



}
