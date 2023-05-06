package com.fms.irctcapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class Dashboard extends AppCompatActivity {


    Button b1 , b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        b1 = (Button) findViewById(R.id.Search);
        b2 = (Button) findViewById(R.id.PNRSearch);

        b1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i2 = new Intent(Dashboard.this,SearchBar.class);
                startActivity(i2);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String url="https://indianrail.gov.in/enquiry/PNR/PnrEnquiry.html?locale=en";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });

    }





}