package pl.cinema.cinema_project.models;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.text.SimpleDateFormat;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
@Setter
@NoArgsConstructor
@Data
@Entity
@Table(name ="movie_to_room")
public class MovieToRoom {

    @Min(0)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movies movie;

    @OneToMany(mappedBy = "movieToRoom", cascade = CascadeType.ALL)
    private Set<Reservation> moviesToRooms;


    private int day_rez;

    private int month_rez;

    private int year_rez;

    private int hour_rez;

    private int min_rez;

    public MovieToRoom(Room room, Movies movie, int day_rez, int month_rez, int year_rez, int hour_rez, int min_rez, Reservation... moviesToRooms) {
        this.room = room;
        this.movie = movie;
        this.day_rez = day_rez;
        this.month_rez = month_rez;
        this.year_rez = year_rez;
        this.hour_rez = hour_rez;
        this.min_rez = min_rez;

        this.moviesToRooms = Stream.of(moviesToRooms).collect(Collectors.toSet());
        this.moviesToRooms.forEach(x->x.setMovieToRoom(this));
    }
}
