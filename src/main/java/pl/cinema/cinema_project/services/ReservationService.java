package pl.cinema.cinema_project.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.cinema.cinema_project.models.Reservation;

public interface ReservationService {

    Page<Reservation> getALLReservation(Pageable pageable);
}
