package com.zoranbogdanovski.searchmoviesapp.util;

import com.zoranbogdanovski.searchmoviesapp.core.App;
import com.zoranbogdanovski.searchmoviesapp.model.configuration.Images;

import java.util.List;

/**
 * Utility class for URLs.
 */
public final class UrlUtils {

    private UrlUtils() {
    }

    /**
     * Creates the full image url.
     *
     * @param filepath     the image file path
     * @param originalSize if gotten size should be the original size
     * @return the image url string
     */
    public static String createImageUrl(String filepath, boolean originalSize) {
        Images imagesConfiguration = App.getInstance().getConfiguration().getImages();
        String base_url = imagesConfiguration.getBase_url();
        List<String> poster_sizes = imagesConfiguration.getPoster_sizes();
        long imageSizesListSize = poster_sizes.size();
        // take a mid sized image for the list
        String imageSize = originalSize
                ? poster_sizes.get(poster_sizes.size() - 1)
                : poster_sizes.get((int) Math.round((imageSizesListSize / 2) + .5));
        return base_url + imageSize + filepath;
    }
}
