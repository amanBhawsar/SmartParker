package com.example.smartparker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        TextView submitButton = (TextView) findViewById(R.id.register_new);
        final EditText username = (EditText)findViewById(R.id.username);
        final EditText pass = (EditText)findViewById(R.id.name);
        final EditText name = (EditText)findViewById(R.id.password);
        final EditText mobNo = (EditText)findViewById(R.id.mob_no);
        final EditText carNo = (EditText)findViewById(R.id.car_no);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Toast toast=Toast.makeText(getApplicationContext(),"BUTTON PRESSED", Toast.LENGTH_SHORT);
                    toast.setMargin(50,50);
                    toast.show();
                    JSONObject postData = new JSONObject();
                    try {
                        postData.put("username", username.getText().toString());
                        postData.put("password", pass.getText().toString());
                        postData.put("name", name.getText().toString());
                        postData.put("mobile", mobNo.getText().toString());
                        postData.put("car_no", carNo.getText().toString());

                        new SendDeviceDetails().execute("http://127.0.0.1:5000/register", postData.toString());
                        toast=Toast.makeText(getApplicationContext(),"Success", Toast.LENGTH_SHORT);
                        toast.setMargin(50,50);
                        toast.show();
                    } catch (JSONException e) {
                        e.printStackTrace();
                        toast=Toast.makeText(getApplicationContext(),"Failed", Toast.LENGTH_SHORT);
                        toast.setMargin(50,50);
                        toast.show();
                    }

                }
            }
        );
        setContentView(R.layout.activity_register);
    }
    private class SendDeviceDetails extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {

            String data = "";

            HttpURLConnection httpURLConnection = null;
            try {

                httpURLConnection = (HttpURLConnection) new URL(params[0]).openConnection();
                httpURLConnection.setRequestMethod("POST");

                httpURLConnection.setDoOutput(true);

                DataOutputStream wr = new DataOutputStream(httpURLConnection.getOutputStream());
                wr.writeBytes("PostData=" + params[1]);
                wr.flush();
                wr.close();

                InputStream in = httpURLConnection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(in);

                int inputStreamData = inputStreamReader.read();
                while (inputStreamData != -1) {
                    char current = (char) inputStreamData;
                    inputStreamData = inputStreamReader.read();
                    data += current;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
            }

            return data;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            Log.e("TAG", result); // this is expecting a response code to be sent from your server upon receiving the POST data
            Toast toast=Toast.makeText(getApplicationContext(),result, Toast.LENGTH_SHORT);
            toast.setMargin(50,50);
            toast.show();
        }
    }
}

