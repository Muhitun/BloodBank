package com.example.sohan.bloodbank;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;

/**
 * Created by Sohan on 11/19/2015.
 */
public class MyOnItemSelectedListener implements OnItemSelectedListener {
String s ;

    public void onItemSelected(AdapterView parent, View view, int pos, long id) {
        s = parent.getItemAtPosition(pos).toString();
        Toast.makeText(parent.getContext(), s , Toast.LENGTH_SHORT).show();
    }

    public void onNothingSelected(AdapterView parent) {

    }
}
