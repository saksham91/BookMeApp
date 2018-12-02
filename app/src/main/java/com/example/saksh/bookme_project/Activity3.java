package com.example.saksh.bookme_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Activity3 extends AppCompatActivity{
    Spinner spinner;
    Boolean num_selected = false;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        spinner = findViewById(R.id.spinner);
        String[] num_of_tickets = {"1", "2", "3", "4", "5", "6", "7"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, num_of_tickets);
        spinner.setAdapter(adapter);
        num_selected = true;
    }

    public void nextActivity4(View view){
        Intent intent = new Intent(Activity3.this, Activity4.class);
        startActivity(intent);
    }
}
