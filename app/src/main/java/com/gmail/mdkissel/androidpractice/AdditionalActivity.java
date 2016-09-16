package com.gmail.mdkissel.androidpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

public class AdditionalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_additional);

        String receivedString = getIntent().getStringExtra(MainActivity.EXTRA_HELLO_ANDROID);
        int receivedInt = getIntent().getIntExtra(MainActivity.EXTRA_RATING, 0);

        RatingBar ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        TextView textView = (TextView) findViewById(R.id.textView);

        ratingBar.setRating(receivedInt);
        textView.setText(receivedString);
    }
}
