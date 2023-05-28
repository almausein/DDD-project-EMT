package mk.ukim.finki.emt.reservationmodule.service;

import mk.ukim.finki.emt.reservationmodule.domain.exceptions.FilmProjectionIdDoesNotExist;
import mk.ukim.finki.emt.reservationmodule.domain.exceptions.ReservationIdDoesntExist;
import mk.ukim.finki.emt.reservationmodule.domain.models.FilmProjectionId;
import mk.ukim.finki.emt.reservationmodule.domain.models.Film_projection;
import mk.ukim.finki.emt.reservationmodule.domain.models.Reservation;
import mk.ukim.finki.emt.reservationmodule.domain.models.ReservationId;
import mk.ukim.finki.emt.reservationmodule.service.forms.FilmProjectionForm;
import mk.ukim.finki.emt.reservationmodule.service.forms.ReservationForm;

import java.util.List;
import java.util.Optional;

public interface FilmProjectionService {
    FilmProjectionId placeOrder(FilmProjectionForm reservationForm);

    List<Film_projection> findAll();

    Optional<Film_projection> findById(FilmProjectionId id);

    void addItem(FilmProjectionId filmProjectionId, ReservationForm reservationForm) throws FilmProjectionIdDoesNotExist;

    void deleteItem(FilmProjectionId filmProjectionId, ReservationId reservationId) throws FilmProjectionIdDoesNotExist, ReservationIdDoesntExist;

    Film_projection toDomainObject(FilmProjectionForm filmProjectionForm);
}
