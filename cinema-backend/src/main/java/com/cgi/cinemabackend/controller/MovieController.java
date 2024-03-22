package com.cgi.cinemabackend.controller;

import com.cgi.cinemabackend.dto.MovieDTO;
import com.cgi.cinemabackend.dto.ScheduleDTO;
import com.cgi.cinemabackend.models.Schedule;
import com.cgi.cinemabackend.models.filters.AgeRestriction;
import com.cgi.cinemabackend.models.filters.Language;
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

    @GetMapping("/movieinfo/{id}")
    public MovieDTO getMovieInformation(@PathVariable("id") int id){
        return movieService.findMovieInfoById(id);
    }

    @GetMapping("/movies-by-weekday/{weekday}")
    public List<MovieDTO> getMoviesByWeekday(@PathVariable("weekday") String weekDay){
        WeekDay requested = WeekDay.valueOf(weekDay.toUpperCase());
        return movieService.findAllMoviesByWeekDay(requested);
    }

    @GetMapping("/movies-by-language/{language}")
    public List<MovieDTO> getMoviesByLanguage(@PathVariable("language") String language){
        Language requested = Language.valueOf(language.toUpperCase());
        System.out.println(requested);
        return movieService.findAllMoviesByLanguage(requested);
    }

    @GetMapping("/movies-by-restriction/{restriction}")
    public List<MovieDTO> getMoviesByRestriction(@PathVariable("restriction") String restriction){
        AgeRestriction requested = AgeRestriction.valueOf(restriction.toUpperCase());
        return movieService.findAllMoviesByRestriction(requested);
    }

    @GetMapping("/schedule")
    public List<ScheduleDTO> getSchedule(){
        return movieService.findAllSchedule();
    }
}
