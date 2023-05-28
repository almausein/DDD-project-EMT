package mk.ukim.finki.emt.reservationmodule.domain.models;

import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

public class FilmProjectionId extends DomainObjectId {
    private FilmProjectionId() {
        super(FilmProjectionId.randomId(FilmProjectionId.class).getId());
    }

    public FilmProjectionId(String uuid) {
        super(uuid);
    }

}
