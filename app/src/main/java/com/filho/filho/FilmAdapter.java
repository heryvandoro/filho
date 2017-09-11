package com.filho.filho;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.filho.filho.helper.ImageDownloader;

import java.util.Vector;
import java.util.zip.Inflater;

/**
 * Created by HeryVandoro on 9/11/2017.
 */

public class FilmAdapter extends ArrayAdapter<Film> {
    private Vector<Film> films;
    private AppCompatActivity context = null;

    public FilmAdapter(AppCompatActivity context, Vector<Film> films) {
        super(context, R.layout.film_layout_1, films);

        this.context=context;
        this.films=films;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView!=null) return convertView;

        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.film_layout_1, null,true);

        TextView filmTitle = (TextView) rowView.findViewById(R.id.filmTitle);
        TextView filmDate = (TextView) rowView.findViewById(R.id.filmDate);
        ImageView filmCover = (ImageView) rowView.findViewById(R.id.filmCover);

        Film film = films.get(position);
        filmTitle.setText(film.getFilmTitle());
        filmDate.setText(film.getFilmDate());

        new ImageDownloader(filmCover).execute(film.getFilmCover());

        return rowView;
    }
}
