package com.example.saksh.bookme_project;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;


public class Activity2 extends AppCompatActivity {

    DatePickerDialog picker;
    EditText eText;

    class Movie {
        public String name;
        public float rating;
        Movie(String name, float rating){
            this.name = name;
            this.rating = rating;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        eText=findViewById(R.id.edit1);
        eText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker = new DatePickerDialog(Activity2.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                eText.setText((monthOfYear + 1) + "/" + dayOfMonth + "/" + year);
                                populateMovies(dayOfMonth, monthOfYear, year);
                            }
                        }, year, month, day);
                picker.getDatePicker().setMinDate(cldr.getTimeInMillis());
                picker.getDatePicker().setMaxDate(cldr.getTimeInMillis()+ 518400000);
                picker.show();
            }
        });
    }


    public void nextActivity(View view){
        Intent intent = new Intent(Activity2.this, Activity3.class);
        startActivity(intent);
    }

    @SuppressLint("ResourceType")
    public void populateMovies(int day, int month, int year) {
        //Log.i("populateMovies", "Day -> " + day);
        //get the date and the month. Select the movie. Based on movie,date,month selection,
        //map it to the ShowTiming object.
        final Movie[] movie = new Movie[5];
        movie[0] = new Movie("Fantastic Beasts: The Crimes of Grindelwald", (float)7.0);
        movie[1] = new Movie("The Grinch", (float)6.4);
        movie[2] = new Movie("Bohemian Rhapsody", (float)8.3);
        movie[3] = new Movie("The Dark Knight", (float)9.1);
        movie[4] = new Movie("Ralph Breaks the Internet", (float)7.8);

        RelativeLayout rl = findViewById(R.id.relativeLayout);
        for (int i = 0; i < movie.length; i++) {
            float stepSize = (float) 0.5;
            TextView textview = new TextView(this);
            textview.setText(movie[i].name);
            textview.setId(2000 + i);
            textview.setTextSize(16);
            textview.setTypeface(Typeface.create("sans-serif-condensed", Typeface.BOLD));
            int width_text = 400;

            RatingBar ratingBar = new RatingBar(this,null, android.R.attr.ratingBarStyleSmall);
            ratingBar.setId(1500 + i);
            ratingBar.setNumStars(5);
            ratingBar.setStepSize(stepSize);
            ratingBar.setIsIndicator(true);
            ratingBar.setRating(movie[i].rating/2);

            RelativeLayout.LayoutParams rlp2 = new RelativeLayout.LayoutParams(
                    width_text,
                    RelativeLayout.LayoutParams.WRAP_CONTENT);
            rlp2.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
            rlp2.addRule(RelativeLayout.BELOW, textview.getId() - 1);
            rlp2.setMargins(0,15,0,15 );
            textview.setLayoutParams(rlp2);
            rl.addView(textview);
            final String mName = movie[i].name;
            textview.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    //Toast.makeText(getBaseContext(), "Movie name: " + mName, Toast.LENGTH_SHORT).show();
                    PopupMenu menu = new PopupMenu(getApplicationContext(), v);
                    menu.getMenu().add("10:00 AM");
                    menu.getMenu().add("1:00 PM");
                    menu.getMenu().add("4:00 PM");
                    menu.getMenu().add("7:00 PM");
                    menu.getMenu().add("10:00 PM");
                    menu.show();
//                        menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
//                            public boolean onMenuItemClick(MenuItem item) {
//                                return true;
//                            }
//                        });
                }
            });
            RelativeLayout.LayoutParams rlp1 = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT);
            rlp1.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            rlp1.addRule(RelativeLayout.BELOW, textview.getId() - 1);
            rlp1.setMargins(0,15, 5, 15);
            ratingBar.setLayoutParams(rlp1);
            rl.addView(ratingBar);
        }
   }
}

