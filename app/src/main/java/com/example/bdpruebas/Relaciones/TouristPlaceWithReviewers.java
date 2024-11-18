package com.example.bdpruebas.Relaciones;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import com.example.bdpruebas.Entity.Review;
import com.example.bdpruebas.Entity.TouristPlace;
import com.example.bdpruebas.Entity.User;

import java.util.List;

public class TouristPlaceWithReviewers {
    @Embedded
    private TouristPlace touristPlace;

    @Relation(
            parentColumn = "id", // Columna clave primaria en TouristPlace
            entityColumn = "id", // Columna clave primaria en User
            associateBy = @Junction(
                    value = Review.class, // Tabla intermedia
                    parentColumn = "touristPlaceId", // Columna clave foránea en Review para TouristPlace
                    entityColumn = "userId" // Columna clave foránea en Review para User
            )
    )
    private List<User> reviewers;

    // Getters y setters
    public TouristPlace getTouristPlace() { return touristPlace; }
    public void setTouristPlace(TouristPlace touristPlace) { this.touristPlace = touristPlace; }

    public List<User> getReviewers() { return reviewers; }
    public void setReviewers(List<User> reviewers) { this.reviewers = reviewers; }
}
