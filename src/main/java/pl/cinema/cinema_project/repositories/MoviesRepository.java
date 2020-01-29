package pl.cinema.cinema_project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.cinema.cinema_project.models.Movies;


@Repository
public interface MoviesRepository extends JpaRepository<Movies, Integer> {
}
