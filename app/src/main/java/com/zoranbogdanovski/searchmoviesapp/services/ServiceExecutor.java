package com.zoranbogdanovski.searchmoviesapp.services;

import android.support.annotation.NonNull;
import android.util.Log;

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
 * An async task executor for a executing a service call.
 */
public class ServiceExecutor {

    private static final String LOG_TAG = ServiceExecutor.class.toString();
    private String serviceUrl;
    private IServiceCallFinishedListener serviceCallFinishedListener;

    /**
     * Constructor.
     *
     * @param serviceUrl                  the service url to call
     * @param serviceCallFinishedListener the listener on service call finished
     */
    public ServiceExecutor(String serviceUrl,
                           IServiceCallFinishedListener serviceCallFinishedListener) {
        this.serviceUrl = serviceUrl;
        this.serviceCallFinishedListener = serviceCallFinishedListener;
    }


    public void executeService() {
        Log.v(LOG_TAG, "executeService called for url: " + serviceUrl);
        Observable.OnSubscribe<String> onSubscribe = new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                try {
                    String response = execute();
                    subscriber.onNext(response);
                } catch (Exception e) {
                    Log.e(LOG_TAG, "Error while executing service call for url:"
                            + serviceUrl, e);
                    subscriber.onError(e);
                }
                subscriber.onCompleted();
            }
        };

        Observable.create(onSubscribe)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<String>() {
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
                    public void onNext(String s) {
                        serviceCallFinishedListener.onServiceFinished(s);
                    }
                });
    }

    @NonNull
    private String execute() throws IOException {
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
