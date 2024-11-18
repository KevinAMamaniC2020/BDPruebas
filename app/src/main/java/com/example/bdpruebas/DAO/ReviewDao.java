package com.example.bdpruebas.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.bdpruebas.Entity.Review;

import java.util.List;

@Dao
public interface ReviewDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertReview(Review review);

    @Update
    void updateReview(Review review);

    @Delete
    void deleteReview(Review review);

    @Query("SELECT * FROM reviews WHERE userId = :userId")
    List<Review> getReviewsByUserId(int userId);

    @Query("SELECT * FROM reviews WHERE touristPlaceId = :touristPlaceId")
    List<Review> getReviewsByTouristPlaceId(int touristPlaceId);

    @Query("SELECT * FROM reviews WHERE userId = :userId AND touristPlaceId = :touristPlaceId")
    Review getReviewByUserAndTouristPlace(int userId, int touristPlaceId);
}
