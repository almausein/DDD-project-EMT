package mk.ukim.finki.emt.filmcatalog.domain.repository;

import mk.ukim.finki.emt.filmcatalog.domain.models.Film;
import mk.ukim.finki.emt.filmcatalog.domain.models.FilmId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends JpaRepository<Film, FilmId> {
}
