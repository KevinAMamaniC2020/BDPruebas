package com.example.bdpruebas.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.bdpruebas.Entity.RecentSearch;

import java.util.List;

@Dao
public interface RecentSearchDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertSearch(RecentSearch recentSearch);

    @Delete
    void deleteSearch(RecentSearch recentSearch);

    @Query("SELECT * FROM recent_searches ORDER BY timestamp DESC")
    List<RecentSearch> getAllRecentSearches();

    @Query("SELECT * FROM recent_searches WHERE id = :id")
    RecentSearch getRecentSearchById(int id);

    @Query("DELETE FROM recent_searches WHERE timestamp < :timestamp")
    void deleteSearchesOlderThan(long timestamp);
}
