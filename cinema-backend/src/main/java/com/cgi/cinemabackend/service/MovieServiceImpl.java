package com.cgi.cinemabackend.service;

import com.cgi.cinemabackend.dto.MovieDTO;
import com.cgi.cinemabackend.dto.ScheduleDTO;
import com.cgi.cinemabackend.models.Movie;
import com.cgi.cinemabackend.models.Schedule;
import com.cgi.cinemabackend.models.filters.WeekDay;
import com.cgi.cinemabackend.repository.MovieRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService{
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<MovieDTO> findAllMovies() {
        List<Movie> moviesdata = movieRepository.findAll();
        List<MovieDTO> movies = moviesdata.stream()
                .map(movie -> modelMapper.map(movie, MovieDTO.class))
                .collect(Collectors.toList());

        return movies;
    }

    @Override
    public MovieDTO findMovieInfoById(int id) {
        Optional<Movie> movie = movieRepository.findById(Long.valueOf(id));
        return modelMapper.map(movie, MovieDTO.class);
    }

    @Override
    public List<MovieDTO> findAllMoviesByWeekDay(WeekDay weekDay) {
        List<Movie> movieList = movieRepository.findAll();
        List<Movie> moviesOnThisDay = new ArrayList<>();
        for (Movie movie : movieList) {
            List<Schedule> scheduleList = movie.getSchedule();
            for (Schedule schedule : scheduleList) {
                if (schedule.getWeekDay() == weekDay){
                    moviesOnThisDay.add(movie);
                    break;
                }
            }
        }
        List<MovieDTO> movieDTOS = moviesOnThisDay.stream()
                .map(movie -> modelMapper.map(movie, MovieDTO.class))
                .collect(Collectors.toList());
        return movieDTOS;
    }
}
