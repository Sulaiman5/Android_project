package com.example.jobportal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jobportal.model.JobSeeker;
import com.example.jobportal.util.DBHealper;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button login = findViewById(R.id.btnnLogin);
        Button regis = findViewById(R.id.btnregistrat);
        regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, RegistrationActivity.class);
                startActivity(i);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText email = findViewById(R.id.inputemail);
                EditText password = findViewById(R.id.inputpssword);
                JobSeeker j = new JobSeeker();
                j.setEmail(email.getText().toString());
                j.setPassword(password.getText().toString());

                DBHealper db = new DBHealper(LoginActivity.this);
                JobSeeker job = db.getSeeker(j);

//                Log.v("user email", j.getEmail());
//                Log.v("jobseeker email", job.getEmail());

                if(j.getEmail().equals(job.getEmail())){
                    Intent i = new Intent(LoginActivity.this, ApplicationActivity.class);
                    i.putExtra("useremail", j.getEmail());
                    Log.v("jobseeker email", j.getEmail());
                    startActivity(i);
                }else{
                    Toast.makeText(LoginActivity.this, "Username/Password doesnt match!", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}