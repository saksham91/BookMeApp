package com.example.saksh.bookme_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class Activity3 extends AppCompatActivity{
    Spinner spinner;
    Boolean num_selected = false;
    String tickets;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        spinner = findViewById(R.id.spinner);
        String[] num_of_tickets = {"1", "2", "3", "4", "5", "6", "7"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, num_of_tickets);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0:
                        tickets = "1";
                        break;
                    case 1:
                        tickets = "2";
                        break;
                    case 2:
                        tickets = "3";
                        break;
                    case 3:
                        tickets = "4";
                        break;
                    case 4:
                        tickets = "5";
                        break;
                    case 5:
                        tickets = "6";
                        break;
                    case 6:
                        tickets = "7";
                        break;
                }
            }
            public void onNothingSelected(AdapterView<?> parent){
                tickets = "1";
            }
        });
        //Toast.makeText(getBaseContext(), "Tickets " + tickets, Toast.LENGTH_LONG).show();
        num_selected = true;
    }

    public void nextActivity4(View view){
        Intent intent = new Intent(Activity3.this, Activity4.class);
        String movie = getIntent().getStringExtra("Movie");
        String day = getIntent().getStringExtra("Day");
        String time_s = getIntent().getStringExtra("Time");
        String month = getIntent().getStringExtra("Month");
        intent.putExtra("Movie", movie);
        intent.putExtra("Day", day);
        intent.putExtra("Time", time_s);
        intent.putExtra("Month", month);
        intent.putExtra("Tickets", tickets);
        startActivity(intent);
    }
}
