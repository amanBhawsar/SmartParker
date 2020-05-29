package com.example.smartparker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.smartparker.data.model.PostLogin;

import org.json.JSONException;
import org.json.JSONObject;

public class viewprofile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewprofile);
        PostLogin ud = login.userData;
        CharSequence name=ud.getName(),username=ud.getUsername(),mob=ud.getMobile(),carno=ud.getCarNo();

        TextView editText = findViewById(R.id.bcd);
        editText.append(username);
        editText = findViewById(R.id.cde);
        editText.append("    "+name);
        editText = findViewById(R.id.def);
        editText.append("  "+mob);
        editText = findViewById(R.id.efg);
        editText.append("  "+carno);
        Button btn = findViewById(R.id.logout);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(viewprofile.this, com.example.smartparker.MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // To clean up all activities
                startActivity(intent);
                finish();
            }
        });
    }
}
