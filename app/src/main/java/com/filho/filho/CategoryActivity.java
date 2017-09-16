package com.filho.filho;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.filho.filho.helper.APIConstans;
import com.filho.filho.helper.JSONParser;
import com.filho.filho.helper.TmdbAPI;

import org.json.JSONObject;

import java.util.Vector;

public class CategoryActivity extends AppCompatActivity {

    ListView listView;
    Vector<Film> films = new Vector<Film>();

    private String CATEGORY = "";

    Toolbar toolbar;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        listView = (ListView) findViewById(R.id.listview_film);

        CATEGORY = getIntent().getStringExtra("category_name");

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(CATEGORY);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
