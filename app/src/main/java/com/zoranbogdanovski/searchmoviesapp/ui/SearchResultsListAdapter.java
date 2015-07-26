package com.zoranbogdanovski.searchmoviesapp.ui;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.zoranbogdanovski.searchmoviesapp.R;
import com.zoranbogdanovski.searchmoviesapp.core.App;
import com.zoranbogdanovski.searchmoviesapp.model.configuration.Images;
import com.zoranbogdanovski.searchmoviesapp.model.searchresult.MovieSearchResult;
import com.zoranbogdanovski.searchmoviesapp.util.UrlUtils;

import java.util.List;
import java.util.Locale;
import java.util.Random;

/**
 * Adapter for movie search results list.
 */
public class SearchResultsListAdapter extends ArrayAdapter<MovieSearchResult> {

    public SearchResultsListAdapter(Context context, List<MovieSearchResult> results) {
        super(context, 0, results);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = View.inflate(getContext(), R.layout.list_item_movie, null);
        }

        MovieSearchResult movieSearchResult = getItem(position);

        ImageView ivImage = (ImageView) view.findViewById(R.id.movie_image);

        Glide.with(getContext())
                .load(UrlUtils.createImageUrl(movieSearchResult.getPoster_path(), false))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(ivImage);

        TextView tvTitle = (TextView) view.findViewById(R.id.title);
        TextView tvDatePublished = (TextView) view.findViewById(R.id.date_tv);
        TextView tvLanguage = (TextView) view.findViewById(R.id.language);
        TextView tvVoteScore = (TextView) view.findViewById(R.id.vote_score);
        View colorRightView = view.findViewById(R.id.color_right_view);
        Random rnd = new Random();
        int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        colorRightView.setBackgroundColor(color);

        tvTitle.setText(movieSearchResult.getOriginal_title());
        tvDatePublished.setText(movieSearchResult.getRelease_date());
        tvLanguage.setText(getContext().getString(R.string.language) + " "
                + getLanguage(movieSearchResult.getOriginal_language()));
        tvVoteScore.setText(getContext().getString(R.string.vote_score) + " "
                + movieSearchResult.getVote_average() + "/10");


        return view;
    }

    private String getLanguage(String originalLanguage) {
        return new Locale(originalLanguage).getDisplayLanguage();
    }

    private String createImageUrl(String filepath) {
        Images imagesConfiguration = App.getInstance().getConfiguration().getImages();
        String base_url = imagesConfiguration.getBase_url();
        List<String> poster_sizes = imagesConfiguration.getPoster_sizes();
        long imageSizesListSize = poster_sizes.size();
        // take a mid sized image for the list
        String imageSize = poster_sizes.get((int) Math.round((imageSizesListSize / 2) + .5));
        return base_url + imageSize + filepath;
    }
}
