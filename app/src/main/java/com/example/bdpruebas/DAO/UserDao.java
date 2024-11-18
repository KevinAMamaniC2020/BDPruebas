package com.example.bdpruebas.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.example.bdpruebas.Entity.User;
import com.example.bdpruebas.Relaciones.UserWithFavoritePlaces;
import com.example.bdpruebas.Relaciones.UserWithFavorites;

import java.util.List;

@Dao
public interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertUser(User user);

    @Update
    void updateUser(User user);

    @Delete
    void deleteUser(User user);

    @Query("SELECT * FROM users")
    List<User> getAllUsers();

    @Query("SELECT * FROM users WHERE id = :id")
    User getUserById(int id);

    @Query("SELECT * FROM users WHERE username = :username")
    User getUserByUsername(String username);


    @Transaction
    @Query("SELECT * FROM users WHERE id = :userId")
    UserWithFavorites getUserWithFavorites(int userId);

    @Transaction
    @Query("SELECT * FROM users WHERE id = :userId")
    UserWithFavoritePlaces getUserWithFavoritePlaces(int userId);
}
