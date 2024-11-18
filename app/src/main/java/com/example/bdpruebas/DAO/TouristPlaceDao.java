package com.example.bdpruebas.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.example.bdpruebas.Entity.TouristPlace;
import com.example.bdpruebas.Relaciones.TouristPlaceWithReviewers;
import com.example.bdpruebas.Relaciones.TouristPlaceWithReviews;

import java.util.List;

@Dao
public interface TouristPlaceDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTouristPlace(TouristPlace touristPlace);

    @Update
    void updateTouristPlace(TouristPlace touristPlace);

    @Delete
    void deleteTouristPlace(TouristPlace touristPlace);

    @Query("SELECT * FROM tourist_places")
    List<TouristPlace> getAllTouristPlaces();

    @Query("SELECT * FROM tourist_places WHERE id = :id")
    TouristPlace getTouristPlaceById(int id);

    @Query("SELECT * FROM tourist_places WHERE name LIKE :name")
    List<TouristPlace> searchTouristPlacesByName(String name);

    @Transaction
    @Query("SELECT * FROM tourist_places WHERE id = :touristPlaceId")
    TouristPlaceWithReviews getTouristPlaceWithReviews(int touristPlaceId);

    @Transaction
    @Query("SELECT * FROM tourist_places WHERE id = :touristPlaceId")
    TouristPlaceWithReviewers getTouristPlaceWithReviewers(int touristPlaceId);
}

