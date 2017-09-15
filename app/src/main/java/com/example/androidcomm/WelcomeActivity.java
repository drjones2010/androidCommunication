package com.example.androidcomm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Simple navigation between activities.
 */
public class WelcomeActivity extends AppCompatActivity {

    Button case1, case2, case3, case4, case5, case6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        case1 = (Button) findViewById(R.id.case1);
        case1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //The intent needs two parameters: source context, child activity class.
                Intent i = new Intent(WelcomeActivity.this, Case1aActivity.class);
                startActivity(i);
            }
        });

        case2 = (Button) findViewById(R.id.case2);
        case2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(WelcomeActivity.this, Case2aActivity.class);
                startActivity(i);
            }
        });

        case3 = (Button) findViewById(R.id.case3);
        case3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(WelcomeActivity.this, Case3Activity.class);
                startActivity(i);
            }
        });

        case4 = (Button) findViewById(R.id.case4);
        case4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(WelcomeActivity.this, Case4Activity.class);
                startActivity(i);
            }
        });

        case5 = (Button) findViewById(R.id.case5);
        case5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(WelcomeActivity.this, Case5Activity.class);
                startActivity(i);
            }
        });

        case6 = (Button) findViewById(R.id.case6);
        case6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(WelcomeActivity.this, Case6Activity.class);
                startActivity(i);
            }
        });


    }


}
