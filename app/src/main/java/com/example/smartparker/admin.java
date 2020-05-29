package com.example.smartparker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.smartparker.data.model.GetSlots;
import com.example.smartparker.data.model.Slot;
import com.example.smartparker.data.remote.APIService;
import com.example.smartparker.data.remote.ApiUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class admin extends AppCompatActivity {
    private APIService mAPIService;
    public static List<Slot> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        mAPIService = ApiUtils.getAPIService();
        getData();
        Button btn = findViewById(R.id.manageslots);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(admin.this, com.example.smartparker.adminslots.class);
                startActivity(intent);
            }
        });
        btn = findViewById(R.id.paymentinfo);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(admin.this, com.example.smartparker.paymentdata.class);
                startActivity(intent);
            }
        });
        btn = findViewById(R.id.logoff);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(admin.this, com.example.smartparker.MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // To clean up all activities
                startActivity(intent);
                finish();
            }
        });
    }
    public void getData() {
        mAPIService.getSlots().enqueue(new Callback<GetSlots>() {
            @Override
            public void onResponse(Call<GetSlots> call, Response<GetSlots> response) {

                if (response.isSuccessful()) {
                    list= response.body().getSlots();
                    showResponse(response.body().toString());
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(), call.request().url() +  ": failed: " + response.code(), Toast.LENGTH_SHORT);
                    toast.setMargin(50, 50);
                    toast.show();
                }
            }

            @Override
            public void onFailure(Call<GetSlots> call, Throwable t) {
                Toast toast = Toast.makeText(getApplicationContext(), "failed", Toast.LENGTH_SHORT);
                toast.setMargin(50, 50);
                toast.show();
            }
        });
    }

    public void showResponse(String response) {
//        Toast toast = Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT);
//        toast.setMargin(50, 50);
//        toast.show();
    }
}
