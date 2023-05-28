package mk.ukim.finki.emt.filmcatalog.domain.models;

import org.springframework.lang.NonNull;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

public class FilmId extends DomainObjectId {
    private FilmId() {
        super(FilmId.randomId(FilmId.class).getId());
    }

    public FilmId(@NonNull String uuid) {
        super(uuid);
    }

    public static FilmId of(String uuid) {
        FilmId p = new FilmId(uuid);
        return p;
    }

}
