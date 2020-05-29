package com.example.smartparker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class paymentdata extends AppCompatActivity {
    String[] mobileArray = {"Sunil Sharma  35.0","Ram Saxena    30.0","Rohit Kumar   50.0","Apurv Bansal  50.0"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paymentdata);

        ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.activity_listview, mobileArray);

        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);
    }
}
