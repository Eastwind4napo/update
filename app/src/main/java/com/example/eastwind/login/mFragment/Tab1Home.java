package com.example.eastwind.login.mFragment;


import android.os.Bundle;

import android.support.v4.app.Fragment;


import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


import com.example.eastwind.login.R;




public class Tab1Home extends Fragment implements View.OnClickListener{
    private Button bt,bl,bh,bs;
    private TextView statusBar;

    Flag flag = new Flag();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab1home, container, false);
        bt = (Button) rootView.findViewById(R.id.btnTemp);
        bl = (Button) rootView.findViewById(R.id.btnLight);
        bh = (Button) rootView.findViewById(R.id.btnHum);
        bs = (Button) rootView.findViewById(R.id.btnSoil);
        statusBar= (TextView) rootView.findViewById(R.id.status);

        bt.setOnClickListener(this);
        bl.setOnClickListener(this);
        bh.setOnClickListener(this);
        bs.setOnClickListener(this);

        //status bar







        return rootView;
    }


    private void onSelectedFragment(View view){
        Fragment newFragment;
        if(view == view.findViewById(R.id.btnTemp)){

                newFragment = new TempFragment();
            if(flag.getTempFlag() == (float) 1){
                statusBar.setText(getResources().getString(R.string.temp_high));
            }else if(flag.getTempFlag() == (float) 2){
                statusBar.setText(getResources().getString(R.string.temp_low));

            }

            }else if(view == view.findViewById(R.id.btnLight)){
                newFragment = new LightFragment();

            }else if(view == view.findViewById(R.id.btnHum)){

                newFragment = new HumFragment();

            }else if (view == view.findViewById(R.id.btnSoil)){
                newFragment = new SoilFragment();

            }else{
                newFragment = null;

            }
          replaceFragment(newFragment);



    }



    private void replaceFragment(Fragment newFragment){
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        if(!newFragment.isAdded()){
            try{
//                getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_placeholder,newFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }catch (Exception e){

            }
        }else {
            transaction.show(newFragment);
        }
    }


    @Override
    public void onClick(View view) {
        onSelectedFragment(view);
    }
}
