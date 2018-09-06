package com.udacity.gradle.builditbigger;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.aryan.javajokes.Joker;
import com.aryan.jokedisplaylib.JokeDisplayActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button tellJokeButton = (Button) findViewById(R.id.telljokebutton);
        final Joker joker = new Joker();

        tellJokeButton.setOnClickListener(new View.OnClickListener() {
                                              @SuppressLint("StaticFieldLeak")
                                              @Override
                                              public void onClick(View view) {
//                Toast.makeText(MainActivity.this,""+joker.getJoke(),Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(MainActivity.this,JokeDisplayActivity.class);
//                intent.putExtra(getString(R.string.jokeIntentExtra),""+joker.getJoke());
//                startActivity(intent);
                                                  new EndpointsAsyncTask() {
                                                      @Override
                                                      protected void onPostExecute(String output) {
                                                          Intent myIntent = new Intent(getApplicationContext(), JokeDisplayActivity.class);
                                                          myIntent.putExtra(getString(R.string.jokeIntentExtra), output);
                                                          startActivity(myIntent);
                                                      }
                                                  }.execute(new Pair<Context, String>(MainActivity.this, "Manfred"));
                                              }
                                          }
        );
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
        Toast.makeText(this, "derp", Toast.LENGTH_SHORT).show();
    }


}

