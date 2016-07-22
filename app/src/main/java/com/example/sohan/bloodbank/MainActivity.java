package com.example.sohan.bloodbank;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private Spinner spinner1, spinner2;
    private String city, bloodGroup, total;
    ArrayList<String> aList;
    ArrayAdapter<String> adapter;
    ListView lview;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        aList = new ArrayList<String>();
        lview = (ListView)findViewById(R.id.listView);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, aList);
        lview.setAdapter(adapter);
    }

    public void press(View v){
        addListenerOnSpinnerItemSelection();
    }


    public void addListenerOnSpinnerItemSelection() {
        city = spinner1.getSelectedItem().toString();
        bloodGroup = spinner2.getSelectedItem().toString();
//        total = city +" " +bloodGroup;
//        Toast.makeText(getApplicationContext(), total, Toast.LENGTH_SHORT).show();
 //       User user = new User(city, bloodGroup);
 //       registerUser(user);
        adapter.add(spinner1.getSelectedItem().toString());
    }

private void registerUser(User user){
    ServerRequests serverRequests = new ServerRequests(this);
    serverRequests.sendAndReceiveData(user, new GetUserCallback() {
        @Override
        public void done(User returnedUser) {
            Toast.makeText(getApplicationContext(), "Retrieval successful", Toast.LENGTH_LONG).show();
            //startActivity(new Intent(SignUpActivity.this, MainActivity.class));
        }
    });
}



}
