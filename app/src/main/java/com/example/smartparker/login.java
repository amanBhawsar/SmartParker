package com.example.smartparker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.smartparker.data.model.Loginn;
import com.example.smartparker.data.model.Post;
import com.example.smartparker.data.model.PostLogin;
import com.example.smartparker.data.remote.APIService;
import com.example.smartparker.data.remote.APIServiceLogin;
import com.example.smartparker.data.remote.ApiUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class login extends AppCompatActivity {
    private APIService mAPIService;
    static Boolean flag=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        TextView login = findViewById(R.id.login);
        final EditText username = findViewById(R.id.usernamelogin);
        final EditText pass = findViewById(R.id.passwordlogin);
        mAPIService = ApiUtils.getAPIService();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Username = username.getText().toString().trim();
                String Pass = pass.getText().toString().trim();
                if(!TextUtils.isEmpty(Username) && !TextUtils.isEmpty(Pass)) {
                    sendPost(Username,Pass);
//                    Toast toast=Toast.makeText(getApplicationContext(),"BUTTON PRESSED", Toast.LENGTH_SHORT);
//                    toast.setMargin(50,50);
//                    toast.show();
                    if(flag) {
                        Intent intent = new Intent(login.this, com.example.smartparker.dashboard.class);
                        startActivity(intent);
                    }
                }else{
                    Toast toast=Toast.makeText(getApplicationContext(),"Fill all details", Toast.LENGTH_LONG);
                    toast.setMargin(50,50);
                    toast.show();
                }
            }
        }
        );
    }
    public void sendPost(String username, String password) {
        mAPIService.loginPost(username,password).enqueue(new Callback<PostLogin>() {
            @Override
            public void onResponse(Call<PostLogin> call, Response<PostLogin> response) {

                if(response.isSuccessful()) {
                    showResponse(response.body().toString());
//                    Log.d(TAG, "post submitted to API." + response.body().toString());

                }else{
                    flag=false;
                    Toast toast=Toast.makeText(getApplicationContext(), call.request().url() + ": failed: " + response.code(), Toast.LENGTH_SHORT);
                    toast.setMargin(50,50);
                    toast.show();
                }
            }

            @Override
            public void onFailure(Call<PostLogin> call, Throwable t) {
//                Log.e(TAG, "Unable to submit post to API.");
                flag=false;
                Toast toast=Toast.makeText(getApplicationContext(),"failed", Toast.LENGTH_SHORT);
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
        Toast toast=Toast.makeText(getApplicationContext(),"aman"+response, Toast.LENGTH_SHORT);
        toast.setMargin(50,50);
        toast.show();
    }
}

