package com.example.androidcomm;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Receive data from child activity Case2bActivity.
 */
public class Case2aActivity extends AppCompatActivity{

    //Identifies the child activity of the returning data (in case there are more)
    private static final int REQUEST_CODE_NAME = 1;

    private static final String EXTRA_NAME = "com.playgroundApp.playgroundApp.name";

    TextView mName;
    Button mNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case2_a);

        mName = (TextView) findViewById(R.id.tv_name);

        mNext = (Button) findViewById(R.id.bt_next);
        mNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Case2aActivity.this, Case2bActivity.class);

                //Attach a request code for returning back data
                startActivityForResult(i, REQUEST_CODE_NAME);
            }
        });

    }

    /**
     * Receive incoming data.
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            //Extracts data from the returning intent
            String name = data.getStringExtra(EXTRA_NAME);
            validateName(name);

            //If user pressed back without sending data
        } else if (resultCode == RESULT_CANCELED) {
            mName.setText(getString(R.string.back_pressed));
            mName.setTextColor(Color.MAGENTA);
            mName.setTypeface(null, Typeface.ITALIC);
        }


    }

    private void validateName(String name) {
        if ("".equals(name)) {
            mName.setText(getString(R.string.no_name_provided));
            mName.setTextColor(Color.RED);
            mName.setTypeface(null, Typeface.ITALIC);
        } else if (name == null) {
            mName.setText("");
        } else {
            mName.setText(name);
            mName.setTextColor(Color.BLUE);
            mName.setTypeface(null, Typeface.BOLD);
        }
    }
}
