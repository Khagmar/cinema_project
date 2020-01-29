package pl.cinema.cinema_project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.cinema.cinema_project.models.Price_list;

@Repository
public interface Price_listRepository extends JpaRepository<Price_list, Integer> {
    Price_list findById(int id);
}
