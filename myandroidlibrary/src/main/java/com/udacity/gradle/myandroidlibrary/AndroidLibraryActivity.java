package com.udacity.gradle.myandroidlibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class AndroidLibraryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.androidlibrary_activity_main);
        TextView mainTextView = (TextView) findViewById(R.id.androidactivity_main_textview);
        Intent JokeIntent = getIntent();
        if (JokeIntent.hasExtra(Intent.EXTRA_TEXT)){
            String libraryJoke = JokeIntent.getStringExtra(Intent.EXTRA_TEXT);
            mainTextView.setText(libraryJoke);
        }
    }
}