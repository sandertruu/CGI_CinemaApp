package com.cgi.cinemabackend;

import com.cgi.cinemabackend.models.Movie;
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

@Component
public class DatabaseInitializer implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Movie[] movies = {
                new Movie(1L,"Avatar", THRILLER, ALLA_6, ENGLISH, null),
                new Movie(1L,"Transporter", ACTION, ALLA_12, ENGLISH, null),
                new Movie(1L,"The Conjuring", HORROR, ALLA_14_KEELATUD, ENGLISH, null),
                new Movie(1L,"Kung-Fu Panda 4", ANIMATION, PEREFILM, ESTONIAN, null),
                new Movie(1L,"Interstellar", SCIFI, LUBATUD_KOIGILE, ENGLISH, null),
                new Movie(1L,"Tõde ja Õigus", DRAMA, LUBATUD_KOIGILE, RUSSIAN, null),
                new Movie(1L,"Harry Potter & The Chamber of Secrets", FAMILY, PEREFILM, ENGLISH, null),
                new Movie(1L,"Steve Jobs: The Man in the Machine", DOCUMENTARY, ALLA_12_KEELATUD, ENGLISH, null),
                new Movie(1L,"Free Guy", COMEDY, LUBATUD_KOIGILE, ENGLISH, null)};

        for (Movie movie : movies) {
            try {
                insertMovie(movie);
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

}
