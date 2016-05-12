package com.zoranbogdanovski.searchmoviesapp.services;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zoranbogdanovski.searchmoviesapp.model.configuration.Configuration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * An async executor for a executing a service call.
 */
public class ServiceExecutor<T> {

    private static final String LOG_TAG = ServiceExecutor.class.toString();
    private final Gson gson;
    private String serviceUrl;
    private IServiceCallFinishedListener<T> serviceCallFinishedListener;

    /**
     * Constructor.
     *
     * @param serviceUrl                  the service url to call
     * @param serviceCallFinishedListener the listener on service call finished
     */
    public ServiceExecutor(String serviceUrl,
                           IServiceCallFinishedListener serviceCallFinishedListener) {
        this.gson = new GsonBuilder().serializeNulls().create();
        this.serviceUrl = serviceUrl;
        this.serviceCallFinishedListener = serviceCallFinishedListener;
    }


    public void executeService(final Class<T> parsingClass) {
        Log.v(LOG_TAG, "executeService called for url: " + serviceUrl);

        Observable.OnSubscribe<T> onSubscribe = new Observable.OnSubscribe<T>() {
            @Override
            public void call(Subscriber<? super T> subscriber) {
                boolean unsubscribed = subscriber.isUnsubscribed();
                try {
                    if (unsubscribed) {
                        return;
                    }
                    String response = executeServiceCall();
                    T parsedObject = gson.fromJson(response, parsingClass);
                    subscriber.onNext(parsedObject);
                } catch (Exception e) {
                    Log.e(LOG_TAG, "Error while executing service call for url:"
                            + serviceUrl, e);
                    if (!unsubscribed) {
                        subscriber.onError(e);
                    }
                }

                if (!unsubscribed) {
                    subscriber.onCompleted();
                }
            }
        };

        Observable.create(onSubscribe)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<T>() {
                    @Override
                    public void onCompleted() {
                        // do nothing
                    }

                    @Override
                    public void onError(Throwable e) {
                        throw new RuntimeException("Error while executing service call for url:"
                                + serviceUrl);
                    }

                    @Override
                    public void onNext(T s) {
                        serviceCallFinishedListener.onServiceFinished(s);
                    }
                });
    }

    @NonNull
    private String executeServiceCall() throws IOException {
        URL url = new URL(serviceUrl);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(urlConnection.getInputStream()));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
            bufferedReader.close();

            return stringBuilder.toString();
        } finally {
            urlConnection.disconnect();
        }
    }

}
