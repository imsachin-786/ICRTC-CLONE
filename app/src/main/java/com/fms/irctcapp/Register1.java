package com.fms.irctcapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;

public class Register1 extends AppCompatActivity {

    Data db;
    EditText e1, e2, e3;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register1);
        db = new Data(this);
        e1 = (EditText) findViewById(R.id.email);
        e2 = (EditText) findViewById(R.id.pass);
        e3 = (EditText) findViewById(R.id.confirmPass);
        b1 = (Button) findViewById(R.id.register);

        b1.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                      String s1 = e1.getText().toString();
                                      String s2 = e2.getText().toString();
                                      String s3 = e3.getText().toString();
                                      if (s1.equals("") || s2.equals("") || s3.equals("")) {
                                          Toast.makeText(getApplicationContext(), "Fields are empty", Toast.LENGTH_SHORT).show();
                                      } else {
                                          if (s2.equals(s3)) {
                                              Boolean checkmail = db.checkmail(s1);
                                              if (checkmail == true) {
                                                  Boolean insert = db.insert(s1, s2);
                                                  if (insert == true) {
                                                      Toast.makeText(getApplicationContext(), "Registered Successfully", Toast.LENGTH_SHORT).show();
                                                      Intent k = new Intent(Register1.this , MainActivity.class);
                                                      startActivity(k);
                                                  }
                                              } else {
                                                  Toast.makeText((getApplicationContext()), "Email Already Exists", Toast.LENGTH_SHORT).show();
                                              }
                                          } else {
                                              Toast.makeText((getApplicationContext()), "Password do no match", Toast.LENGTH_SHORT).show();
                                          }
                                      }
                                  }

                              }
        );

    }
}