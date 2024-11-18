package com.example.bdpruebas.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.bdpruebas.Entity.Favorite;

import java.util.List;

@Dao
public interface FavoriteDao {
    @Insert (onConflict = OnConflictStrategy.REPLACE)
    void insertFavorite(Favorite favorite);

    @Delete
    void deleteFavorite(Favorite favorite);

    @Query("SELECT * FROM favorites WHERE userId = :userId")
    List<Favorite> getFavoritesByUserId(int userId);

    @Query("SELECT * FROM favorites WHERE touristPlaceId = :touristPlaceId")
    List<Favorite> getFavoritesByTouristPlaceId(int touristPlaceId);

    @Query("SELECT * FROM favorites WHERE userId = :userId AND touristPlaceId = :touristPlaceId")
    Favorite getFavorite(int userId, int touristPlaceId);
}
