package com.filho.filho;

import com.filho.filho.helper.APIConstans;
import com.filho.filho.helper.JSONParser;
import com.filho.filho.helper.TmdbAPI;

import org.json.JSONObject;

import java.util.Vector;

/**
 * Created by HeryVandoro on 9/16/2017.
 */

public class CategoryFragment extends FilmFragment{
    public void loadFilmData() {
        int cat_id = this.getActivity().getIntent().getIntExtra("category_id", -1);

        Vector<JSONObject> data = null;
        try{
            data = JSONParser.getArray(
                    new JSONObject(TmdbAPI.getRequest(APIConstans.FILM_BY_CATEGORY+cat_id)
                    ), "results");

            for(JSONObject x : data){
                films.add(new Film(x.getInt("id"), x.getString("title"),
                        x.getString("release_date"), x.getInt("vote_average"),
                        x.getString("poster_path"), x.getString("overview")));
            }
        }catch (Exception e){ e.printStackTrace(); }
    }
}
