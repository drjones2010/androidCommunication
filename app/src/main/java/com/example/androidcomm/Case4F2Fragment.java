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
 * Receive data from Case4F1Fragment.
 */
public class Case4F2Fragment extends Fragment{

    // Key for retrieving the argument.
    private static String NAME_ARG = "Name";

    Button mBack;

    TextView mName;
    String mNameString;

    public static Case4F2Fragment newInstance(String name){
        Bundle args = new Bundle();
        args.putSerializable(NAME_ARG, name);
        Case4F2Fragment fragment = new Case4F2Fragment();
        //Set the arguments inside the fragment
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Retrieve the argument before views are created
        mNameString = getArguments().getString(NAME_ARG);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_case4_f2, container, false);

        validateName(v);

        mBack = (Button) v.findViewById(R.id.bt_back);
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction()
                        .replace(((ViewGroup) getView().getParent()).getId(), new Case4F1Fragment())
                        .addToBackStack(null)
                        .commit();
            }
        });

        return v;
    }

    private void validateName(View v) {
        mName = (TextView) v.findViewById(R.id.tv_name);
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
