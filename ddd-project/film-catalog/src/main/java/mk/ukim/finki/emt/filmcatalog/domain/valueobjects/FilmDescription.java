package mk.ukim.finki.emt.filmcatalog.domain.valueobjects;

import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.filmcatalog.domain.models.Film;
import mk.ukim.finki.emt.filmcatalog.domain.models.Genre;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
@Getter
public class FilmDescription implements ValueObject {
    private final double rating;
    private final String description;
    @Enumerated(value = EnumType.STRING)
    private final Genre genre;

    protected FilmDescription(){
        this.rating=0.0;
        this.description="";
        this.genre=Genre.ACTION;
    }
    //konstruktor so argumenti
    public FilmDescription(@NonNull double rating, @NonNull String description, @NonNull Genre genre){
        this.rating=rating;
        this.description=description;
        this.genre=genre;
    }
    //builderMethod
    public static FilmDescription build(double rating, String description, Genre genre){
        return new FilmDescription(rating, description,genre);
    }



}
