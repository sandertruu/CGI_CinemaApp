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

    //Aitab muuta andmebaasi kirje DTOks
    @Autowired
    private ModelMapper modelMapper;

    /**
     * leiab kõik filmid andmebaasist, ning tagastab DTO objektide listi
     * @return DTO list
     */
    @Override
    public List<MovieDTO> findAllMovies() {
        List<Movie> moviesdata = movieRepository.findAll();
        List<MovieDTO> movies = moviesdata.stream()
                .map(movie -> modelMapper.map(movie, MovieDTO.class))
                .collect(Collectors.toList());

        return movies;
    }

    /**
     * leiab filmi informatsiooni id järgi, kasutamata meetod
     * @param id filmi id
     * @return filmi DTO
     */
    @Override
    public MovieDTO findMovieInfoById(int id) {
        Optional<Movie> movie = movieRepository.findById(Long.valueOf(id));
        return modelMapper.map(movie, MovieDTO.class);
    }

    /**
     * leiab kõik filmid päeva järgi
     * @param weekDay etteantud nädalapäev
     * @return list filmidest sellel nädalapäeval
     */
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

    /**
     * leiab kõik filmid vastavas keeles
     * @param language etteantud keel
     * @return list selles keeles filmidest
     */
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

    /**
     * leiab kõik filmid vastava vanusepiiranguga
     * @param ageRestriction etteantud vanusepiirang
     * @return list selle piiranguga filmidest
     */
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

    /**
     * annab ajakava, kus igale aeg on seotud mingi filmiga läbi filmi id
     * @return list ajakavast
     */
    @Override
    public List<ScheduleDTO> findAllSchedule() {
        List<Schedule> scheduleList = scheduleRepository.findAll();
        List<ScheduleDTO> schedule = scheduleList.stream()
                .map(scheduleItem -> modelMapper.map(scheduleItem, ScheduleDTO.class))
                .collect(Collectors.toList());

        return schedule;
    }


}
