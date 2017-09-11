package com.filho.filho.helper;

import java.util.Calendar;

/**
 * Created by HeryVandoro on 9/11/2017.
 */

public class APIConstans {
    public static final String CATEGORY = "/genre/movie/list";
    public static final String POPULAR_THIS_YEAR = "/discover/movie?sort_by=popularity.desc&primary_release_year="
                                                    + Calendar.getInstance().get(Calendar.YEAR);;
}
