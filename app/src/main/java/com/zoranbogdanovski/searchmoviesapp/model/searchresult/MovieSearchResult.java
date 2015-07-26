package com.zoranbogdanovski.searchmoviesapp.model.searchresult;

import com.zoranbogdanovski.searchmoviesapp.model.IResponseModel;

import java.io.Serializable;
import java.util.List;

/**
 * Model class representing movie in search results.
 */
public class MovieSearchResult implements IResponseModel, Serializable {

    private boolean adult;
    private String backdrop_path;
    private List<Integer> genre_ids;
    private int id;
    private String original_language;
    private String original_title;
    private String overview;
    private String release_date;
    private String poster_path;
    private Double popularity;
    private String title;
    private boolean video;
    private Double vote_average;
    private int vote_count;

    /**
     * Constructor.
     *
     * @param adult             is movie adult
     * @param backdrop_path     path of backdrop image
     * @param genre_ids         the movie genres
     * @param id                the movie id
     * @param original_language the original language of the movie
     * @param original_title    the original title of the movie
     * @param overview          the overview of the movie
     * @param release_date      the release date of the movie
     * @param poster_path       path of poster image
     * @param popularity        the popularity of the movie
     * @param title             the title of the movie
     * @param video             does it have video
     * @param vote_average      the vote average of the movie
     * @param vote_count        the vote count of the movie
     */
    public MovieSearchResult(boolean adult,
                             String backdrop_path,
                             List<Integer> genre_ids,
                             int id,
                             String original_language,
                             String original_title,
                             String overview,
                             String release_date,
                             String poster_path,
                             Double popularity,
                             String title,
                             boolean video,
                             Double vote_average,
                             int vote_count) {
        this.adult = adult;
        this.backdrop_path = backdrop_path;
        this.genre_ids = genre_ids;
        this.id = id;
        this.original_language = original_language;
        this.original_title = original_title;
        this.overview = overview;
        this.release_date = release_date;
        this.poster_path = poster_path;
        this.popularity = popularity;
        this.title = title;
        this.video = video;
        this.vote_average = vote_average;
        this.vote_count = vote_count;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public List<Integer> getGenre_ids() {
        return genre_ids;
    }

    public void setGenre_ids(List<Integer> genre_ids) {
        this.genre_ids = genre_ids;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public Double getPopularity() {
        return popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    public Double getVote_average() {
        return vote_average;
    }

    public void setVote_average(Double vote_average) {
        this.vote_average = vote_average;
    }

    public int getVote_count() {
        return vote_count;
    }

    public void setVote_count(int vote_count) {
        this.vote_count = vote_count;
    }
}
