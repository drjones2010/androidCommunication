package com.example.androidcomm;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Allows navigation to Case3F2Fragment.
 */
public class Case3F2Fragment extends Fragment {

    Button mBack;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_case3_f2, container, false);


        mBack = (Button) v.findViewById(R.id.bt_back);
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Replaces current fragment with a new instance of Case3F2Fragment.
                getFragmentManager().beginTransaction()
                        .replace(((ViewGroup) getView().getParent()).getId(), new Case3F1Fragment())
                        .addToBackStack(null)
                        .commit();
            }
        });

        return v;

    }
}
