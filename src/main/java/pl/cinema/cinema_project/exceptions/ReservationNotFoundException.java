package pl.cinema.cinema_project.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No such reservation")
public class ReservationNotFoundException extends  RuntimeException{
    public ReservationNotFoundException() {super(String.format("Rezerwacja nie istnieje"));}

    public ReservationNotFoundException(int id) {
        super(String.format("Rezerwacja o id %d nie istnieje", id));
    }
}
