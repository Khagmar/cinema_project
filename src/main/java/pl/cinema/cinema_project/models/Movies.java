package pl.cinema.cinema_project.models;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Getter
    @Setter
    @NoArgsConstructor
    @Data
    @Entity
    @Table(name ="movies")
    public class Movies {

        @Min(0)
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String type;
    @Lob
    @Column(length = 3000)
    private String description;
    private int year;
    private int month;
    private int day;



    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private Set<MovieToRoom> movies;

    public Movies(String name, String type, String description, int year, int month, int day, MovieToRoom... movies) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.year = year;
        this.month = month;
        this.day = day;
        /*this.movies = Stream.of(movies).collect(Collectors.toSet());
        this.movies.forEach(x->x.setMovie(this));*/
    }
}
