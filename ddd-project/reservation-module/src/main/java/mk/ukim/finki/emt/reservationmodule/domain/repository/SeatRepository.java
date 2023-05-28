package mk.ukim.finki.emt.reservationmodule.domain.repository;

import mk.ukim.finki.emt.reservationmodule.domain.models.Seat;
import mk.ukim.finki.emt.reservationmodule.domain.models.SeatId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepository extends JpaRepository<Seat, SeatId> {
}
