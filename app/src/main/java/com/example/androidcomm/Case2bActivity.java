package com.example.androidcomm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Send data back to the parent activity Case2aActivity
 */
public class Case2bActivity extends AppCompatActivity{

    private static final String EXTRA_NAME = "com.playgroundApp.playgroundApp.name";

    EditText mName;
    Button mBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case2_b);

        mName = (EditText) findViewById(R.id.et_name);

        mBack = (Button) findViewById(R.id.bt_back);
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data =  new Intent();
                data.putExtra(EXTRA_NAME, mName.getText().toString());
                //Set data for parent activity, with a result code that specifies correct ending
                setResult(RESULT_OK, data);
                finish();
            }
        });

    }
}
