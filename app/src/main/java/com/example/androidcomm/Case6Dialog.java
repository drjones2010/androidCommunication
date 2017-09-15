package com.example.androidcomm;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

/**
 * Receive data from his hosting fragment and sends updated data back inside Activity's extra.
 */
public class Case6Dialog extends DialogFragment{
    public static final String EXTRA_NAME = "com.playgroundApp.playgroundApp.name";
    private static final String ARG_NAME = "Name";

    EditText mName;
    String mNameString;

    public static Case6Dialog newInstance(String name) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_NAME, name);
        Case6Dialog fragment = new Case6Dialog();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String name = getArguments().getString(ARG_NAME);
        if (!("".equals(name)))
            mNameString=name;

    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View v = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_case6, null);

        mName = (EditText) v.findViewById(R.id.et_name);
        mName.setText(mNameString);

        return new AlertDialog.Builder(getActivity())
                .setView(v)
                .setTitle(R.string.dialog_title)
                .setPositiveButton(android.R.string.ok,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                sendResult(mName.getText().toString());
                            }
                        })
                .create();
    }

    /**
     * sends the data to the onActivityResult() of the Activity host
     * @param name the name which comes back to the hosting fragment
     */
    private void sendResult(String name) {
        Intent intent = new Intent();
        intent.putExtra(EXTRA_NAME, name);
/*
        if (getTargetFragment() == null) {
            // Send the data to the activity
            getActivity().setResult(getActivity().RESULT_OK, intent);
            return;
        }
*/
        // Send the data to the activity
        getTargetFragment().onActivityResult(getTargetRequestCode(), getActivity().RESULT_OK, intent);
    }

}
