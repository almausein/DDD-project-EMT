package mk.ukim.finki.emt.theatercatalog.domain.models;

import org.springframework.lang.NonNull;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

public class TheaterId extends DomainObjectId {
    private TheaterId() {
        super(TheaterId.randomId(TheaterId.class).getId());
    }

    public TheaterId(@NonNull String uuid) {
        super(uuid);
    }

    public static TheaterId of(String uuid) {
        TheaterId p = new TheaterId(uuid);
        return p;
    }

}
