package com.zoranbogdanovski.searchmoviesapp.model.movie;

import java.io.Serializable;

/**
 * Model class which represents genre.
 */
public class Genre implements Serializable {

    private int id;
    private String name;

    /**
     * Constructor.
     *
     * @param id   the id of the genre
     * @param name the name of the genre
     */
    public Genre(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
