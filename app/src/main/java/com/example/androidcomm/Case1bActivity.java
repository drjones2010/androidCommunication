package com.example.androidcomm;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Receives data from parent activity Case1aActivity.
 */
public class Case1bActivity extends AppCompatActivity{

    /**
     * Key for retrieving of the extra. Since any app could launch an intent, appending package
     * before the real key reduce the chance to collide with objects coming from other apps.
     */
    private static final String EXTRA_NAME = "com.playgroundApp.playgroundApp.name";

    TextView mName;
    Button mExit;
    Button mBack;

    public static Intent newIntent(Context packageContext, String name){
        Intent intent = new Intent(packageContext, Case1bActivity.class);
        intent.putExtra(EXTRA_NAME, name);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case1_b);

        mName = (TextView) findViewById(R.id.tv_name);

        String name = getIntent().getStringExtra(EXTRA_NAME);

        validateName(name);

        mExit = (Button) findViewById(R.id.bt_exit);
        mExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Case1bActivity.this, WelcomeActivity.class);
                startActivity(i);
            }
        });

        mBack = (Button) findViewById(R.id.bt_back);
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Case1bActivity.this, Case1aActivity.class);
                startActivity(i);
            }
        });

    }

    private void validateName(String name) {
        if ("".equals(name)) {
            mName.setText(R.string.no_name_provided);
            mName.setTextColor(Color.RED);
            mName.setTypeface(null, Typeface.ITALIC);
        } else {
            mName.setText(name);
            mName.setTextColor(Color.BLUE);
            mName.setTypeface(null, Typeface.BOLD);
        }
    }
}
