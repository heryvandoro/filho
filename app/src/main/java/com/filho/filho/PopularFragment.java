package com.filho.filho;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.filho.filho.helper.APIConstans;
import com.filho.filho.helper.JSONParser;
import com.filho.filho.helper.TmdbAPI;
import org.json.JSONObject;
import java.util.Vector;

public class PopularFragment extends Fragment implements AdapterView.OnItemClickListener{

    ListView listView;
    Vector<Film> films = new Vector<Film>();

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //Toast.makeText(view.getContext(), ((Film) parent.getItemAtPosition(position)).getFilmTitle(), Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this.getActivity(), DetailActivity.class);
        i.putExtra("film_id", ((Film) parent.getItemAtPosition(position)).getFilmID());
        startActivity(i);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_popular, container, false);
        listView = (ListView) rootView.findViewById(R.id.listview_popular);

        Vector<JSONObject> data = null;
        try{
            data = JSONParser.getArray(
                    new JSONObject(TmdbAPI.getRequest(APIConstans.POPULAR_THIS_YEAR)
                    ), "results");

            for(JSONObject x : data){
                films.add(new Film(x.getInt("id"), x.getString("title"),
                        x.getString("release_date"), x.getInt("vote_average"),
                        x.getString("poster_path"), x.getString("overview")));
            }
        }catch (Exception e){ e.printStackTrace(); }

        FilmAdapter adapter = new FilmAdapter((AppCompatActivity) getActivity(), films);
        listView.setOnItemClickListener(this);
        listView.setAdapter(adapter);

        return rootView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
