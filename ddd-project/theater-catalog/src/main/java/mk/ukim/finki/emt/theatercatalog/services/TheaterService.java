package mk.ukim.finki.emt.theatercatalog.services;

import mk.ukim.finki.emt.theatercatalog.domain.models.Theater;
import mk.ukim.finki.emt.theatercatalog.domain.models.TheaterId;
import mk.ukim.finki.emt.theatercatalog.services.form.TheaterForm;

import java.util.List;

public interface TheaterService {
    Theater findById(TheaterId id);
    Theater createTheater(TheaterForm form);
    List<Theater> getAll();
}
