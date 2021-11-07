package com.example.jobportal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jobportal.model.JobSeeker;
import com.example.jobportal.util.DBHealper;

public class RegistrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        Button register = findViewById(R.id.btnRegistration);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText fname = findViewById(R.id.fname);
                EditText lname = findViewById(R.id.lname);
                EditText address =findViewById(R.id.address);
                EditText email = findViewById(R.id.email);
                EditText password = findViewById(R.id.password);
                EditText nid = findViewById(R.id.nid);

                JobSeeker job = new JobSeeker();
                job.setFname(fname.getText().toString());
                job.setLname(lname.getText().toString());
                job.setPermanentaddress(address.getText().toString());
                job.setEmail(email.getText().toString());
                job.setPassword(password.getText().toString());
                job.setNid(nid.getText().toString());

                DBHealper dbHelper = new DBHealper(RegistrationActivity.this);
                Long l = dbHelper.addSeeeker(job);
                if(l > 0){
                    Toast.makeText(RegistrationActivity.this, "Registration saved successfully!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(RegistrationActivity.this, "Registration does not saved!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}