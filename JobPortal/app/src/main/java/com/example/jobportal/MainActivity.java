package com.example.jobportal;

import android.content.Intent;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.jobportal.model.JobSeeker;
import com.example.jobportal.util.DBHealper;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button login = findViewById(R.id.btnLogin);
        Button regis = findViewById(R.id.btnRegister);
        Button aall = findViewById(R.id.btnalljob);

        aall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ShowAllApplicants.class);
                startActivity(i);
            }
        });
        regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, RegistrationActivity.class);
                startActivity(i);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText email = findViewById(R.id.inpemail);
                EditText password = findViewById(R.id.inppssword);
                JobSeeker j = new JobSeeker();
                j.setEmail(email.getText().toString());
                j.setPassword(password.getText().toString());

                DBHealper db = new DBHealper(MainActivity.this);
                JobSeeker job = db.getSeeker(j);

//                Log.v("user email", j.getEmail());
//                Log.v("jobseeker email", job.getEmail());

                if(j.getEmail().equals(job.getEmail())){
                    Intent i = new Intent(MainActivity.this, ApplicationActivity.class);
                    i.putExtra("useremail", j.getEmail());
                    Log.v("jobseeker email", j.getEmail());
                    startActivity(i);
                }else{
                    Toast.makeText(MainActivity.this, "Username/Password doesnt match!", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}