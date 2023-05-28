package mk.ukim.finki.emt.filmcatalog.services.impl;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.filmcatalog.domain.exception.FilmIdNotFoundException;
import mk.ukim.finki.emt.filmcatalog.domain.models.Film;
import mk.ukim.finki.emt.filmcatalog.domain.models.FilmId;
import mk.ukim.finki.emt.filmcatalog.domain.repository.FilmRepository;
import mk.ukim.finki.emt.filmcatalog.services.FilmService;
import mk.ukim.finki.emt.filmcatalog.services.form.FilmForm;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class FilmServiceImpl implements FilmService
{
    private final FilmRepository filmRepository;
    @Override
    public Film findById(FilmId id) {
        return this.filmRepository.findById(id).orElseThrow(FilmIdNotFoundException::new);
    }

    @Override
    public Film createFilm(FilmForm form) {
        Film p = Film.build(form.getFilmName(),form.getFilmDescription(),form.getTickets_Sold());
        filmRepository.save(p);
        return p;

    }

    @Override
    public Film reservationCreated(FilmId productId, int quantity) {
        Film p = filmRepository.findById(productId).orElseThrow(FilmIdNotFoundException::new);
        p.addSales(quantity);
        filmRepository.saveAndFlush(p);
        return p;

    }

    @Override
    public Film reservationRemoved(FilmId productId, int quantity) {
        Film p = filmRepository.findById(productId).orElseThrow(FilmIdNotFoundException::new);
        p.removeSales(quantity);
        filmRepository.saveAndFlush(p);
        return p;

    }

    @Override
    public List<Film> getAll() {
        return this.filmRepository.findAll();
    }
}
