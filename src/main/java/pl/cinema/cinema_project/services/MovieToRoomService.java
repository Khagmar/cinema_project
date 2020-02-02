package pl.cinema.cinema_project.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.cinema.cinema_project.models.MovieToRoom;

public interface MovieToRoomService {

    Page<MovieToRoom> getALLMovieToRoom(Pageable pageable);

    MovieToRoom getMovieToRoom(int id);
}
