package mk.ukim.finki.emt.theatercatalog.services.impl;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.theatercatalog.domain.exceptions.TheaterNotFoundException;
import mk.ukim.finki.emt.theatercatalog.domain.models.Theater;
import mk.ukim.finki.emt.theatercatalog.domain.models.TheaterId;
import mk.ukim.finki.emt.theatercatalog.domain.repository.TheaterRepository;
import mk.ukim.finki.emt.theatercatalog.services.TheaterService;
import mk.ukim.finki.emt.theatercatalog.services.form.TheaterForm;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
@AllArgsConstructor
public class TheaterServiceImpl implements TheaterService {
    private final TheaterRepository theaterRepository;

    @Override
    public Theater findById(TheaterId id) {
        return this.theaterRepository.findById(id).orElseThrow(TheaterNotFoundException::new);
    }

    @Override
    public Theater createTheater(TheaterForm form) {
        Theater p = Theater.build(form.getTheaterName());
        theaterRepository.save(p);
        return p;
    }

    @Override
    public List<Theater> getAll() {
        return null;
    }
}
