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

import java.util.Vector;

/**
 * Created by HeryVandoro on 9/16/2017.
 */

public abstract class FilmFragment extends Fragment implements AdapterView.OnItemClickListener{
    ListView listView;
    Vector<Film> films = new Vector<Film>();

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent i = new Intent(this.getActivity(), DetailActivity.class);
        i.putExtra("film_id", ((Film) parent.getItemAtPosition(position)).getFilmID());
        startActivity(i);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.listview_film_layout, container, false);
        listView = (ListView) rootView.findViewById(R.id.listview_film);

        loadFilmData();

        FilmAdapter adapter = new FilmAdapter((AppCompatActivity) getActivity(), films);
        listView.setOnItemClickListener(this);
        listView.setAdapter(adapter);

        return rootView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public abstract void loadFilmData();
}
