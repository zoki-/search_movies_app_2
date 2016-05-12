package com.zoranbogdanovski.searchmoviesapp.services;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.inject.Singleton;
import com.zoranbogdanovski.searchmoviesapp.model.configuration.Configuration;
import com.zoranbogdanovski.searchmoviesapp.model.movie.Movie;
import com.zoranbogdanovski.searchmoviesapp.model.searchresult.SearchResult;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Class that holds services used throughout the app.
 */
@Singleton
public class Services {

    private static final String BASE_URL = "https://api.themoviedb.org/3";
    private static final String API_KEY_QUERY_PARAM = "api_key=5933cc0752c72b28d8d12597444f2f9f";


    private String createUrl(String urlPath) {
        return createUrl(urlPath, null);
    }

    private String createUrl(String urlPath, String queryParameters) {
        String url = BASE_URL + urlPath + "?" + API_KEY_QUERY_PARAM;

        if (!TextUtils.isEmpty(queryParameters)) {
            url += queryParameters;
        }

        return url;
    }

    /**
     * Get configuration service.
     *
     * @param onServiceCallFinishedListener the listener when response arrives and is parsed
     */
    public void startGetConfiguration(final IServiceCallFinishedListener onServiceCallFinishedListener) {
        String url = createUrl("/configuration");
        ServiceExecutor<Configuration> executor = new ServiceExecutor<>(url,
                onServiceCallFinishedListener);

        executor.executeService(Configuration.class);
    }

    /**
     * Get search movies result.
     *
     * @param query                    the query to search
     * @param onServiceCallFinishedListener the listener when response arrives and is parsed
     */
    public void startGetMoviesSearchResult(String query,
                                           final IServiceCallFinishedListener onServiceCallFinishedListener) {
        String encodedQuery = "";
        try {
            encodedQuery = URLEncoder.encode(query, "utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Bad url query");
        }

        String url = createUrl("/search/movie", "&query=" + encodedQuery);

        ServiceExecutor<SearchResult> executor = new ServiceExecutor<>(url,
                onServiceCallFinishedListener);
        executor.executeService(SearchResult.class);
    }

    /**
     * Get specified movie information.
     *
     * @param movieId                  the movie id
     * @param onServiceCallFinishedListener the listener when response arrives and is parsed
     */
    public void startGetMovieInfo(String movieId,
                                  final IServiceCallFinishedListener onServiceCallFinishedListener) {
        String url = createUrl("/movie/" + movieId);

        ServiceExecutor<Movie> executor = new ServiceExecutor<>(url, onServiceCallFinishedListener);
        executor.executeService(Movie.class);
    }
}
