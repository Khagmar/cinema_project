package pl.cinema.cinema_project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.cinema.cinema_project.exceptions.ReservationNotFoundException;
import pl.cinema.cinema_project.models.Reservation;
import pl.cinema.cinema_project.repositories.ReservationRepository;

import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public Page<Reservation> getALLReservation(Pageable pageable) {
        return reservationRepository.findAll(pageable);
    }

    @Override
    public Reservation getReservation(int id) {
        Optional<Reservation> optionalReservation = reservationRepository.findById(id);
        Reservation reservation = optionalReservation.orElseThrow(()-> new ReservationNotFoundException(id));
        return reservation;
    }

    @Override
    public void saveReservation(Reservation reservation) {
        reservationRepository.save(reservation);
    }
}
