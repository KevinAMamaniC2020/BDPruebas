package com.example.bdpruebas;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.content.Context;

import com.example.bdpruebas.DAO.FavoriteDao;
import com.example.bdpruebas.DAO.RecentSearchDao;
import com.example.bdpruebas.DAO.ReviewDao;
import com.example.bdpruebas.DAO.TouristPlaceDao;
import com.example.bdpruebas.DAO.UserDao;
import com.example.bdpruebas.Entity.Favorite;
import com.example.bdpruebas.Entity.RecentSearch;
import com.example.bdpruebas.Entity.Review;
import com.example.bdpruebas.Entity.TouristPlace;
import com.example.bdpruebas.Entity.User;

@Database(entities = {User.class, TouristPlace.class, Favorite.class, Review.class, RecentSearch.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao(); // Agrega los DAO que crees
    public abstract TouristPlaceDao touristPlaceDao();
    public abstract FavoriteDao favoriteDao();
    public abstract ReviewDao reviewDao();
    public abstract RecentSearchDao recentSearchDao();

    private static volatile AppDatabase INSTANCE;

    public static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    AppDatabase.class, "mi_base_de_datos")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
