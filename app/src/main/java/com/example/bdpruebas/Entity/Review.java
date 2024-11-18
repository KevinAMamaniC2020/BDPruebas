package com.example.bdpruebas.Entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "reviews")
public class Review {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private int userId;
    private int touristPlaceId;
    private String content;
    private int grade;

    // Constructor, getters y setters
    public Review(int userId, int touristPlaceId, String content, int grade) {
        this.userId = userId;
        this.touristPlaceId = touristPlaceId;
        this.content = content;
        this.grade = grade;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public int getTouristPlaceId() { return touristPlaceId; }
    public void setTouristPlaceId(int touristPlaceId) { this.touristPlaceId = touristPlaceId; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public int getGrade() { return grade; }
    public void setGrade(int grade) { this.grade = grade; }
}
