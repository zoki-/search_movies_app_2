package com.zoranbogdanovski.searchmoviesapp.services;

import com.zoranbogdanovski.searchmoviesapp.model.IResponseModel;

/**
 * Interface for service call parsed response listeners.
 */
public interface IParsedResponseListener {

    void onParsedResponseFinished(IResponseModel response);

}
