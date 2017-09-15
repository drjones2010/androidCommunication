package com.example.androidcomm;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

/**
 * Provides basic implementation for generic single fragment hosting activity.
 */
public abstract class SingleFragmentActivity extends AppCompatActivity {
    // Derived activities can decide which and how instantiate the fragment.
    protected abstract Fragment createFragment();

    @LayoutRes
    protected int getLayoutResId(){
        return R.layout.activity_fragment;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());

        // Manages lifecycle of fragments inside the stack (uses support.v4 library)
        FragmentManager fm = getSupportFragmentManager();
        // Designates the place where to put the fragment inside the activity layout.
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        // Adds the fragment inside the fragment container and into the fragment manager.
        if (fragment == null) {
            fragment = createFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit();
        }
    }
}
