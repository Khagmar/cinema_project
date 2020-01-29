package pl.cinema.cinema_project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.cinema.cinema_project.models.MovieToRoom;

public interface MovieToRoomRepository extends JpaRepository<MovieToRoom, Integer> {
}
