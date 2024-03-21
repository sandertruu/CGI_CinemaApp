package com.cgi.cinemabackend.service;

import com.cgi.cinemabackend.dto.MovieDTO;
import com.cgi.cinemabackend.models.filters.WeekDay;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MovieService {
    public List<MovieDTO> findAllMovies();

    public MovieDTO findMovieInfoById(int id);

    public List<MovieDTO> findAllMoviesByWeekDay(WeekDay weekDay);

}
