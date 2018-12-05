package com.example.saksh.bookme_project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Toast;

import java.util.Random;


public class Activity6 extends AppCompatActivity {

    private static final String ALLOWED_CHARACTERS ="0123456789QWERTYUIOPLKJHGFDSAZXCVBNM";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_6);
        String rand = getRandomString(10);
        String phone = getIntent().getStringExtra("Phone");
        //Toast.makeText(getBaseContext(), "Phone -> "+phone, Toast.LENGTH_LONG).show();
        sendSMS(phone, rand);
    }

    public void onBackPressed() {
        //Toast.makeText(getBaseContext(), "Hahahaha..", Toast.LENGTH_LONG).show();
    }

    public void homeActivity(View view){
        Intent intent = new Intent(Activity6.this, MainActivity.class);
        startActivity(intent);
    }

    private static String getRandomString(final int sizeOfRandomString)
    {
        final Random random = new Random();
        final StringBuilder sb = new StringBuilder(sizeOfRandomString);
        for(int i = 0; i < sizeOfRandomString; ++i)
            sb.append(ALLOWED_CHARACTERS.charAt(random.nextInt(ALLOWED_CHARACTERS.length())));
        return sb.toString();
    }

    public void sendSMS(String phoneNo, String msg) {
        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNo, null, msg, null, null);
            Toast.makeText(getApplicationContext(), "Message Sent",
                    Toast.LENGTH_LONG).show();
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(),ex.getMessage().toString(),
                    Toast.LENGTH_LONG).show();
            ex.printStackTrace();
        }
    }
}
