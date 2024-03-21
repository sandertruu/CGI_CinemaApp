package com.cgi.cinemabackend.controller;

import com.cgi.cinemabackend.dto.MovieDTO;
import com.cgi.cinemabackend.models.filters.WeekDay;
import com.cgi.cinemabackend.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping("/allmovies")
    public List<MovieDTO> getAllMovies(){
        return movieService.findAllMovies();
    }

    @GetMapping("/movieinfo")
    public MovieDTO getMovieInformation(@RequestParam int id){
        return movieService.findMovieInfoById(id);
    }

    @GetMapping("/movies-by-weekday/{weekday}")
    public List<MovieDTO> getMoviesByWeekday(@PathVariable("weekday") String weekDay){
        WeekDay requested = WeekDay.valueOf(weekDay.toUpperCase());
        return movieService.findAllMoviesByWeekDay(requested);
    }
}
