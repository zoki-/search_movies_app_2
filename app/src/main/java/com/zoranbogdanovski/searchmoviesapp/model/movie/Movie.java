package com.zoranbogdanovski.searchmoviesapp.model.movie;

import com.zoranbogdanovski.searchmoviesapp.model.IResponseModel;
import com.zoranbogdanovski.searchmoviesapp.model.searchresult.MovieSearchResult;

import java.io.Serializable;
import java.util.List;

/**
 * Model class which represents a movie.
 */
public class Movie extends MovieSearchResult implements IResponseModel, Serializable {

    private Object belongs_to_collection;
    private long budget;
    private List<Genre> genres;
    private String homepage;
    private String imdb_id;
    private List<ProductionCompany> production_companies;
    private List<ProductionCountry> production_countries;
    private long revenue;
    private int runtime;
    private List<SpokenLanguage> spoken_languages;
    private String status;
    private String tagline;

    /**
     * Constructor.
     *
     * @param adult                 is movie adult
     * @param backdrop_path         path of backdrop image
     * @param belongs_to_collection if movie belongs to collection
     * @param budget                movie budget
     * @param genres                the movie genres
     * @param homepage              the movie homepage
     * @param id                    the movie id
     * @param imdb_id               the movie imdb id
     * @param original_language     the original language of the movie
     * @param original_title        the original title of the movie
     * @param overview              the overview of the movie
     * @param release_date          the release date of the movie
     * @param revenue               the revenue of the movie
     * @param runtime               the runtime of the movie
     * @param spoken_languages      the spoken languages of the movie
     * @param status                the status of the movie
     * @param tagline               the tagline of the movie
     * @param poster_path           path of poster image
     * @param popularity            the popularity of the movie
     * @param production_companies  the production companies of the movie
     * @param title                 the title of the movie
     * @param video                 does it have video
     * @param vote_average          the vote average of the movie
     * @param vote_count            the vote count of the movie
     */
    public Movie(boolean adult,
                 String backdrop_path,
                 Object belongs_to_collection,
                 long budget,
                 String homepage,
                 List<Genre> genres,
                 int id,
                 String imdb_id,
                 String original_language,
                 String original_title,
                 String overview,
                 String release_date,
                 long revenue,
                 int runtime,
                 List<SpokenLanguage> spoken_languages,
                 String status,
                 String tagline,
                 String poster_path,
                 Double popularity,
                 List<ProductionCompany> production_companies,
                 List<ProductionCountry> production_countries,
                 String title,
                 boolean video,
                 Double vote_average,
                 int vote_count) {

        super(adult, backdrop_path, null, id, original_language, original_title, overview,
                release_date, poster_path, popularity, title, video, vote_average, vote_count);

        this.belongs_to_collection = belongs_to_collection;
        this.budget = budget;
        this.genres = genres;
        this.homepage = homepage;
        this.imdb_id = imdb_id;
        this.production_companies = production_companies;
        this.production_countries = production_countries;
        this.revenue = revenue;
        this.runtime = runtime;
        this.spoken_languages = spoken_languages;
        this.status = status;
        this.tagline = tagline;
    }

    public Object getBelongs_to_collection() {
        return belongs_to_collection;
    }

    public void setBelongs_to_collection(Object belongs_to_collection) {
        this.belongs_to_collection = belongs_to_collection;
    }

    public long getBudget() {
        return budget;
    }

    public void setBudget(long budget) {
        this.budget = budget;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public String getImdb_id() {
        return imdb_id;
    }

    public void setImdb_id(String imdb_id) {
        this.imdb_id = imdb_id;
    }

    public List<ProductionCompany> getProduction_companies() {
        return production_companies;
    }

    public void setProduction_companies(List<ProductionCompany> production_companies) {
        this.production_companies = production_companies;
    }

    public List<ProductionCountry> getProduction_countries() {
        return production_countries;
    }

    public void setProduction_countries(List<ProductionCountry> production_countries) {
        this.production_countries = production_countries;
    }

    public long getRevenue() {
        return revenue;
    }

    public void setRevenue(long revenue) {
        this.revenue = revenue;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public List<SpokenLanguage> getSpoken_languages() {
        return spoken_languages;
    }

    public void setSpoken_languages(List<SpokenLanguage> spoken_languages) {
        this.spoken_languages = spoken_languages;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }
}
