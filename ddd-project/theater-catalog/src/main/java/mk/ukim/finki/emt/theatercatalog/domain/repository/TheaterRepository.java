package mk.ukim.finki.emt.theatercatalog.domain.repository;

import mk.ukim.finki.emt.theatercatalog.domain.models.Theater;
import mk.ukim.finki.emt.theatercatalog.domain.models.TheaterId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheaterRepository extends JpaRepository<Theater, TheaterId> {
}
