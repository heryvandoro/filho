package com.filho.filho;

/**
 * Created by HeryVandoro on 9/8/2017.
 */

public class Film {
    private final String FILM_COVER_API_PATH = "https://image.tmdb.org/t/p/w300";

    private int filmID;
    private String filmTitle;
    private String filmDate;
    private int filmRating;
    private String filmCover;
    private String filmOverview;

    public Film(int filmID, String filmTitle, String filmDate, int filmRating, String filmCover, String filmOverview) {
        this.filmID = filmID;
        this.filmTitle = filmTitle;
        this.filmDate = filmDate;
        this.filmRating = filmRating;
        this.filmCover = filmCover;
        this.filmOverview = filmOverview;
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

    public String getFilmCover() {
        return FILM_COVER_API_PATH+filmCover;
    }

    public void setFilmCover(String filmCover) {
        this.filmCover = filmCover;
    }

    public String getFilmOverview() {
        return filmOverview;
    }

    public void setFilmOverview(String filmOverview) {
        this.filmOverview = filmOverview;
    }
}
