package com.filho.filho;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.filho.filho.helper.APIConstans;
import com.filho.filho.helper.JSONParser;
import com.filho.filho.helper.TmdbAPI;

import org.json.JSONObject;

import java.util.Vector;

public class OngoingFragment extends FilmFragment{
    @Override
    public void loadFilmData() {
        Vector<JSONObject> data = null;
        try{
            data = JSONParser.getArray(
                    new JSONObject(TmdbAPI.getRequest(APIConstans.ONGOING)
                    ), "results");

            for(JSONObject x : data){
                films.add(new Film(x.getInt("id"), x.getString("title"),
                        x.getString("release_date"), x.getInt("vote_average"),
                        x.getString("poster_path"), x.getString("overview")));
            }
        }catch (Exception e){ e.printStackTrace(); }
    }
}
