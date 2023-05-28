package mk.ukim.finki.emt.filmcatalog.domain.models;

import mk.ukim.finki.emt.filmcatalog.domain.valueobjects.FilmDescription;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "film")
public class Film extends AbstractEntity<FilmId> {

    private String film_name;

    private FilmDescription description;

    private int tickets_sold=0;

    private Film() {
        super(FilmId.randomId(FilmId.class));
    }



    public static Film build(String filmName, FilmDescription filmDescription, int tickets_sold) {
        Film p = new Film();
        p.film_name = filmName;
        p.description = filmDescription;
        p.tickets_sold = tickets_sold;
        return p;
    }

    public void addSales(int qty) {
        this.tickets_sold = this.tickets_sold - qty;
    }

    public void removeSales(int qty) {
        this.tickets_sold -= qty;
    }


}
