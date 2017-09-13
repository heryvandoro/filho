package com.filho.filho;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.filho.filho.helper.APIConstans;
import com.filho.filho.helper.ImageDownloader;
import com.filho.filho.helper.JSONParser;
import com.filho.filho.helper.TmdbAPI;

import org.json.JSONObject;

import java.util.Vector;

public class DetailActivity extends AppCompatActivity {

    int FILM_ID;
    Film film;

    Toolbar toolbar;
    ImageView filmCover;
    TextView filmGenre, filmRating, filmOverview, filmDate;
    Vector<JSONObject> genres;
    ListView listComment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_detail);

        loadAttribute();

        JSONObject x =  JSONParser.getObject(TmdbAPI.getRequest(APIConstans.MOVIE_DETAIL+"/"+getIntent().getIntExtra("film_id", -1)));
        try{
            film = new Film(x.getInt("id"), x.getString("title"),
                    x.getString("release_date"), x.getInt("vote_average"),
                    x.getString("poster_path"), x.getString("overview"));
        }catch (Exception e){ }

        genres = JSONParser.getArray(x, "genres");

        setFilmContent();
    }

    public void loadAttribute(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        filmCover = (ImageView) findViewById(R.id.filmCover);
        filmGenre = (TextView) findViewById(R.id.filmGenre);
        filmDate = (TextView) findViewById(R.id.filmDate);
        filmOverview = (TextView) findViewById(R.id.filmOverview);
        filmRating = (TextView) findViewById(R.id.filmRating);

        listComment = (ListView) findViewById(R.id.listComment);
    }

    public void setFilmContent(){
        toolbar.setTitle(film.getFilmTitle());
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        filmDate.setText("Release Date : " + film.getFilmDate("d MMM yyyy"));
        filmOverview.setText(film.getFilmOverview());
        filmRating.setText("Rating : " + film.getFilmRating()+"");

        new ImageDownloader(filmCover).execute(film.getFilmCoverURL(500));

        String filmGenreData = "";

        for (JSONObject genre : genres) {
            try {
                filmGenreData+=genre.getString("name")+", ";
            }catch (Exception e){};
        }
        filmGenreData = filmGenreData.substring(0, filmGenreData.length()-2);
        filmGenre.setText("Genre : " + filmGenreData);
    }
}
