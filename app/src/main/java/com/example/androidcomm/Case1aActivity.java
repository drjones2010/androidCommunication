package com.example.androidcomm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Sends data to the child activity Case1bActivity using an Intent Extra.
 */
public class Case1aActivity extends AppCompatActivity{

    EditText mName;
    Button mNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case1_a);

        mName = (EditText) findViewById(R.id.et_name);

        mNext = (Button) findViewById(R.id.bt_next);
        mNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /** Intent construction relies on the static method newIntent(...) of the child
                 * activity, which provide a contract for passing the right parameter.
                 */
                Intent i = Case1bActivity.newIntent(Case1aActivity.this, mName.getText().toString());
                startActivity(i);
            }
        });

    }
}
