package mk.ukim.finki.emt.filmcatalog.xport.rest;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.filmcatalog.domain.models.Film;
import mk.ukim.finki.emt.filmcatalog.services.FilmService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/film")
@AllArgsConstructor

public class FilmResource {
    private final FilmService filmService;

    @GetMapping
    public List<Film> getAll() {
        return filmService.getAll();
    }

}
