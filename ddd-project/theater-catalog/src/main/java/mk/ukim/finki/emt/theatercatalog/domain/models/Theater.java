package mk.ukim.finki.emt.theatercatalog.domain.models;

import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "theater")
public class Theater extends AbstractEntity<TheaterId> {
    private String theaterName;

    private Theater() {
        super(TheaterId.randomId(TheaterId.class));
    }

    public static Theater build(String TheaterName) {
        Theater p = new Theater();
        p.theaterName = TheaterName;
        return p;
    }

}
