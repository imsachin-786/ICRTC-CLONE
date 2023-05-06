package com.fms.irctcapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2;
    Button b1,b2;
    Data d = new Data(this);
    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=(EditText)findViewById(R.id.email);
        e2=(EditText)findViewById(R.id.pass);
        b2=(Button)findViewById(R.id.Login);
        t1=(TextView)findViewById(R.id.newRegister);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                if(d.emailpassword(s1 , s2)){
                    Intent i1 = new Intent(MainActivity.this,Dashboard.class);
                    startActivity(i1);
                }
                else{
                    Toast.makeText(MainActivity.this, "Email or Password Not matched", Toast.LENGTH_SHORT).show();
                }
            }
        });

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(MainActivity.this,Register1.class);
                startActivity(i2);
            }
        });
    }
}
