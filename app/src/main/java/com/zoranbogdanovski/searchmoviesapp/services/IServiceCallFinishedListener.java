package com.zoranbogdanovski.searchmoviesapp.services;

/**
 * Interface for service call finished listeners.
 */
public interface IServiceCallFinishedListener<T> {

    void onServiceFinished(T response);

}
