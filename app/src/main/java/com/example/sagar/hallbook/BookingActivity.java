package com.example.sagar.hallbook;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class BookingActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    ImageView vendorImage;
    TextView vendorName, vendorArea, discount;
    ListView amenitiesList, serviceList;
    String[] amenitiesArray = {"amenity 1","amenity 2","amenity 3", "amenity 1"};
    String[] serviceArray = {"Service 1", "Service 2", "Service 3", "Service 4",};
    private FloatingActionButton mainFab, bookingFab, galleryFab;
    boolean fabVisible = false;
    private TimePickerDialog timePickerDialog;
    private TextView date, month, year, shh, smm, ehh, emm;
    private Toolbar toolbar;
    private Dialog dialog;
    int selectedDate, selectedMonth, selectedYear, startTime, startMin, endTime, endMin, timepickerCount=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        mainFab = (FloatingActionButton) findViewById(R.id.mainFab);
        bookingFab = (FloatingActionButton) findViewById(R.id.bookingFab);
        galleryFab = (FloatingActionButton) findViewById(R.id.galleryFab);
        vendorImage =(ImageView) findViewById(R.id.vendorImage);
        vendorName = (TextView) findViewById(R.id.vendorName);
        vendorArea = (TextView) findViewById(R.id.vendorArea);
        discount = (TextView) findViewById(R.id.discount);
        amenitiesList =(ListView) findViewById(R.id.amenitiesList);
        serviceList =(ListView) findViewById(R.id.serviceList);

        vendorImage.setImageResource(getIntent().getIntExtra("thumbnail",0));
        vendorName.setText(getIntent().getStringExtra("name"));
        vendorArea.setText(getIntent().getStringExtra("area"));
        discount.setText("30%");

        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.list_layout,amenitiesArray);
        amenitiesList.setAdapter(adapter);
        adapter = new ArrayAdapter<String>(this, R.layout.list_layout,serviceArray);
        serviceList.setAdapter(adapter);

        mainFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(fabVisible)
                {
                    bookingFab.setVisibility(View.INVISIBLE);
                    galleryFab.setVisibility(View.INVISIBLE);
                    fabVisible = false;
                }
                else{
                    bookingFab.setVisibility(View.VISIBLE);
                    galleryFab.setVisibility(View.VISIBLE);
                    fabVisible = true;
                }
            }
        });

        Calendar c = Calendar.getInstance();
        int MONTH = c.get(Calendar.MONTH);
        int DATE = c.get(Calendar.DATE);
        int YEAR = c.get(Calendar.YEAR);
        int HOUR = c.get(Calendar.HOUR_OF_DAY);
        int MIN = c.get(Calendar.MINUTE);

        final DatePickerDialog datePickerDialog = new DatePickerDialog(BookingActivity.this,this,YEAR,MONTH,DATE);
        timePickerDialog = new TimePickerDialog(BookingActivity.this,this,HOUR,MIN,true);

        bookingFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog.show();
            }
        });
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        selectedDate = dayOfMonth;
        selectedMonth = month;
        selectedYear = year;
        timePickerDialog.show();
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

        if(timepickerCount == 1){
            startTime = hourOfDay;
            startMin = minute;
            timepickerCount++;
            timePickerDialog = new TimePickerDialog(BookingActivity.this,this,startTime,startMin,true);
            timePickerDialog.show();
        }
        else if(timepickerCount == 2){
            endTime = hourOfDay;
            endMin = minute;
            timepickerCount = 1;
            dialog = new Dialog(this);
            dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.dialog_layout);
            toolbar = (Toolbar) dialog.findViewById(R.id.toolbar);
            toolbar.setTitle("Summary");
            date = (TextView) dialog.findViewById(R.id.date);
            month = (TextView) dialog.findViewById(R.id.month);
            year = (TextView) dialog.findViewById(R.id.year);
            shh = (TextView) dialog.findViewById(R.id.startTime);
            smm = (TextView) dialog.findViewById(R.id.startMin);
            ehh = (TextView) dialog.findViewById(R.id.endTime);
            emm = (TextView) dialog.findViewById(R.id.endMin);
            date.setText(String.valueOf(selectedDate));
            month.setText(String.valueOf(selectedMonth));
            year.setText(String.valueOf(selectedYear));
            shh.setText(String.valueOf(startTime));
            smm.setText(String.valueOf(startMin));
            ehh.setText(String.valueOf(endTime));
            emm.setText(String.valueOf(endMin));
            dialog.show();

        }
    }

    public void onCancel(View view) {
        dialog.hide();
    }
}
