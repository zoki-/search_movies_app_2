package com.zoranbogdanovski.searchmoviesapp.model.movie;

import java.io.Serializable;

/**
 * Model class which represents production country.
 */
public class ProductionCountry implements Serializable {

    private String iso_3166_1;
    private String name;

    /**
     * Constructor.
     *
     * @param iso_3166_1 the iso_3166_1 of the production country
     * @param name       the name of the production country
     */
    public ProductionCountry(String iso_3166_1, String name) {
        this.iso_3166_1 = iso_3166_1;
        this.name = name;
    }

    public String getIso_3166_1() {
        return iso_3166_1;
    }

    public void setIso_3166_1(String iso_3166_1) {
        this.iso_3166_1 = iso_3166_1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
