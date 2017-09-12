package com.filho.filho;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import com.filho.filho.helper.ImageDownloader;

import java.io.InputStream;

/**
 * Created by HeryVandoro on 9/8/2017.
 */

public class Film{
    private static final String FILM_COVER_API_PATH = "https://image.tmdb.org/t/p/w300";

    private int filmID;
    private String filmTitle;
    private String filmDate;
    private int filmRating;
    private Bitmap filmCover;
    private String filmCoverURL;
    private String filmOverview;

    public Film(int filmID, String filmTitle, String filmDate, int filmRating, String filmCoverURL, String filmOverview) {
        this.filmID = filmID;
        this.filmTitle = filmTitle;
        this.filmDate = filmDate;
        this.filmRating = filmRating;
        this.filmOverview = filmOverview;
        this.filmCoverURL = filmCoverURL;
    }

    public String getFilmCoverURL(){
        return FILM_COVER_API_PATH+filmCoverURL;
    }

    public int getFilmID() {
        return filmID;
    }

    public void setFilmID(int filmID) {
        this.filmID = filmID;
    }

    public String getFilmTitle() {
        return filmTitle;
    }

    public void setFilmName(String filmTitle) {
        this.filmTitle = filmTitle;
    }

    public String getFilmDate() {
        return filmDate;
    }

    public void setFilmDate(String filmDate) {
        this.filmDate = filmDate;
    }

    public int getFilmRating() {
        return filmRating;
    }

    public void setFilmRating(int filmRating) {
        this.filmRating = filmRating;
    }

    public Bitmap getFilmCover() {
        return filmCover;
    }

    public void setFilmCover(Bitmap filmCover) {
        this.filmCover = filmCover;
    }

    public String getFilmOverview() {
        return filmOverview;
    }

    public void setFilmOverview(String filmOverview) {
        this.filmOverview = filmOverview;
    }
}
