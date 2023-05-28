package mk.ukim.finki.emt.reservationmodule.service.forms;

import lombok.Data;
import mk.ukim.finki.emt.reservationmodule.domain.models.Film_projection;
import mk.ukim.finki.emt.reservationmodule.domain.models.SeatId;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.Instant;

@Data
public class ReservationForm {
    @NotNull
    private SeatId seatId;

    @NotNull
    private Instant timeOfProjection;

}
