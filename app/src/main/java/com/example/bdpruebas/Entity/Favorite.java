package com.example.bdpruebas.Entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "favorites")
public class Favorite {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private int userId;
    private int touristPlaceId;

    // Constructor, getters y setters
    public Favorite(int userId, int touristPlaceId) {
        this.userId = userId;
        this.touristPlaceId = touristPlaceId;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public int getTouristPlaceId() { return touristPlaceId; }
    public void setTouristPlaceId(int touristPlaceId) { this.touristPlaceId = touristPlaceId; }
}
