package com.example.eastwind.login;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.eastwind.login.mFragment.Tab1Home;
import com.example.eastwind.login.mFragment.Tab2GHouse;
import com.example.eastwind.login.mFragment.Tab3Analytics;
import com.example.eastwind.login.mFragment.Tab4Chat;
import com.example.eastwind.login.mFragment.Tab5Log;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Tab_main extends AppCompatActivity{


    private ViewPager mViewPager;
    private BottomNavigationView bottomNavigationView;
    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener authListener;
    FirebaseDatabase mbd;
    DatabaseReference mdbr;
    Fragment fragment = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        FirebaseApp.initializeApp(this);
        mbd = FirebaseDatabase.getInstance();
        mAuth = FirebaseAuth.getInstance();
        mdbr = mbd.getReference();



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tmain);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottom_navigation_bar);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                if (item.getItemId() == R.id.ihome) {
                    fragment = new Tab1Home();
                        getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.ifragment, fragment)
                            .commit();
                        return true;
                }else if (item.getItemId() == R.id.ighouse) {
                    fragment = new Tab2GHouse();
                        getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.ifragment, fragment)
                            .commit();
                        return true;
                }else if (item.getItemId() == R.id.ianalytics) {
                    fragment = new Tab3Analytics();
                         getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.ifragment, fragment)
                            .commit();
                        return true;
                }else if (item.getItemId() == R.id.ichat) {
                    fragment = new Tab4Chat();
                        getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.ifragment, fragment)
                            .commit();
                        return true;
                }else if (item.getItemId() == R.id.ilog){
                    fragment = new Tab5Log();
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.ifragment, fragment)
                                .commit();
                    return true;
                }
                return false;
            }
        });
        }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_logout) {
            mAuth.signOut();
            startActivity(new Intent(this, Login.class));
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

}
