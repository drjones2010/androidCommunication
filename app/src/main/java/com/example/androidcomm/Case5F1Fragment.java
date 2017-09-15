package com.example.androidcomm;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Receive data from Case5F2Fragment.
 */
public class Case5F1Fragment extends Fragment{

    private static String ARG_NAME = "Name";

    Button mNext;

    TextView mName;
    private String mNameString;


    public static Case5F1Fragment newInstance(String name){
        Bundle args = new Bundle();
        args.putSerializable(ARG_NAME, name);
        Case5F1Fragment fragment = new Case5F1Fragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null)
            mNameString = getArguments().getString(ARG_NAME);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_case5_f1, container, false);


        mName = (TextView) v.findViewById(R.id.tv_name);
        validateName();


        mNext = (Button) v.findViewById(R.id.bt_next);
        mNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Case5F2Fragment f2 = new Case5F2Fragment();
                getFragmentManager()
                        .beginTransaction()
                        .replace(((ViewGroup)getView().getParent()).getId(), f2)
                        .addToBackStack(null)
                        .commit();
            }
        });

        return v;
    }

    private void validateName() {
        if ("".equals(mNameString)) {
            mName.setText(getString(R.string.no_name_provided));
            mName.setTextColor(Color.RED);
            mName.setTypeface(null, Typeface.ITALIC);
        } else {
            mName.setText(mNameString);
            mName.setTextColor(Color.BLUE);
            mName.setTypeface(null, Typeface.BOLD);
        }
    }

}
