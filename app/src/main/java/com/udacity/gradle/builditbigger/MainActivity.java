package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.udacity.gradle.javajokelib.JokeSmith;
import com.udacity.gradle.myandroidlibrary.AndroidLibraryActivity;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {

        new EndpointsAsyncTask().execute(new Pair<Context, String>(this, "Manfred"));
/*        Intent jokeIntent = new Intent(this, AndroidLibraryActivity.class);
        jokeIntent.putExtra(Intent.EXTRA_TEXT, JokeSmith.tellAHandCraftedJoke());
        if (jokeIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(jokeIntent);
        }*/
        //Toast.makeText(this, ,Toast.LENGTH_SHORT).show();
    }


}
