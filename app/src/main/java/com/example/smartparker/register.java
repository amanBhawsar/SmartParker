package com.example.smartparker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.smartparker.data.model.Post;
import com.example.smartparker.data.remote.APIService;
import com.example.smartparker.data.remote.ApiUtils;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class register extends AppCompatActivity {
    private APIService mAPIService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        TextView submitButton = findViewById(R.id.register_new);
        final EditText username = findViewById(R.id.username);
        final EditText name = findViewById(R.id.name);
        final EditText pass = findViewById(R.id.password);
        final EditText mobNo = findViewById(R.id.mob_no);
        final EditText carNo = findViewById(R.id.car_no);
        mAPIService = ApiUtils.getAPIService();
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast=Toast.makeText(getApplicationContext(),"BUTTON PRESSED", Toast.LENGTH_SHORT);
                toast.setMargin(50,50);
                toast.show();
                String Username = username.getText().toString();
                String Name = name.getText().toString().trim();
                String Pass = pass.getText().toString().trim();
                String MobNo = mobNo.getText().toString().trim();
                String CarNo = carNo.getText().toString().trim();
                if(!TextUtils.isEmpty(Username) && !TextUtils.isEmpty(Name) && !TextUtils.isEmpty(Pass) && !TextUtils.isEmpty(MobNo) && !TextUtils.isEmpty(CarNo)) {
                    sendPost(Username, Name,Pass,MobNo,CarNo);
                    Intent intent = new Intent(register.this, com.example.smartparker.login.class);
                    startActivity(intent);
                }else {
                    toast = Toast.makeText(getApplicationContext(), "Fill all details", Toast.LENGTH_LONG);
                    toast.setMargin(50, 50);
                    toast.show();
                }
                }
            }
        );
    }
    public void sendPost(String Username, String Name,String Pass,String MobNo,String CarNo) {
        mAPIService.savePost(Username, Name,Pass,MobNo,CarNo).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {

                if(response.isSuccessful()) {
                    showResponse(response.body().toString());
//                    Log.d(TAG, "post submitted to API." + response.body().toString());
                }else{
                    Toast toast=Toast.makeText(getApplicationContext(),"Username registered" +
                            "", Toast.LENGTH_SHORT);
                    toast.setMargin(50,50);
                    toast.show();
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
//                Log.e(TAG, "Unable to submit post to API.");
                Toast toast=Toast.makeText(getApplicationContext(),"Failed", Toast.LENGTH_SHORT);
                toast.setMargin(50,50);
                toast.show();
            }
        });
    }

    public void showResponse(String response) {
//        if(mResponseTv.getVisibility() == View.GONE) {
//            mResponseTv.setVisibility(View.VISIBLE);
//        }
//        mResponseTv.setText(response);
        Toast toast=Toast.makeText(getApplicationContext(),response, Toast.LENGTH_LONG);
        toast.setMargin(50,50);
        toast.show();
    }
}

