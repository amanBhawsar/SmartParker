package com.example.smartparker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.smartparker.data.model.GetSlots;
import com.example.smartparker.data.model.PostLogin;
import com.example.smartparker.data.model.Slot;
import com.example.smartparker.data.model.indislot;
import com.example.smartparker.data.remote.APIService;
import com.example.smartparker.data.remote.ApiUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class adminslots extends AppCompatActivity {
    private APIService mAPIService;
    List<Slot> arr = admin.list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminslots);
        arr = admin.list;
        Button btn = findViewById(R.id.slot1);
        if(arr!=null) {
            for (Slot s : arr) {
                int i = s.getSlotid();
                int stat = s.getStatus();
                switch (i) {
                    case 1:
                        btn = findViewById(R.id.slot1);
                        break;
                    case 2:
                        btn = findViewById(R.id.slot2);
                        break;
                    case 3:
                        btn = findViewById(R.id.slot3);
                        break;
                    case 4:
                        btn = findViewById(R.id.slot4);
                        break;
                    case 5:
                        btn = findViewById(R.id.slot5);
                        break;
                    case 6:
                        btn = findViewById(R.id.slot6);
                        break;
                }
                if (stat == 0) {
                    btn.setText("A");
                } else if (stat == 1) {
                    btn.setText("O");
                } else {
                    btn.setText("P");
                }
            }
        }

        final Button b1 = findViewById(R.id.slot1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pre = b1.getText().toString();
                if(pre.equals("A")){
                    b1.setText("O");
                }else if(pre.equals("O")){
                    b1.setText("P");
                }else{
                    b1.setText("A");
                }
            }
        });
        final Button b2 = findViewById(R.id.slot2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pre = b2.getText().toString();
                if(pre.equals("A")){
                    b2.setText("O");
                }else if(pre.equals("O")){
                    b2.setText("P");
                }else{
                    b2.setText("A");
                }
            }
        });
        final Button b3 = findViewById(R.id.slot3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pre = b3.getText().toString();
                if(pre.equals("A")){
                    b3.setText("O");
                }else if(pre.equals("O")){
                    b3.setText("P");
                }else{
                    b3.setText("A");
                }
            }
        });
        final Button b4 = findViewById(R.id.slot4);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pre = b4.getText().toString();
                if(pre.equals("A")){
                    b4.setText("O");
                }else if(pre.equals("O")){
                    b4.setText("P");
                }else{
                    b4.setText("A");
                }
            }
        });
        final Button b5 = findViewById(R.id.slot5);
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pre = b5.getText().toString();
                if(pre.equals("A")){
                    b5.setText("O");
                }else if(pre.equals("O")){
                    b5.setText("P");
                }else{
                    b5.setText("A");
                }
            }
        });
        final Button b6 = findViewById(R.id.slot6);
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pre = b6.getText().toString();
                if(pre.equals("A")){
                    b6.setText("O");
                }else if(pre.equals("O")){
                    b6.setText("P");
                }else{
                    b6.setText("A");
                }
            }
        });

        mAPIService = ApiUtils.getAPIService();

        final Button sav = findViewById(R.id.savestate);
        sav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                updateSlot(1,2);
                Toast toast = Toast.makeText(getApplicationContext(), "updated", Toast.LENGTH_SHORT);
                toast.setMargin(50, 50);
                toast.show();
                Intent intent = new Intent(adminslots.this, com.example.smartparker.admin.class);
                startActivity(intent);

            }
        });
    }
    public void updateSlot(int id,int stat) {
        mAPIService.updateslot(id,stat).enqueue(new Callback<indislot>() {
            @Override
            public void onResponse(Call<indislot> call, Response<indislot> response) {

                if (response.isSuccessful()) {
////                    list= response.body();
                    showResponse(response.body().toString());
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(), call.request().url() +  ": failed: " + response.code(), Toast.LENGTH_SHORT);
                    toast.setMargin(50, 50);
                    toast.show();
                }
            }

            @Override
            public void onFailure(Call<indislot> call, Throwable t) {
                Toast toast = Toast.makeText(getApplicationContext(), "failed", Toast.LENGTH_SHORT);
                toast.setMargin(50, 50);
                toast.show();
            }
        });
    }

    public void showResponse(String response) {
        Toast toast = Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT);

        toast.setMargin(50, 50);
        toast.show();
    }
}
