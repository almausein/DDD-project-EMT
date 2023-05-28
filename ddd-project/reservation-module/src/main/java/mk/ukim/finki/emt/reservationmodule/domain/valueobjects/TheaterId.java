package mk.ukim.finki.emt.reservationmodule.domain.valueobjects;

import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class TheaterId extends DomainObjectId {
    private TheaterId() {
        super(FilmId.randomId(FilmId.class).getId());
    }

    public TheaterId(String uuid) {
        super(uuid);
    }
}
