package com.dicoding.moviecataloguesub1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private String[] dataTitle, dataOverview, dataGendre, dataRuntime, dataLanguage,dataStatus, dataUserScore, dataYear;
    private TypedArray dataPoster;
    private MovieAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new MovieAdapter(this);
        ListView listView = findViewById(R.id.lv_movie);
        listView.setAdapter(adapter);

        //
        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //
                Intent moveWithObject = new Intent(MainActivity.this, MovieDetailActivity.class);

                ArrayList<Movies> movies = new ArrayList<>();

                Movies movie = new Movies();
                movie.setPoster(dataPoster.getResourceId(i,-1));
                movie.setTitle(dataTitle[i]);
                movie.setOverview(dataOverview[i]);
                movie.setGenre(dataGendre[i]);
                movie.setStatus(dataStatus[i]);
                movie.setRuntime(dataRuntime[i]);
                movie.setOriginal_language(dataLanguage[i]);
                movie.setUser_score(dataUserScore[i]);
                movie.setYear(dataYear[i]);

                movies.add(movie);

                ///
                moveWithObject.putParcelableArrayListExtra(MovieDetailActivity.EXTRA_MOVIE, movies);
                startActivity(moveWithObject);



            }
        });
    }

    @Override
    public void onClick(View view) {
    ////////////
    }

    private void addItem(){
        ArrayList<Movies> movies = new ArrayList<>();

        for(int i=0; i<dataTitle.length; i++){
            Movies movie = new Movies();

            movie.setPoster(dataPoster.getResourceId(i,-1));
            movie.setTitle(dataTitle[i]);
            movie.setOverview(dataOverview[i]);
            movie.setGenre(dataGendre[i]);
            movie.setStatus(dataStatus[i]);
            movie.setRuntime(dataRuntime[i]);
            movie.setOriginal_language(dataLanguage[i]);
            movie.setUser_score(dataUserScore[i]);
            movie.setYear(dataYear[i]);

            movies.add(movie);
        }
        adapter.setMovies(movies);
    }

    private void prepare(){
        dataTitle = getResources().getStringArray(R.array.data_title);
        dataOverview = getResources().getStringArray(R.array.data_overview);
        dataPoster = getResources().obtainTypedArray(R.array.data_poster);
        dataGendre = getResources().getStringArray(R.array.data_gendre);
        dataStatus = getResources().getStringArray(R.array.data_status);
        dataUserScore = getResources().getStringArray(R.array.data_userScore);
        dataLanguage = getResources().getStringArray(R.array.data_language);
        dataRuntime = getResources().getStringArray(R.array.data_runtime);
        dataYear = getResources().getStringArray(R.array.data_year);
    }
}
