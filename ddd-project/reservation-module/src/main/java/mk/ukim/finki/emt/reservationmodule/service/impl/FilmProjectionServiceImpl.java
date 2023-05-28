package mk.ukim.finki.emt.reservationmodule.service.impl;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.reservationmodule.domain.exceptions.FilmProjectionIdDoesNotExist;
import mk.ukim.finki.emt.reservationmodule.domain.exceptions.ReservationIdDoesntExist;
import mk.ukim.finki.emt.reservationmodule.domain.models.FilmProjectionId;
import mk.ukim.finki.emt.reservationmodule.domain.models.Film_projection;
import mk.ukim.finki.emt.reservationmodule.domain.models.Reservation;
import mk.ukim.finki.emt.reservationmodule.domain.models.ReservationId;
import mk.ukim.finki.emt.reservationmodule.domain.repository.FilmProjectionRepository;
import mk.ukim.finki.emt.reservationmodule.domain.repository.SeatRepository;
import mk.ukim.finki.emt.reservationmodule.service.FilmProjectionService;
import mk.ukim.finki.emt.reservationmodule.service.forms.FilmProjectionForm;
import mk.ukim.finki.emt.reservationmodule.service.forms.ReservationForm;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.validation.Validator;
import javax.validation.ConstraintViolationException;

@Service
@Transactional
@AllArgsConstructor
public class FilmProjectionServiceImpl implements FilmProjectionService {

    private final FilmProjectionRepository filmProjectionRepository;
    private final SeatRepository seatRepository;
//    private final DomainEventPublisher domainEventPublisher;
    private final Validator validator;

    @Override
    public FilmProjectionId placeOrder(FilmProjectionForm filmProjectionForm) {
        Objects.requireNonNull(filmProjectionForm,"order must not be null.");
        var constraintViolations = validator.validate(filmProjectionForm);
        if (constraintViolations.size()>0) {
            throw new ConstraintViolationException("The order form is not valid", constraintViolations);
        }
        var newOrder = filmProjectionRepository.saveAndFlush(toDomainObject(filmProjectionForm));
//        newOrder.getReservations().forEach(item->domainEventPublisher.publish(new OrderItemCreated(item.getProductId().getId(),item.getQuantity())));
//        return newOrder.getId();
        return newOrder.getId();

    }

    @Override
    public List<Film_projection> findAll() {
        return filmProjectionRepository.findAll();
    }

    @Override
    public Optional<Film_projection> findById(FilmProjectionId id) {
        return filmProjectionRepository.findById(id);
    }

    @Override
    public void addItem(FilmProjectionId filmProjectionId, ReservationForm reservationForm) {
        Film_projection film_projection = filmProjectionRepository.findById(filmProjectionId).orElseThrow(FilmProjectionIdDoesNotExist::new);
        film_projection.addItem(seatRepository.findById(reservationForm.getSeatId()).get(),reservationForm.getTimeOfProjection());
        filmProjectionRepository.saveAndFlush(film_projection);
//        domainEventPublisher.publish(new OrderItemCreated(orderItemForm.getProduct().getId().getId(),orderItemForm.getQuantity()));


    }

    @Override
    public void deleteItem(FilmProjectionId film_projection, ReservationId reservationId) throws FilmProjectionIdDoesNotExist, ReservationIdDoesntExist {
        Film_projection filmProjection = filmProjectionRepository.findById(film_projection).orElseThrow(FilmProjectionIdDoesNotExist::new);
        filmProjection.removeItem(reservationId);
        filmProjectionRepository.saveAndFlush(filmProjection);

    }

    @Override
    public Film_projection toDomainObject(FilmProjectionForm filmProjectionForm) {
        var order = new Film_projection();
        filmProjectionForm.getItems().forEach(item->order.addItem(seatRepository.findById(item.getSeatId()).get(),Instant.now()));
        return order;

    }
}
