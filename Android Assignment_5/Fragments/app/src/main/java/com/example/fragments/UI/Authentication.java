package com.example.fragments.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;


import com.example.fragments.R;

public class Authentication extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);

        if (savedInstanceState == null) {
            loadFragment(
                   R.id.frameLayout,
                    new FragmentLogin(),
                    FragmentLogin.CLASSTAG,
                    false
            );
        }
    }
    /**
     * Method to load fragment in activity. Kept this method as public so that all the fragments
     * and child activities can access this method
     * @param containerId : Id of the fraelayout
     * @param fragment : Object of Fragment class
     * @param classTag : Tag of the class
     * @param addToBackStack : Do we want to add this fragment to the backstack
     */
    public void loadFragment(
            int containerId,
            Fragment fragment,
            String classTag,
            boolean addToBackStack
    ) {
        try {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();

            if (addToBackStack) {
                transaction.add(containerId, fragment, classTag);
                transaction.addToBackStack(null);
            } else {
                transaction.add(containerId, fragment);
            }
            transaction.commitAllowingStateLoss();
        } catch (Exception e) {
            //TODO:: Log exception
        }
    }
}