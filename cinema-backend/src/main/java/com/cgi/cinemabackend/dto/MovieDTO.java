package com.cgi.cinemabackend.dto;


import com.cgi.cinemabackend.models.filters.AgeRestriction;
import com.cgi.cinemabackend.models.filters.Genre;
import com.cgi.cinemabackend.models.filters.Language;
import lombok.*;


import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MovieDTO {

        private Long id;
        private String name;
        private Genre genre;
        private AgeRestriction ageRestriction;
        private Language language;
        private List<ScheduleDTO> schedule= new ArrayList<ScheduleDTO>();

}
