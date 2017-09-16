package com.filho.filho;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by HeryVandoro on 9/16/2017.
 */

public class HelpActivity extends AppCompatActivity implements View.OnClickListener{

    EditText question;
    Button sendBtn;
    TextView helpIntro;

    Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        loadAttribute();
    }

    public void loadAttribute(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        toolbar.setTitle("Help");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        question = (EditText) findViewById(R.id.question);
        sendBtn = (Button) findViewById(R.id.buttonSend);
        helpIntro = (TextView) findViewById(R.id.helpText);

        helpIntro.setText("If you have any question or found some bugs in this application, " +
                    "please send me a messages by email at vandorohery99@gmail.com. " +
                    "Also, you can write it on the form below :");
    }

    public void sendMessages(){
        if(question.getText().toString().isEmpty()){
            Toast.makeText(this, "Please insert a question!", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "berangkatt", Toast.LENGTH_SHORT).show();
            question.setText("");
        }
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.sendBtn :
                sendMessages();
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home :
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
