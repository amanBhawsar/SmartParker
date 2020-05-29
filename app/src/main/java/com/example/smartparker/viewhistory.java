package com.example.smartparker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class viewhistory extends AppCompatActivity {

    String[] mobileArray = {"05:30 22/02/19","07:21 02/11/18 ","16:21 17/07/19",
            "02:54 11/04/18"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewhistory);

        ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.activity_listview, mobileArray);

        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);
    }
}