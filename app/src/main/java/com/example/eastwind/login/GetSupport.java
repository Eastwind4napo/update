package com.example.eastwind.login;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by Niroshana on 5/1/2017.
 */

public class GetSupport extends FragmentActivity {

    public void FragmentHandler(int id, Fragment fragment){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.add(id,fragment);
        transaction.commit();
    }

}
