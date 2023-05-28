package mk.ukim.finki.emt.reservationmodule.domain.models;

import lombok.NonNull;
import mk.ukim.finki.emt.reservationmodule.domain.valueobjects.FilmId;
import mk.ukim.finki.emt.reservationmodule.domain.valueobjects.Money;
import mk.ukim.finki.emt.reservationmodule.domain.valueobjects.TheaterId;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "film_projection")
public class Film_projection extends AbstractEntity<FilmProjectionId> {


    private Money price_for_ticket;
    private Instant start_time;
    private Instant end_time;

    @AttributeOverride(name="id", column=@Column(name = "film_id", nullable = false))
    private FilmId filmId;
    @AttributeOverride(name="id", column=@Column(name = "theater_id", nullable = false))
    private TheaterId theaterId;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Reservation> reservations;
    @AttributeOverrides({@AttributeOverride(name="amount", column = @Column(name = "total_amountEarned", nullable = false)),
                        @AttributeOverride(name="currency", column=@Column(name="total_amountCurrency", nullable = false))})
    private Money totalProfitFromProjection;

    public Film_projection() {
        super(FilmProjectionId.randomId(FilmProjectionId.class));
    }

    public Money total() {
        return price_for_ticket.multiply(reservations.size());
    }

    //ko dodavam element od film proekcija- dodavam rezervacija. Rez e opredelena so Seat  i vreme na rezervacija,
    //nemam potreba od vrednosen objekt oti seat e u ist bounded context so reservation.
    //zatava ne sum pravila poseben value object za seat
    public Reservation addItem(@NonNull Seat seat, @NonNull Instant timeReservation) {
        Objects.requireNonNull(seat,"reservation must not be null");
        var item  = new Reservation(timeReservation, seat);
        reservations.add(item);
        return item;
    }

    public void removeItem(@NonNull ReservationId reservationId) {
        Objects.requireNonNull(reservationId,"Order Item must not be null");
        reservations.removeIf(v->v.getId().equals(reservationId));
    }



}
