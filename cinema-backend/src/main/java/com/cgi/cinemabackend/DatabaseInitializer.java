package com.cgi.cinemabackend;

import com.cgi.cinemabackend.models.Movie;
import com.cgi.cinemabackend.models.Schedule;
import com.cgi.cinemabackend.models.filters.WeekDay;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import static com.cgi.cinemabackend.models.filters.AgeRestriction.*;
import static com.cgi.cinemabackend.models.filters.Genre.*;
import static com.cgi.cinemabackend.models.filters.Language.*;
import static com.cgi.cinemabackend.models.filters.StartTime.*;

@Component
public class DatabaseInitializer implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Movie[] movies = {
                new Movie(1L,"Avatar", THRILLER, ALLA_6, ENGLISH),
                new Movie(2L,"Transporter", ACTION, ALLA_12, ENGLISH),
                new Movie(3L,"The Conjuring", HORROR, ALLA_14_KEELATUD, ENGLISH),
                new Movie(4L,"Kung-Fu Panda 4", ANIMATION, PEREFILM, ESTONIAN),
                new Movie(5L,"Interstellar", SCIFI, LUBATUD_KOIGILE, ENGLISH),
                new Movie(6L,"Tõde ja Õigus", DRAMA, LUBATUD_KOIGILE, RUSSIAN),
                new Movie(7L,"Harry Potter & The Chamber of Secrets", FAMILY, PEREFILM, ENGLISH),
                new Movie(8L,"Steve Jobs: The Man in the Machine", DOCUMENTARY, ALLA_12_KEELATUD, ENGLISH),
                new Movie(9L,"Free Guy", COMEDY, LUBATUD_KOIGILE, ENGLISH)};

        Schedule[] schedule = {
                new Schedule(1L, 4L, TIME_12_00, WeekDay.TUESDAY),
                new Schedule(2L, 3L, TIME_13_00, WeekDay.WEDNESDAY),
                new Schedule(3L, 2L, TIME_14_00, WeekDay.FRIDAY),
                new Schedule(4L, 7L, TIME_14_00, WeekDay.WEDNESDAY),
                new Schedule(5L, 1L, TIME_9_00, WeekDay.SUNDAY),
                new Schedule(6L, 5L, TIME_19_00, WeekDay.MONDAY),
                new Schedule(7L, 9L, TIME_10_00, WeekDay.MONDAY),
                new Schedule(8L, 6L, TIME_10_00, WeekDay.MONDAY),
                new Schedule(9L, 8L, TIME_15_00, WeekDay.SATURDAY),

        };

        for (Movie movie : movies) {
            try {
                insertMovie(movie);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        for (Schedule schedule1 : schedule) {
            try {
                insertSchedule(schedule1);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }


    public void insertMovie(Movie movie) throws SQLException {

        String query = "INSERT INTO movies(name, genre, age_restriction, language) VALUES (?,?,?,?)";

        Connection con = DriverManager.getConnection("jdbc:h2:mem:cinemadb", "admin", "admin");
        PreparedStatement stmt = con.prepareStatement(query);

        stmt.setString(1, movie.getName());
        stmt.setInt(2, movie.getGenre().getId()-1);
        stmt.setInt(3, movie.getAgeRestriction().getId()-1);
        stmt.setInt(4, movie.getLanguage().getId()-1);

        stmt.executeUpdate();
        con.close();

    }

    public void insertSchedule(Schedule schedule) throws SQLException {

        String query = "INSERT INTO schedule(movie_id, start_time, weekday) VALUES (?,?,?)";

        Connection con = DriverManager.getConnection("jdbc:h2:mem:cinemadb", "admin", "admin");
        PreparedStatement stmt = con.prepareStatement(query);

        stmt.setLong(1, schedule.getMovieId());
        stmt.setInt(2, schedule.getStartTime().getId()-1);
        stmt.setInt(3, schedule.getWeekDay().getId()-1);

        stmt.executeUpdate();
        con.close();

    }

}
