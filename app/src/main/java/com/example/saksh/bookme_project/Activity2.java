package com.example.saksh.bookme_project;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;


public class Activity2 extends AppCompatActivity {

    DatePickerDialog picker;
    EditText eText;
    String movie_selected = null;
    String day_selected;
    String month_selected;
    String year_selected;
    String what_time = null;
    Boolean time_selected = false;
    Boolean date_selected = false;

    class Movie {
        public String name;
        public float rating;
        public ArrayList<String> timings;
        Movie(String name, float rating, ArrayList<String> timings){
            this.name = name;
            this.rating = rating;
            this.timings = timings;
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
                date_selected = true;
                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(eText.getWindowToken(), 0);
            }
        });
    }


    public void nextActivity(View view){
        Intent intent = new Intent(Activity2.this, Activity3.class);
        if(!date_selected){
            Toast.makeText(getBaseContext(), "Please select the date", Toast.LENGTH_SHORT).show();
        }
        else if(movie_selected == null){
            Toast.makeText(getBaseContext(), "Please select the movie", Toast.LENGTH_SHORT).show();
        }
        else if(!time_selected){
            Toast.makeText(getBaseContext(), "Please select the time", Toast.LENGTH_SHORT).show();
        }
        else{
            intent.putExtra("Movie", movie_selected);
            intent.putExtra("Day", day_selected);
            intent.putExtra("Month", month_selected);
            intent.putExtra("Time", what_time);
            startActivity(intent);
        }
    }

    @SuppressLint("ResourceType")
    public void populateMovies(int day, int month, int year) {
        //Log.i("populateMovies", "Day -> " + day);
        //get the date and the month. Select the movie. Based on movie,date,month selection,
        //map it to the ShowTiming object.
        day_selected = day+"";
        month_selected = (month + 1) + "";
        year_selected= year+"";
        final Movie[] movie = new Movie[5];
        String times0[] = {"10:00 AM", "1:00 PM", "4:00 PM", "7:00 PM", "10:00 PM"};
        String times1[] = {"9:00 AM", "12:00 PM", "3:00 PM", "6:00 PM", "9:00 PM"};
        String times2[] = {"11:00 AM", "2:00 PM", "5:00 PM", "8:00 PM", "11:00 PM"};
        String times3[] = {"8:00 AM", "1:00 PM", "4:00 PM", "7:00 PM", "10:00 PM"};
        String times4[] = {"10:00 AM", "2:00 PM", "5:00 PM", "8:00 PM", "10:30 PM"};
        ArrayList<String> time0 = new ArrayList<String>(Arrays.asList(times0));
        ArrayList<String> time1 = new ArrayList<String>(Arrays.asList(times1));
        ArrayList<String> time2 = new ArrayList<String>(Arrays.asList(times2));
        ArrayList<String> time3 = new ArrayList<String>(Arrays.asList(times3));
        ArrayList<String> time4 = new ArrayList<String>(Arrays.asList(times4));

        movie[0] = new Movie("Fantastic Beasts: The Crimes of Grindelwald", (float)7.0,time0);
        movie[1] = new Movie("The Grinch", (float)6.4,time1);
        movie[2] = new Movie("Bohemian Rhapsody", (float)8.3, time2);
        movie[3] = new Movie("The Dark Knight", (float)9.1, time3);
        movie[4] = new Movie("Ralph Breaks the Internet", (float)7.8, time4);

        RelativeLayout rl = findViewById(R.id.relativeLayout);
        for (int i = 0; i < movie.length; i++) {
            float stepSize = (float) 0.5;
            final TextView textview = new TextView(this);
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
            final ArrayList<String> temptime= new ArrayList<String>(movie[i].timings);
            textview.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    movie_selected = mName;
                    //Toast.makeText(getBaseContext(), mName, Toast.LENGTH_SHORT).show();
                    PopupMenu menu = new PopupMenu(getApplicationContext(), v, Gravity.RIGHT);
                    for (int i = 0; i < 5; i++) {
                        menu.getMenu().add(temptime.get(i));
                    }
                    menu.show();
                        menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                            public boolean onMenuItemClick(MenuItem item) {
                                time_selected = true;
                                Toast.makeText(getBaseContext(),movie_selected + ", " + item.getTitle(), Toast.LENGTH_SHORT).show();
                                what_time = (String)item.getTitle();
                                return true;
                            }
                        });
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

