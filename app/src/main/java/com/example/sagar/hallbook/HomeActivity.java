package com.example.sagar.hallbook;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

public class HomeActivity extends AppCompatActivity {

    private ImageView optBanq, optConf, optCater, optBirth, optDecor, optMakeUp, optOutCater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        optBanq = (ImageView) findViewById(R.id.optBanquet);
        optConf = (ImageView) findViewById(R.id.optConf);
        optCater = (ImageView) findViewById(R.id.optCater);
        optBirth = (ImageView) findViewById(R.id.optBirth);
        optDecor = (ImageView) findViewById(R.id.optDecor);
        optMakeUp = (ImageView) findViewById(R.id.optMakeUp);
        optOutCater = (ImageView) findViewById(R.id.optOutCater);

        optBanq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),CategoriesActivity.class);
                intent.putExtra("Option",1);
                startActivity(intent);
            }
        });
        optConf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),CategoriesActivity.class);
                intent.putExtra("Option",2);
                startActivity(intent);
            }
        });
        optCater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),CategoriesActivity.class);
                intent.putExtra("Option",3);
                startActivity(intent);
            }
        });
        optBirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),CategoriesActivity.class);
                intent.putExtra("Option",4);
                startActivity(intent);
            }
        });
        optDecor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),CategoriesActivity.class);
                intent.putExtra("Option",5);
                startActivity(intent);
            }
        });
        optMakeUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),CategoriesActivity.class);
                intent.putExtra("Option",6);
                startActivity(intent);
            }
        });
        optOutCater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),CategoriesActivity.class);
                intent.putExtra("Option",7);
                startActivity(intent);
            }
        });
    }


}
