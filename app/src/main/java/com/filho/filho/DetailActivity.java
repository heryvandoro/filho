package com.filho.filho;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.filho.filho.helper.APIConstans;
import com.filho.filho.helper.ImageDownloader;
import com.filho.filho.helper.JSONParser;
import com.filho.filho.helper.TmdbAPI;
import com.filho.filho.model.Comment;

import org.json.JSONObject;

import java.util.Vector;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener{

    int FILM_ID;
    Film film;

    Toolbar toolbar;
    ImageView filmCover;
    TextView filmGenre, filmRating, filmOverview, filmDate;
    Vector<JSONObject> genres;
    LinearLayout listComment;

    EditText commentText;
    Button commentSend;

    private Comment model;
    Cursor cursor;

    ContentValues con;

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
        loadComment();
    }

    public void loadAttribute(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        filmCover = (ImageView) findViewById(R.id.filmCover);
        filmGenre = (TextView) findViewById(R.id.filmGenre);
        filmDate = (TextView) findViewById(R.id.filmDate);
        filmOverview = (TextView) findViewById(R.id.filmOverview);
        filmRating = (TextView) findViewById(R.id.filmRating);
        listComment = (LinearLayout) findViewById(R.id.listComment);
        commentText = (EditText) findViewById(R.id.insertCommentText);
        commentSend = (Button) findViewById(R.id.buttonSend);
        commentSend.setOnClickListener(this);

        con = new ContentValues();
        model = new Comment(this);

        //onCreate bugged, not called automatically (?)
        model.createTable();
    }

    public void setFilmContent(){
        toolbar.setTitle(film.getFilmTitle());
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        filmDate.setText("Release Date : " + film.getFilmDate("d MMM yyyy"));
        filmOverview.setText(film.getFilmOverview());
        filmRating.setText("Rating : " + film.getFilmRating()+"");

        //new ImageDownloader(filmCover).execute(film.getFilmCoverURL(500));
        Glide.with(this).load(film.getFilmCoverURL(500)).into(filmCover);

        String filmGenreData = "";

        for (JSONObject genre : genres) {
            try {
                filmGenreData+=genre.getString("name")+", ";
            }catch (Exception e){ e.printStackTrace(); };
        }
        filmGenreData = filmGenreData.substring(0, filmGenreData.length()-2);
        filmGenre.setText("Genre : " + filmGenreData);
    }

    public void loadComment(){
        listComment.removeAllViews();
        cursor = model.show(film.getFilmID());

        String[] displayed = new String[]{model.COLUMN_TEXT};
        int[] layoutDisplay = new int[]{R.id.commentText};

        //SimpleCursorAdapter's constructor deprecated, replace it with 0 flags
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.comment, cursor, displayed, layoutDisplay, 0);

        listComment = (LinearLayout) findViewById(R.id.listComment);
        for (int i = 0; i < adapter.getCount(); i++){
            listComment.addView(adapter.getView(i, null, listComment));
        }
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.buttonSend :
                con.put(model.COLUMN_FILM_ID, film.getFilmID());
                con.put(model.COLUMN_TEXT, commentText.getText().toString());
                model.insert(con);
                commentText.setText("");
                loadComment();
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home :
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
