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
 * Send data to Case5F1Fragment
 */
public class Case5F2Fragment extends Fragment{

    Button mBack;
    EditText mName;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_case5_f2, container, false);

        mName = (EditText) v.findViewById(R.id.et_name);


        mBack = (Button) v.findViewById(R.id.bt_back);
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getFragmentManager().beginTransaction()
                        .replace(((ViewGroup)
                                getView().getParent()).getId(), Case5F1Fragment.newInstance(mName.getText().toString()))
                        .addToBackStack(null)
                        .commit();
            }
        });

        return v;
    }

}
