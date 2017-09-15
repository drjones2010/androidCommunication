package com.example.androidcomm;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Sends data to Case4F2Fragment using Bundle arguments.
 */
public class Case4F1Fragment extends Fragment{

    Button mNext;
    EditText mName;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_case4_f1, container, false);

        mName = (EditText) v.findViewById(R.id.et_name);

        mNext = (Button) v.findViewById(R.id.bt_next);
        mNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Replaces current fragment with a new instance of Case3F2Fragment.
                getFragmentManager().beginTransaction()
                        .replace(((ViewGroup) getView().getParent()).getId(),
                                //Instantiate with static method to pass arguments
                                Case4F2Fragment.newInstance(mName.getText().toString()))
                        .addToBackStack(null)
                        .commit();
            }
        });

        return v;
    }
}
