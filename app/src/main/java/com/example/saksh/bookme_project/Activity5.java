package com.example.saksh.bookme_project;


import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.text.DecimalFormat;

public class Activity5 extends AppCompatActivity {
    String movie_name, show_time, day, month;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5);

        Intent intent = getIntent();
        String [] seatArray = intent.getStringArrayExtra("Array");
        movie_name = getIntent().getStringExtra("Movie");
        show_time = getIntent().getStringExtra("Time");
        day = getIntent().getStringExtra("Day");
        month = getIntent().getStringExtra("Month");

        TextView tv = findViewById(R.id.ticketnames);
        for(int i = 0; i < seatArray.length; i++){
            if(i == seatArray.length - 1){
                tv.append(seatArray[i]);
            }
            else {
                tv.append(seatArray[i] + ", ");
            }
        }

        TextView tv_movie = findViewById(R.id.MovieName);
        tv_movie.setText(movie_name);

        TextView tv_day = findViewById(R.id.ShowTime);
        tv_day.setText(month + "/"+ day);

        TextView tv_time = findViewById(R.id.DateandTime);
        tv_time.setText(show_time);

        calculate_cost(seatArray.length);
    }

    public void lastActivity(View view){
        Intent intent = new Intent(Activity5.this, Activity6.class);
        EditText et = findViewById(R.id.phone_num);
        if(et.getText().length() < 10){
            Toast.makeText(getBaseContext(), "Please enter a valid Phone Number", Toast.LENGTH_LONG).show();
        }
        else {
            intent.putExtra("Phone", et.getText().toString());
            intent.putExtra("Movie", movie_name);
            intent.putExtra("Time", show_time);
            intent.putExtra("Day", day);
            intent.putExtra("Month", month);
            startActivity(intent);
        }
    }

    public void calculate_cost(int num_tickets){
        double price_per_ticket = 10.0;
        double tax = 0.07;
        double total_tax;
        double total_price, base_price;
        double conv_fee = 4.0;

        base_price = price_per_ticket * num_tickets;
        TextView tv = findViewById(R.id.basepricecalculation);
        tv.setText("" + num_tickets + " x $" + price_per_ticket + " = $" + base_price);

        total_tax = round_2decimals(tax * base_price);
        TextView tv2 = findViewById(R.id.taxcalculation);
        tv2.setText("$" + base_price + " x " + tax + " = $" + total_tax);

        total_price = base_price + total_tax + conv_fee;
        TextView tv3 = findViewById(R.id.totalamountdue);
        tv3.setText("$"+total_price);
    }

    double round_2decimals(double val) {
        DecimalFormat df2 = new DecimalFormat("###.##");
        return Double.valueOf(df2.format(val));
    }



}
