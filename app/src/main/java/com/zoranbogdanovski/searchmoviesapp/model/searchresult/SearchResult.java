package com.zoranbogdanovski.searchmoviesapp.model.searchresult;

import com.zoranbogdanovski.searchmoviesapp.model.IResponseModel;

import java.util.List;

/**
 * Model class representing search results
 */
public class SearchResult implements IResponseModel {

    private int page;
    private List<MovieSearchResult> results;
    private int total_pages;
    private int total_results;

    /**
     * Constructor.
     *
     * @param page          the page number
     * @param results       the results
     * @param total_pages   the total pages number
     * @param total_results the total results number
     */
    public SearchResult(int page, List<MovieSearchResult> results, int total_pages, int total_results) {
        this.page = page;
        this.results = results;
        this.total_pages = total_pages;
        this.total_results = total_results;
    }

    public int getTotal_results() {
        return total_results;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<MovieSearchResult> getResults() {
        return results;
    }

    public void setResults(List<MovieSearchResult> results) {
        this.results = results;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }
}
