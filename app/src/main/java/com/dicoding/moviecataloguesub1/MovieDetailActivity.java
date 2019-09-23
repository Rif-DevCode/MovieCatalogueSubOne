package com.dicoding.moviecataloguesub1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MovieDetailActivity extends AppCompatActivity {

    String title, status, user_score, gendres, runtime, language, overview;
    int path;

    public static final String EXTRA_MOVIE = "extra_movie";

    TextView tvTitle, tvStatus, tvUserScore, tvGendres, tvRuntime, tvLanguage, tvOverview;

    ImageView imgPoster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        tvTitle = findViewById(R.id.txt_title);
        tvStatus = findViewById(R.id.txt_status);
        tvUserScore = findViewById(R.id.txt_user_score);
        tvGendres = findViewById(R.id.txt_genres);
        tvRuntime = findViewById(R.id.txt_runtime);
        tvLanguage = findViewById(R.id.txt_language);
        tvOverview = findViewById(R.id.txt_overview);
        imgPoster = findViewById(R.id.img_poster);

        ArrayList<Movies> movie = this.getIntent().getParcelableArrayListExtra(EXTRA_MOVIE);

        title = movie.get(0).getTitle();
        tvTitle.setText(title);

        status = movie.get(0).getStatus();
        tvStatus.setText(status);

        user_score = movie.get(0).getUser_score();
        tvUserScore.setText(user_score);

        gendres = movie.get(0).getGenre();
        tvGendres.setText(gendres);

        runtime = movie.get(0).getRuntime();
        tvRuntime.setText(runtime);

        language = movie.get(0).getOriginal_language();
        tvLanguage.setText(language);

        overview = movie.get(0).getOverview();
        tvOverview.setText(overview);

        path = movie.get(0).getPoster();
        imgPoster.setImageResource(path);

    }
}
