package com.example.sagar.hallbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CategoriesActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private VendorAdapter mAdapter;
    private List<Vendor> vList;
    private int option;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        option = getIntent().getIntExtra("Option",0);
        setTitle(option);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        vList = new ArrayList<>();
        mAdapter =  new VendorAdapter(getApplicationContext(),vList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareVendorData();

    }

    private void prepareVendorData() {
        Vendor v;
        vList.clear();
        switch (option){
            case 1: v = new Vendor("Skyline Banquet","Chennai",R.drawable.sampleimage);
                    vList.add(v);
                    mAdapter.notifyDataSetChanged();
                break;
            case 2: v = new Vendor("Chennai Convention Center","ECR, Chennai",R.drawable.confsample);
                vList.add(v);
                mAdapter.notifyDataSetChanged();
                break;
            case 3: v = new Vendor("Ganesh Catering","West Tambaram",R.drawable.sampleimage);
                vList.add(v);
                mAdapter.notifyDataSetChanged();
                break;
            case 4: v = new Vendor("Brindavan Mini Hall","Pallikarnai",R.drawable.bdaysample);
                vList.add(v);
                mAdapter.notifyDataSetChanged();
                break;
            case 5: v = new Vendor("Absolute Event Decors","Choolaimedu, Chennai",R.drawable.decorsample);
                vList.add(v);
                mAdapter.notifyDataSetChanged();
                break;
            case 6: v = new Vendor("VURVE Signature Salon","Nungambakkam, Chennai",R.drawable.sampleimage);
                vList.add(v);
                mAdapter.notifyDataSetChanged();
                break;
            case 7: v = new Vendor("Shiva Catering Services","East Tambaram",R.drawable.sampleimage);
                vList.add(v);
                mAdapter.notifyDataSetChanged();
                break;
            default: onBackPressed();
        }
    }

    public void setTitle(int option)
    {
        switch (option){
            case 1: getSupportActionBar().setTitle("Banquet");
                break;
            case 2: getSupportActionBar().setTitle("Conference Hall");
                break;
            case 3: getSupportActionBar().setTitle("Catering");
                break;
            case 4: getSupportActionBar().setTitle("BirthDay Party");
                break;
            case 5: getSupportActionBar().setTitle("Function Decor");
                break;
            case 6: getSupportActionBar().setTitle("Make Up Artist");
                break;
            case 7: getSupportActionBar().setTitle("Outstation Catering");
                break;
            default: onBackPressed();
        }
    }
}
