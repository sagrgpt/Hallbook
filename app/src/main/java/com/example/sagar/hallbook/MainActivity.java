package com.example.sagar.hallbook;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Changing font for appname
        TextView appName = (TextView) findViewById(R.id.appName);
        appName.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/nosifer_regular.ttf"));

    }

    public void onSignup(View view) {
        startActivity(new Intent(MainActivity.this,SignupActivity.class));
    }

    public void onLogin(View view) {
        startActivity(new Intent(MainActivity.this, HomeActivity.class));
    }
}
