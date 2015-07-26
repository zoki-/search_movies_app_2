package com.zoranbogdanovski.searchmoviesapp.model.movie;

import java.io.Serializable;

/**
 * Model class which represents a spoken language.
 */
public class SpokenLanguage implements Serializable {

    private String iso_639_1;
    private String name;

    /**
     * Constructor.
     *
     * @param iso_639_1 the iso_639_1 of the spoken language
     * @param name      the name of the spoken language
     */
    public SpokenLanguage(String iso_639_1, String name) {
        this.iso_639_1 = iso_639_1;
        this.name = name;
    }

    public String getIso_639_1() {
        return iso_639_1;
    }

    public void setIso_639_1(String iso_639_1) {
        this.iso_639_1 = iso_639_1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
