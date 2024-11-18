package com.example.bdpruebas.Relaciones;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.bdpruebas.Entity.Favorite;
import com.example.bdpruebas.Entity.User;

import java.util.List;

public class UserWithFavorites {
    @Embedded
    private User user;

    @Relation(
            parentColumn = "id", // Columna clave primaria en User
            entityColumn = "userId", // Columna clave foránea en Favorite
            entity = Favorite.class
    )
    private List<Favorite> favorites;

    // Getters y setters
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public List<Favorite> getFavorites() { return favorites; }
    public void setFavorites(List<Favorite> favorites) { this.favorites = favorites; }
}
