package com.example.saksh.bookme_project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class Activity6 extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity6);
    }

    public void onBackPressed() {
        //Toast.makeText(getBaseContext(), "Hahahaha..", Toast.LENGTH_LONG).show();
    }

    public void homeActivity(View view){
        Intent intent = new Intent(Activity6.this, MainActivity.class);
        startActivity(intent);
    }
}
