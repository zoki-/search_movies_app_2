package com.zoranbogdanovski.searchmoviesapp.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zoranbogdanovski.searchmoviesapp.R;

/**
 * A fragment containing a list to show the user search results.
 */
public class SearchResultsFragment extends Fragment {

    public SearchResultsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search_results, container, false);
    }
}
