package com.zoranbogdanovski.searchmoviesapp.ui;

import android.app.ActionBar;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.zoranbogdanovski.searchmoviesapp.R;
import com.zoranbogdanovski.searchmoviesapp.model.movie.Movie;
import com.zoranbogdanovski.searchmoviesapp.util.DialogUtils;
import com.zoranbogdanovski.searchmoviesapp.util.UrlUtils;

import java.util.Locale;

import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;

@ContentView(R.layout.activity_movie_detail)
public class MovieDetailActivity extends RoboActivity {

    public static final String MODEL_EXTRA = "model_extra";
    private Movie model;

    @InjectView(R.id.movie_poster)
    ImageView moviePoster;

    @InjectView(R.id.movie_name)
    TextView movieName;

    @InjectView(R.id.tagline)
    TextView tagline;

    @InjectView(R.id.overview)
    TextView overview;

    @InjectView(R.id.time_duration)
    TextView timeDuration;

    @InjectView(R.id.grade_rating)
    TextView gradeRating;

    @InjectView(R.id.language_section)
    View languageSection;

    @InjectView(R.id.language_tv)
    TextView languageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.containsKey(MODEL_EXTRA)) {
            model = (Movie) extras.get(MODEL_EXTRA);
        } else {
            DialogUtils.showMessageDialog(this, getString(R.string.no_details),
                    new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    });
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setElevation(0);
        }

        fillViewsWithData();
    }

    private void fillViewsWithData() {
        Glide.with(this)
                .load(UrlUtils.createImageUrl(model.getPoster_path(), true))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(moviePoster);

        movieName.setText(model.getOriginal_title());
        String taglineString = model.getTagline();
        if (!TextUtils.isEmpty(taglineString)) {
            tagline.setVisibility(View.VISIBLE);
            tagline.setText(taglineString);
        } else {
            tagline.setVisibility(View.GONE);
        }
        overview.setText(model.getOverview());
        String runtime = model.getRuntime() + " min.";
        timeDuration.setText(runtime);
        String grade = model.getVote_average() + "/10 with " + model.getVote_count() + " votes.";
        gradeRating.setText(grade);
        String language = model.getOriginal_language();
        languageTextView.setText(new Locale(language).getDisplayLanguage());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_movie_detail, menu);
        return true;
    }

}
