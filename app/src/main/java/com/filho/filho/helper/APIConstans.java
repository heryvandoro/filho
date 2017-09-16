package com.filho.filho.helper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by HeryVandoro on 9/11/2017.
 */

public class APIConstans {
    public static Calendar NOW =  Calendar.getInstance();

    public static final String CATEGORY = "/genre/movie/list";
    public static final String FILM_COVER = "https://image.tmdb.org/t/p/w";

    //popular this year and prev year
    public static final String POPULAR = "/discover/movie?sort_by=popularity.desc&primary_release_year="
                                                    + NOW.get(Calendar.YEAR) + "|" + (NOW.get(Calendar.YEAR)-1);
    public static final String MOVIE_DETAIL = "/movie";

    public static final String UPCOMING = "/discover/movie?sort_by=popularity.desc&primary_release_year="
                                                    + (NOW.get(Calendar.YEAR)+1);

    public static final String FILM_BY_CATEGORY = "/discover/movie?sort_by=popularity.desc&primary_release_year="+NOW.get(Calendar.YEAR)+"&with_genres=";

    public static final String ONGOING = "/discover/movie?sort_by=popularity.desc&certification=R&primary_release_date.gte="+getDate("first")+"&primary_release_date.lte="+getDate("last");

    public static String getDate(String type){
        if(type.equals("first"))
            NOW.set(Calendar.DAY_OF_MONTH, NOW.getActualMinimum(Calendar.DAY_OF_MONTH));
        else
            NOW.set(Calendar.DAY_OF_MONTH, NOW.getActualMaximum(Calendar.DAY_OF_MONTH));
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(NOW.getTime());
    }
}
