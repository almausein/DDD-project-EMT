package mk.ukim.finki.emt.reservationmodule.domain.valueobjects;

import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObject;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;
import net.bytebuddy.dynamic.DynamicType;

import javax.persistence.Embeddable;

@Embeddable
public class FilmId extends DomainObjectId {
    private FilmId() {
        super(FilmId.randomId(FilmId.class).getId());
    }

    public FilmId(String uuid) {
        super(uuid);
    }


}
