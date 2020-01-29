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
@Table(name ="rooms")
public class Room {


    @Min(0)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int rows;
    private int place;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private Set<MovieToRoom> rooms;

    public Room(int id, int rows, int place, MovieToRoom... rooms) {
        this.id = id;
        this.rows = rows;
        this.place = place;
        this.rooms = Stream.of(rooms).collect(Collectors.toSet());
        this.rooms.forEach(x->x.setRoom(this));
    }
}
