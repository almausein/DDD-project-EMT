package mk.ukim.finki.emt.reservationmodule.domain.models;

import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.Instant;
import java.time.LocalDateTime;

@Entity
@Table(name="reservation")
@Getter
public class Reservation extends AbstractEntity<ReservationId> {
    private Instant reservationDate;
    @OneToOne
    private Seat seat;

    public Reservation() {
        super(DomainObjectId.randomId(ReservationId.class));
    }



    public Reservation(@NonNull Instant reservationDate, @NonNull Seat seat) {
        super(DomainObjectId.randomId(ReservationId.class));
        this.reservationDate=reservationDate;
        this.seat = seat;
    }



}
