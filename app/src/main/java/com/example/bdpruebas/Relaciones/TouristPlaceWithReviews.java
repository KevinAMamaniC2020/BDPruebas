package com.example.bdpruebas.Relaciones;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.bdpruebas.Entity.Review;
import com.example.bdpruebas.Entity.TouristPlace;

import java.util.List;

public class TouristPlaceWithReviews {
    @Embedded
    private TouristPlace touristPlace;

    @Relation(
            parentColumn = "id", // Columna clave primaria en TouristPlace
            entityColumn = "touristPlaceId", // Columna clave foránea en Review
            entity = Review.class
    )
    private List<Review> reviews;

    // Getters y setters
    public TouristPlace getTouristPlace() { return touristPlace; }
    public void setTouristPlace(TouristPlace touristPlace) { this.touristPlace = touristPlace; }

    public List<Review> getReviews() { return reviews; }
    public void setReviews(List<Review> reviews) { this.reviews = reviews; }
}
