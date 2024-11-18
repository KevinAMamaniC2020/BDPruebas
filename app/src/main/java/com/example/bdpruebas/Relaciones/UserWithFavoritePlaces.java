package com.example.bdpruebas.Relaciones;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import com.example.bdpruebas.Entity.Favorite;
import com.example.bdpruebas.Entity.TouristPlace;
import com.example.bdpruebas.Entity.User;

import java.util.List;

public class UserWithFavoritePlaces {
    @Embedded
    private User user;

    @Relation(
            parentColumn = "id", // Columna clave primaria en User
            entityColumn = "id", // Columna clave primaria en TouristPlace
            associateBy = @Junction(
                    value = Favorite.class, // Tabla intermedia
                    parentColumn = "userId", // Columna clave foránea en Favorite para User
                    entityColumn = "touristPlaceId" // Columna clave foránea en Favorite para TouristPlace
            )
    )
    private List<TouristPlace> favoritePlaces;

    // Getters y setters
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public List<TouristPlace> getFavoritePlaces() { return favoritePlaces; }
    public void setFavoritePlaces(List<TouristPlace> favoritePlaces) { this.favoritePlaces = favoritePlaces; }
}
