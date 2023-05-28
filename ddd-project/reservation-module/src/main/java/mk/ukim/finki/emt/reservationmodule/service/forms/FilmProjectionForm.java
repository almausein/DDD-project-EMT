package mk.ukim.finki.emt.reservationmodule.service.forms;

import lombok.Data;
import mk.ukim.finki.emt.reservationmodule.domain.valueobjects.Currency;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
public class FilmProjectionForm {
    @Valid
    @NotEmpty
    private List<ReservationForm> items = new ArrayList<>();

}
