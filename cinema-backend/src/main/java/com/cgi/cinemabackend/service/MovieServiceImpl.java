package com.cgi.cinemabackend.service;

import com.cgi.cinemabackend.dto.MovieDTO;
import com.cgi.cinemabackend.dto.ScheduleDTO;
import com.cgi.cinemabackend.models.Movie;
import com.cgi.cinemabackend.models.Schedule;
import com.cgi.cinemabackend.models.filters.AgeRestriction;
import com.cgi.cinemabackend.models.filters.Language;
import com.cgi.cinemabackend.models.filters.WeekDay;
import com.cgi.cinemabackend.repository.MovieRepository;
import com.cgi.cinemabackend.repository.ScheduleRepository;
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
    ScheduleRepository scheduleRepository;
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
        List<Schedule> schedule = scheduleRepository.findAll();
        List<Optional<Movie>> moviesOnThisDay = new ArrayList<>();
        for (Schedule time : schedule) {
            if (time.getWeekDay()==weekDay){
                moviesOnThisDay.add(movieRepository.findById(time.getMovieId()));
            }
        }
        List<MovieDTO> movieDTOS = moviesOnThisDay.stream()
                .map(movie -> modelMapper.map(movie, MovieDTO.class))
                .collect(Collectors.toList());
        return movieDTOS;
    }

    @Override
    public List<MovieDTO> findAllMoviesByLanguage(Language language) {
        List<Movie> movieList = movieRepository.findAll();
        List<Movie> moviesWithThisLanguage = new ArrayList<>();
        for (Movie movie : movieList) {
            if (movie.getLanguage()==language){
                moviesWithThisLanguage.add(movie);
            }
        }
        List<MovieDTO> movieDTOS = moviesWithThisLanguage.stream()
                .map(movie -> modelMapper.map(movie, MovieDTO.class))
                .collect(Collectors.toList());
        return movieDTOS;
    }

    @Override
    public List<MovieDTO> findAllMoviesByRestriction(AgeRestriction ageRestriction) {
        List<Movie> movieList = movieRepository.findAll();
        List<Movie> moviesWithThisRestriction = new ArrayList<>();
        for (Movie movie : movieList) {
            if (movie.getAgeRestriction()==ageRestriction){
                moviesWithThisRestriction.add(movie);
            }
        }
        List<MovieDTO> movieDTOS = moviesWithThisRestriction.stream()
                .map(movie -> modelMapper.map(movie, MovieDTO.class))
                .collect(Collectors.toList());
        return movieDTOS;
    }

    @Override
    public List<ScheduleDTO> findAllSchedule() {
        List<Schedule> scheduleList = scheduleRepository.findAll();
        List<ScheduleDTO> schedule = scheduleList.stream()
                .map(scheduleItem -> modelMapper.map(scheduleItem, ScheduleDTO.class))
                .collect(Collectors.toList());

        return schedule;
    }


}
