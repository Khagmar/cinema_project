package pl.cinema.cinema_project.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.cinema.cinema_project.models.MovieToRoom;

@Repository
public interface MovieToRoomRepository extends JpaRepository<MovieToRoom, Integer> {

    Page<MovieToRoom> findAll(Pageable pageable);

    MovieToRoom findById(int id);
}
