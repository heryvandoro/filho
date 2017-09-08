package com.filho.filho.helper;

import android.util.Log;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by HeryVandoro on 9/8/2017.
 */

//origin : https://www.themoviedb.org

public class TmdbAPI {
    private static final String API_KEY = "8e23eafa712dfcac551d853a50a2f418";
    private static final String API_HOST = "http://api.themoviedb.org/3";

    public static String getRequest(String urlString){
        URL url;
        HttpURLConnection urlConnection = null;
        InputStream in = null;
        String result = "";

        urlString = API_HOST+urlString;
        urlString += urlString.indexOf("?")!=-1? "&" : "?";

        urlString += "api_key="+API_KEY;

        try {
            url = new URL(urlString);
            urlConnection = (HttpURLConnection) url.openConnection();
            in = new BufferedInputStream(urlConnection.getInputStream());
            result = readStream(in);
        } catch (Exception e){
            e.printStackTrace();
        }
        finally {
            urlConnection.disconnect();
        }
        return result;
    }

    private static String readStream(InputStream is) {
        try {
            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            int i = -1;
            i = is.read();

            while(i != -1) {
                bo.write(i);
                i = is.read();
            }
            return bo.toString();
        } catch (IOException e) {
            return "";
        }
    }
}
