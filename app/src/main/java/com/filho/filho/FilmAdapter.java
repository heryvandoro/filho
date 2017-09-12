package com.filho.filho;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.filho.filho.helper.ImageDownloader;

import java.util.Vector;

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
        setNotifyOnChange(false);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder holder;

        if(view==null){
            LayoutInflater inflater = context.getLayoutInflater();
            view = inflater.inflate(R.layout.film_layout_1, null,true);

            holder = new ViewHolder();
            holder.filmTitle = (TextView) view.findViewById(R.id.filmTitle);
            holder.filmDate = (TextView) view.findViewById(R.id.filmDate);
            holder.filmCover = (ImageView) view.findViewById(R.id.filmCover);

            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }
        Film film = films.get(position);

        if(film!=null){
            holder.filmTitle.setText(film.getFilmTitle());
            holder.filmDate.setText(film.getFilmDate());

            new ImageDownloader(holder.filmCover).execute(film.getFilmCoverURL());
        }
        return view;
    }

    public class ViewHolder{
        TextView filmTitle;
        TextView filmDate;
        ImageView filmCover;
    }
}
