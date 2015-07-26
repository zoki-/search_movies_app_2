package com.zoranbogdanovski.searchmoviesapp.services;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * An async task executor for a executing a service call.
 */
public class ServiceAsyncTaskExecutor {

    private String serviceUrl;
    private IServiceCallFinishedListener serviceCallFinishedListener;

    /**
     * Constructor.
     *
     * @param serviceUrl                  the service url to call
     * @param serviceCallFinishedListener the listener on service call finished
     */
    public ServiceAsyncTaskExecutor(String serviceUrl,
                                    IServiceCallFinishedListener serviceCallFinishedListener) {
        this.serviceUrl = serviceUrl;
        this.serviceCallFinishedListener = serviceCallFinishedListener;
    }

    public void executeServiceTask() {
        new ExecuteServiceCallTask().execute();
    }

    class ExecuteServiceCallTask extends AsyncTask<Void, Void, String> {

        protected void onPreExecute() {
        }

        protected String doInBackground(Void... urls) {
            try {
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
            } catch (Exception e) {
                Log.e("Service call error", e.getMessage(), e);
                return null;
            }
        }

        protected void onPostExecute(String response) {
            if (response == null) {
                throw new RuntimeException("Error while executing service call for url:"
                        + serviceUrl);
            }

            serviceCallFinishedListener.onServiceFinished(response);
        }
    }

}
