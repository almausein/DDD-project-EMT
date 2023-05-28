package mk.ukim.finki.emt.reservationmodule.domain.repository;

import mk.ukim.finki.emt.reservationmodule.domain.models.FilmProjectionId;
import mk.ukim.finki.emt.reservationmodule.domain.models.Film_projection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmProjectionRepository extends JpaRepository<Film_projection, FilmProjectionId> {
}
