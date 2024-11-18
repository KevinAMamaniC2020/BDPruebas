package com.example.bdpruebas;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bdpruebas.DAO.FavoriteDao;
import com.example.bdpruebas.DAO.ReviewDao;
import com.example.bdpruebas.DAO.TouristPlaceDao;
import com.example.bdpruebas.DAO.UserDao;
import com.example.bdpruebas.Entity.Favorite;
import com.example.bdpruebas.Entity.Review;
import com.example.bdpruebas.Entity.TouristPlace;
import com.example.bdpruebas.Entity.User;
import com.example.bdpruebas.Relaciones.TouristPlaceWithReviews;
import com.example.bdpruebas.Relaciones.UserWithFavorites;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Insertar y consultar datos en un hilo secundario
        new Thread(() -> {
            // Obtener instancia de la base de datos
            AppDatabase db = AppDatabase.getDatabase(this);

            // Insertar datos
            insertData(db);

            // Consultar datos
            queryData(db);
        }).start();
    }

    private void insertData(AppDatabase db) {
        UserDao userDao = db.userDao();
        TouristPlaceDao touristPlaceDao = db.touristPlaceDao();
        FavoriteDao favoriteDao = db.favoriteDao();
        ReviewDao reviewDao = db.reviewDao();

        // Insertar un usuario
        User user = new User("JuanPerez", "Juan", "juan@example.com", "1234", null);
        userDao.insertUser(user);

        // Insertar un lugar turístico
        TouristPlace place = new TouristPlace("Museo Histórico", "Un museo lleno de historia", -77.0364, -77.0364, "Calle 123");
        touristPlaceDao.insertTouristPlace(place);

        // Insertar un favorito
        Favorite favorite = new Favorite(1, 1); // id, userId, touristPlaceId
        favoriteDao.insertFavorite(favorite);

        // Insertar una reseña
        Review review = new Review(1, 1, "Excelente lugar para aprender historia.", 5);
        reviewDao.insertReview(review);

        Log.d("MainActivity", "Datos insertados correctamente.");
    }

    private void queryData(AppDatabase db) {
        UserDao userDao = db.userDao();
        TouristPlaceDao touristPlaceDao = db.touristPlaceDao();

        // Consulta 1: Usuario con sus favoritos
        UserWithFavorites userWithFavorites = userDao.getUserWithFavorites(1);
        if (userWithFavorites != null) {
            Log.d("Consulta1", "Usuario: " + userWithFavorites.getUser().getUsername());
            for (Favorite favorite : userWithFavorites.getFavorites()) {
                Log.d("Consulta1", "Lugar Favorito ID: " + favorite.getTouristPlaceId());
            }
        } else {
            Log.d("Consulta1", "No se encontró el usuario.");
        }

        // Consulta 2: Lugar turístico con sus reseñas
        TouristPlaceWithReviews placeWithReviews = touristPlaceDao.getTouristPlaceWithReviews(1);
        if (placeWithReviews != null) {
            Log.d("Consulta2", "Lugar Turístico: " + placeWithReviews.getTouristPlace().getName());
            for (Review review : placeWithReviews.getReviews()) {
                Log.d("Consulta2", "Reseña: " + review.getContent() + ", Calificación: " + review.getGrade());
            }
        } else {
            Log.d("Consulta2", "No se encontró el lugar turístico.");
        }
    }
}
