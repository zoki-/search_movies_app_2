package com.zoranbogdanovski.searchmoviesapp.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.zoranbogdanovski.searchmoviesapp.core.App;

/**
 * Utility class for networking.
 */
public final class NetworkUtils {

    private NetworkUtils() {
    }

    public static boolean isOnline() {
        ConnectivityManager cm =
                (ConnectivityManager) App.getInstance().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }
}
