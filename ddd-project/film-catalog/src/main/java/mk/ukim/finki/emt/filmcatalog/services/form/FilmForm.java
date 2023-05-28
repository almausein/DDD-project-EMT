package mk.ukim.finki.emt.filmcatalog.services.form;

import lombok.Data;
import mk.ukim.finki.emt.filmcatalog.domain.valueobjects.FilmDescription;

@Data
public class FilmForm{
    private String filmName;
    private FilmDescription filmDescription;
    private int tickets_Sold;
}
