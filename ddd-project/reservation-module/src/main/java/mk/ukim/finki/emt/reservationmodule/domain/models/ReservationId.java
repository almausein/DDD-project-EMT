package mk.ukim.finki.emt.reservationmodule.domain.models;

import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

@Getter
public class ReservationId extends DomainObjectId {
    private ReservationId() {
        super(ReservationId.randomId(ReservationId.class).getId());
    }

    public ReservationId(String uuid) {
        super(uuid);
    }

}
