//package mk.ukim.finki.emt.sharedkernel.domain.events.reservations;
//
//import mk.ukim.finki.emt.sharedkernel.domain.config.TopicHolder;
//import mk.ukim.finki.emt.sharedkernel.domain.events.DomainEvent;
//
//public class ReservationCreated extends DomainEvent {
//    private String FilmId;
//    private String SeatId;
//
//    public OrderItemCreated(String topic) {
//        super(TopicHolder.TOPIC_ORDER_ITEM_CREATED);
//    }
//
//    public OrderItemCreated(String productId, String quantity) {
//        super(TopicHolder.TOPIC_ORDER_ITEM_CREATED);
//        this.FilmId = productId;
//        this.SeatId = quantity;
//    }
//}
