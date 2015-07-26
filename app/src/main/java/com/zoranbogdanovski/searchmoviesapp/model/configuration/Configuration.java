package com.zoranbogdanovski.searchmoviesapp.model.configuration;

import com.zoranbogdanovski.searchmoviesapp.model.IResponseModel;

import java.util.List;

/**
 * Model class which represents configuration used in the app.
 */
public class Configuration implements IResponseModel {

    private Images images;
    private List<String> change_keys;

    /**
     * Constructor.
     *
     * @param images      configuration for images
     * @param change_keys configuration for change keys
     */
    public Configuration(Images images, List<String> change_keys) {
        this.images = images;
        this.change_keys = change_keys;
    }

    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
    }

    public List<String> getChange_keys() {
        return change_keys;
    }

    public void setChange_keys(List<String> change_keys) {
        this.change_keys = change_keys;
    }
}
