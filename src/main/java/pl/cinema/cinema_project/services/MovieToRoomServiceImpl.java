package pl.cinema.cinema_project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.cinema.cinema_project.models.MovieToRoom;
import pl.cinema.cinema_project.repositories.MovieToRoomRepository;

@Service
public class MovieToRoomServiceImpl implements MovieToRoomService {

    @Autowired
    MovieToRoomRepository movieToRoomRepository;

    @Override
    public Page<MovieToRoom> getALLMovieToRoom(Pageable pageable) {
        return movieToRoomRepository.findAll(pageable);
    }

    @Override
    public MovieToRoom getMovieToRoom(int id) {
        MovieToRoom p = movieToRoomRepository.findById(id);
        return p;
    }
}
