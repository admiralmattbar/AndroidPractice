package com.gmail.mdkissel.androidpractice;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.gmail.mdkissel.androidpractice.AdditionalActivity;
import com.gmail.mdkissel.androidpractice.R;

public class MainActivity extends AppCompatActivity {

    public final static String EXTRA_HELLO_ANDROID ="com.gmail.mdkissel.androidpractice.ANDROID_PRACTICE";
    public final static String EXTRA_RATING = "com.gmail.mdkissel.androidpractice.RATING";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Setup Stuff
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {

            //Do something when the user clicks our floating action button
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AdditionalActivity.class);
                intent.putExtra(EXTRA_HELLO_ANDROID, "Hello Android");
                intent.putExtra(EXTRA_RATING, 3);
                startActivity(intent);
                Intent intent_imp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://educraft.org"));

                //Make sure you have an application that can handle this type of data.
                //If you don't do this, it will crash if you don't have that data.
                if(intent_imp.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent_imp);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        /*
        Hande action bar item clicks here. The action bar will
        automatically handle clicks on the Hom/Up button, so long
        as you specify a parent activity in AndroidManifest.xml.
         */
        int id = item.getItemId();

        //no inspection Simplifiable if statement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
