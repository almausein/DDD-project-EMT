package mk.ukim.finki.emt.filmcatalog.services;

import mk.ukim.finki.emt.filmcatalog.domain.models.Film;
import mk.ukim.finki.emt.filmcatalog.domain.models.FilmId;
import mk.ukim.finki.emt.filmcatalog.services.form.FilmForm;

import java.util.List;

public interface FilmService {
    Film findById(FilmId id);
    Film createFilm(FilmForm form);
    Film reservationCreated(FilmId productId, int quantity);
    Film reservationRemoved(FilmId productId, int quantity);
    List<Film> getAll();

}
