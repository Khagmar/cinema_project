package pl.cinema.cinema_project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.cinema.cinema_project.models.Room;

public interface RoomRepository extends JpaRepository<Room, Integer> {
}
