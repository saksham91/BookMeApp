package com.example.saksh.bookme_project;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupMenu;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

@SuppressLint("ResourceType")
public class Activity4 extends AppCompatActivity {
    int NUM_OF_TICKETS = 0;
    String tickets;
    final ArrayList<Integer> selected_seats = new ArrayList<Integer>();
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);
        LinearLayout linearLayout = findViewById(R.id.linearLayout);
        LinearLayout linearLayout0 = findViewById(R.id.linearLayout0);
        LinearLayout linearLayout1 = findViewById(R.id.linearLayout1);
        LinearLayout linearLayout2 = findViewById(R.id.linearLayout2);
        LinearLayout linearLayout3 = findViewById(R.id.linearLayout3);
        LinearLayout linearLayout4 = findViewById(R.id.linearLayout4);

        String movie = getIntent().getStringExtra("Movie");
        String time_s = getIntent().getStringExtra("Time");
        tickets = getIntent().getStringExtra("Tickets");

        TextView tv1 = findViewById(R.id.moviename);
        TextView tv2 = findViewById(R.id.showtime);
        TextView tv3 = findViewById(R.id.numberoftickets);
        tv1.setText(movie);
        tv2.append(time_s);
        tv3.append(tickets);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;

        //added LayoutParams
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(80, 80);
        params.setMargins(0,5,10,5);
        final int number_of_tickets = Integer.parseInt(tickets);
        NUM_OF_TICKETS = number_of_tickets;
        String alphabet[] = {"A", "B", "C", "D", "E", "F", "G"};
        for (int i = 0; i < 7; i++)
        {
            TextView textView = new TextView(this);
            textView.setText(alphabet[i]);
            textView.setId(100 + 5*i);
            textView.setGravity(Gravity.CENTER);
            textView.setTypeface(Typeface.create("sans-serif-condensed", Typeface.BOLD));
            textView.setTextSize(18);
            textView.setLayoutParams(params);
            linearLayout0.addView(textView);
        }
        //randomly assign seats
        ArrayList<Integer> rand_seats = new ArrayList<Integer>(15);
        for (int i = 0; i < 15; i++){
            int temp = (int)(Math.random() * 35);
            rand_seats.add(temp);
            //Log.i("onCreate", "Randseats"+ rand_seats);
        }

        for (int i = 0; i < 7; i++) {
            //added Button
            final Button button = new Button(this);
            button.setId(1+5*i);
            button.setText((button.getId()%5)+"");
            button.setLayoutParams(params);
            button.setBackgroundColor(getResources().getColor(R.color.button_stroke));
            if(rand_seats.contains(button.getId())){
                button.setEnabled(false);
                button.setBackgroundColor(Color.GRAY);
            }
            button.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    if (NUM_OF_TICKETS > 0 && !selected_seats.contains(button.getId())){
                        button.setBackgroundColor(getResources().getColor(R.color.bg_main));
                        selected_seats.add(button.getId());
                        NUM_OF_TICKETS--;
                    }
                    else if (NUM_OF_TICKETS >= 0 && selected_seats.contains(button.getId())) {
                        button.setBackgroundColor(getResources().getColor(R.color.button_stroke));
                        selected_seats.remove(new Integer(button.getId()));
                        NUM_OF_TICKETS++;
                    }
                }
            });


            final Button button1 = new Button(this);
            button1.setId(2+5*i);
            button1.setText((button1.getId()%5)+"");
            button1.setBackgroundColor(getResources().getColor(R.color.button_stroke));
            button1.setLayoutParams(params);
            if(rand_seats.contains(button1.getId())){
                button1.setEnabled(false);
                button1.setBackgroundColor(Color.GRAY);
            }
            button1.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    if (NUM_OF_TICKETS > 0 && !selected_seats.contains(button1.getId())){
                        button1.setBackgroundColor(getResources().getColor(R.color.bg_main));
                        selected_seats.add(button1.getId());
                        NUM_OF_TICKETS--;
                    }
                    else if (NUM_OF_TICKETS >= 0 && selected_seats.contains(button1.getId())) {
                        button1.setBackgroundColor(getResources().getColor(R.color.button_stroke));
                        selected_seats.remove(new Integer(button1.getId()));
                        NUM_OF_TICKETS++;
                    }
                }
            });

            final Button button2 = new Button(this);
            button2.setId(3+5*i);
            button2.setText((button2.getId()%5)+"");
            button2.setBackgroundColor(getResources().getColor(R.color.button_stroke));
            button2.setLayoutParams(params);
            if(rand_seats.contains(button2.getId())){
                button2.setEnabled(false);
                button2.setBackgroundColor(Color.GRAY);
            }
            button2.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    if (NUM_OF_TICKETS > 0 && !selected_seats.contains(button2.getId())){
                        button2.setBackgroundColor(getResources().getColor(R.color.bg_main));
                        selected_seats.add(button2.getId());
                        NUM_OF_TICKETS--;
                    }
                    else if (NUM_OF_TICKETS >= 0 && selected_seats.contains(button2.getId())) {
                        button2.setBackgroundColor(getResources().getColor(R.color.button_stroke));
                        selected_seats.remove(new Integer(button2.getId()));
                        NUM_OF_TICKETS++;
                    }
                }
            });

            final Button button3 = new Button(this);
            button3.setId(4+5*i);
            button3.setText((button3.getId()%5)+"");
            button3.setBackgroundColor(getResources().getColor(R.color.button_stroke));
            button3.setLayoutParams(params);
            if(rand_seats.contains(button3.getId())){
                button3.setEnabled(false);
                button3.setBackgroundColor(Color.GRAY);
            }
            button3.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    if (NUM_OF_TICKETS > 0 && !selected_seats.contains(button3.getId())){
                        button3.setBackgroundColor(getResources().getColor(R.color.bg_main));
                        selected_seats.add(button3.getId());
                        NUM_OF_TICKETS--;
                    }
                    else if (NUM_OF_TICKETS >= 0 && selected_seats.contains(button3.getId())) {
                        button3.setBackgroundColor(getResources().getColor(R.color.button_stroke));
                        selected_seats.remove(new Integer(button3.getId()));
                        NUM_OF_TICKETS++;
                    }
                }
            });

            final Button button4 = new Button(this);
            button4.setId(5+5*i);
            button4.setText((button4.getId()/(i+1))+"");
            button4.setBackgroundColor(getResources().getColor(R.color.button_stroke));
            button4.setLayoutParams(params);
            if(rand_seats.contains(button4.getId())){
                button4.setEnabled(false);
                button4.setBackgroundColor(Color.GRAY);
            }
            button4.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    if (NUM_OF_TICKETS > 0 && !selected_seats.contains(button4.getId())){
                        button4.setBackgroundColor(getResources().getColor(R.color.bg_main));;
                        selected_seats.add(button4.getId());
                        NUM_OF_TICKETS--;
                    }
                    else if (NUM_OF_TICKETS >= 0 && selected_seats.contains(button4.getId())) {
                        button4.setBackgroundColor(getResources().getColor(R.color.button_stroke));
                        selected_seats.remove(new Integer(button4.getId()));
                        NUM_OF_TICKETS++;
                    }
                }
            });

            linearLayout.addView(button);
            linearLayout1.addView(button1);
            linearLayout2.addView(button2);
            linearLayout3.addView(button3);
            linearLayout4.addView(button4);
        }
    }
    public void nextActivity(View view){
        if(selected_seats.size() < Integer.parseInt(tickets)){
            Toast.makeText(getBaseContext(), "Please select " + tickets + " seats", Toast.LENGTH_SHORT).show();
        }
        else{
            String[] seat_info = new String[7];
            seat_info = get_data();
            String movie = getIntent().getStringExtra("Movie");
            String day = getIntent().getStringExtra("Day");
            String month = getIntent().getStringExtra("Month");
            String time_s = getIntent().getStringExtra("Time");
            //Toast.makeText(getBaseContext(),"Seats->" + seat_info[0] + seat_info[1],Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Activity4.this, Activity5.class);
            intent.putExtra("Array", seat_info);
            intent.putExtra("Movie", movie);
            intent.putExtra("Time", time_s);
            intent.putExtra("Day", day);
            intent.putExtra("Month", month);
            startActivity(intent);
        }
    }

    public String[] get_data(){
        String seat_name = "";
        String[] final_seating = new String[selected_seats.size()];
        Integer[] seats = selected_seats.toArray(new Integer[selected_seats.size()]);
        int quotient_alphabet;
        String seat_number;
        for (int i = 0; i < seats.length; i++){
            quotient_alphabet = seats[i]/5;
            if(seats[i] % 5 == 0){
                quotient_alphabet = quotient_alphabet - 1;
            }
            seat_number = (seats[i] % 5) + "";
            if(seat_number.equals("0")){
                seat_number = "5";
            }
            switch(quotient_alphabet){
                case 0:
                    seat_name = "A" + seat_number;
                    break;
                case 1:
                    seat_name = "B" + seat_number;
                    break;
                case 2:
                    seat_name = "C" + seat_number;
                    break;
                case 3:
                    seat_name = "D" + seat_number;
                    break;
                case 4:
                    seat_name = "E" + seat_number;
                    break;
                case 5:
                    seat_name = "F" + seat_number;
                    break;
                case 6:
                    seat_name = "G" + seat_number;
                    break;
            }
            final_seating[i] = seat_name;
        }
        return final_seating;
    }
}
