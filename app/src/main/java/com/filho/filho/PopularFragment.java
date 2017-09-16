package com.filho.filho;

import com.filho.filho.helper.APIConstans;
import com.filho.filho.helper.JSONParser;
import com.filho.filho.helper.TmdbAPI;
import org.json.JSONObject;
import java.util.Vector;

public class PopularFragment extends FilmFragment{
    @Override
    public void loadFilmData() {
        Vector<JSONObject> data = null;
        try{
            data = JSONParser.getArray(
                    new JSONObject(TmdbAPI.getRequest(APIConstans.POPULAR)
                    ), "results");

            for(JSONObject x : data){
                films.add(new Film(x.getInt("id"), x.getString("title"),
                        x.getString("release_date"), x.getInt("vote_average"),
                        x.getString("poster_path"), x.getString("overview")));
            }
        }catch (Exception e){ e.printStackTrace(); }
    }
}
