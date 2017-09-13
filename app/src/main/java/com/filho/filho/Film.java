package com.filho.filho;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import com.filho.filho.helper.APIConstans;
import com.filho.filho.helper.ImageDownloader;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

/**
 * Created by HeryVandoro on 9/8/2017.
 */

public class Film{
    private int filmID;
    private String filmTitle;
    private String filmDate;
    private float filmRating;
    private Bitmap filmCover;
    private String filmCoverURL;
    private String filmOverview;

    public Film(int filmID, String filmTitle, String filmDate, float filmRating, String filmCoverURL, String filmOverview) {
        this.filmID = filmID;
        this.filmTitle = filmTitle;
        this.filmDate = filmDate;
        this.filmRating = filmRating;
        this.filmOverview = filmOverview;
        this.filmCoverURL = filmCoverURL;
    }

    public String getFilmCoverURL(int size){
        return APIConstans.FILM_COVER+size+filmCoverURL;
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


    public String getFilmDate(String dateFormat){
        String inputPattern = "yyyy-MM-dd";
        String outputPattern = dateFormat;
        SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern);
        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern);

        Date date = null;
        String str = null;

        try {
            date = inputFormat.parse(getFilmDate());
            str = outputFormat.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    public void setFilmDate(String filmDate) {
        this.filmDate = filmDate;
    }

    public float getFilmRating() {
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
