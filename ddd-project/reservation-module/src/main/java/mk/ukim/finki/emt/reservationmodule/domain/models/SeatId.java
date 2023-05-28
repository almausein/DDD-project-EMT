package mk.ukim.finki.emt.reservationmodule.domain.models;

import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

public class SeatId extends DomainObjectId {
    private SeatId() {
        super(ReservationId.randomId(ReservationId.class).getId());
    }

    public SeatId(String uuid) {
        super(uuid);
    }
}
