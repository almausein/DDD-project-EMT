package mk.ukim.finki.emt.reservationmodule.domain.models;

import lombok.Getter;
import mk.ukim.finki.emt.reservationmodule.domain.valueobjects.TheaterId;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="seat")
@Getter
public class Seat extends AbstractEntity<SeatId> {
    private Integer seat_number;
    private TheaterId theaterId;
}
