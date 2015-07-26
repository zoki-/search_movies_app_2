package com.zoranbogdanovski.searchmoviesapp.core;

import android.app.Application;

import com.google.inject.Inject;
import com.zoranbogdanovski.searchmoviesapp.model.configuration.Configuration;
import com.zoranbogdanovski.searchmoviesapp.services.Services;

import roboguice.RoboGuice;

/**
 * Application.
 */
public class App extends Application {

    static {
        RoboGuice.setUseAnnotationDatabases(false);
    }

    private static final String LOG_TAG = App.class.toString();

    private static App instance;

    @Inject
    private Services services;
    private Configuration configuration;

    /**
     * Default constructor.
     */
    public App() {
        if (instance == null) {
            instance = this;
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        injectMembers();
    }

    protected void injectMembers() {
        // force injecting of the fields
        RoboGuice.getOrCreateBaseApplicationInjector(this).injectMembers(this);
    }

    /**
     * Gets the application instance.
     *
     * @return the application instance
     */
    public static App getInstance() {
        return instance;
    }

    /**
     * Gets the services used by the app.
     *
     * @return the services
     */
    public Services getServices() {
//        if (services == null) {
//            services = new Services();
//        }
        return services;
    }

    /**
     * Sets the configuration used by the app.
     *
     * @param configuration the configuration
     */
    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    /**
     * Gets the configuration used by the app.
     *
     * @return the configuration
     */
    public Configuration getConfiguration() {
        return configuration;
    }
}
