package pl.cinema.cinema_project.models;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Getter
@Setter
@NoArgsConstructor
@Data
@Entity
@Table(name ="reservation")
public class Reservation {

    @Min(0)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @ManyToOne
    @JoinColumn(name = "movie_to_room_id")
    private MovieToRoom movieToRoom;

    @ManyToOne
    @JoinColumn(name= "price_list_id")
    private Price_list price_list;

    private int seat;

    private int rows;

    private String email;

    public Reservation(MovieToRoom movieToRoom, Price_list price_list, int seat, int rows, String email) {
        this.movieToRoom = movieToRoom;
        this.price_list = price_list;
        this.seat = seat;
        this.rows = rows;
        this.email = email;
    }
}
