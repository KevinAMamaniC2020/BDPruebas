package com.example.bdpruebas.Entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "recent_searches")
public class RecentSearch {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String searchTerm;
    private long timestamp;

    // Constructor, getters y setters
    public RecentSearch(String searchTerm, long timestamp) {
        this.searchTerm = searchTerm;
        this.timestamp = timestamp;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getSearchTerm() { return searchTerm; }
    public void setSearchTerm(String searchTerm) { this.searchTerm = searchTerm; }

    public long getTimestamp() { return timestamp; }
    public void setTimestamp(long timestamp) { this.timestamp = timestamp; }
}
