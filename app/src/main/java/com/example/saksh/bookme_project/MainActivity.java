package com.example.saksh.bookme_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onBackPressed() {
        //Toast.makeText(getBaseContext(), "Hahahaha..", Toast.LENGTH_LONG).show();
    }
    public void nextActivity(View view){
        Intent intent = new Intent(MainActivity.this, Activity2.class);
        startActivity(intent);
    }
}
