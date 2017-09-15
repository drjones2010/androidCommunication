package com.example.androidcomm;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Instantiate and pass data to a dialog, which passes updated data back.
 */
public class Case6Fragment extends Fragment{

    private static final int REQUEST_CODE_NAME = 1;
    //
    private static final String DIALOG_NAME = "DialogName";
    public static final String EXTRA_NAME = "com.playgroundApp.playgroundApp.name";

    Button mButtonDialog;

    TextView mName;
    private String mNameString;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_case6, container, false);


        mName = (TextView) v.findViewById(R.id.tv_name);
        validateName();

        mButtonDialog = (Button) v.findViewById(R.id.bt_dialog);
        mButtonDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getFragmentManager();
                Case6Dialog dialog = Case6Dialog.newInstance(mName.getText().toString());
                // For receiving data from the dialog.
                dialog.setTargetFragment(Case6Fragment.this, REQUEST_CODE_NAME);
                dialog.show(manager, DIALOG_NAME);
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

    /**
     * Intercepts Activity's extra
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Exits if user presses back
        if (resultCode != Activity.RESULT_OK){
            return;
        } else if (requestCode == REQUEST_CODE_NAME){
            mNameString = data.getStringExtra(EXTRA_NAME);
            validateName();
        }
    }
}
