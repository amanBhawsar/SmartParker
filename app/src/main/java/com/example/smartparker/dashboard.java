package com.example.smartparker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.smartparker.data.model.PostLogin;

import org.json.JSONException;
import org.json.JSONObject;

public class dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        PostLogin ud = login.userData;
        TextView editWel = findViewById(R.id.welcome);
        editWel.setText("Welcome "+ud.getName());

        Button btn = findViewById(R.id.bookslot);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast=Toast.makeText(getApplicationContext(),"BUTTON PRESSED", Toast.LENGTH_SHORT);
                toast.setMargin(50,50);
                toast.show();
                Intent intent = new Intent(dashboard.this, com.example.smartparker.bookslot.class);
                startActivity(intent);
            }
        });

        btn = findViewById(R.id.reserveslot);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast=Toast.makeText(getApplicationContext(),"BUTTON PRESSED", Toast.LENGTH_SHORT);
                toast.setMargin(50,50);
                toast.show();
                Intent intent = new Intent(dashboard.this, com.example.smartparker.reserveslot.class);
                startActivity(intent);
            }
        });
        btn = findViewById(R.id.viewhistory);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast=Toast.makeText(getApplicationContext(),"BUTTON PRESSED", Toast.LENGTH_SHORT);
                toast.setMargin(50,50);
                toast.show();
                Intent intent = new Intent(dashboard.this, com.example.smartparker.viewhistory.class);
                startActivity(intent);
            }
        });
        btn = findViewById(R.id.viewprofile);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast=Toast.makeText(getApplicationContext(),"BUTTON PRESSED", Toast.LENGTH_SHORT);
                toast.setMargin(50,50);
                toast.show();
                Intent intent = new Intent(dashboard.this, com.example.smartparker.viewprofile.class);
                startActivity(intent);
            }
        });



    }
}
