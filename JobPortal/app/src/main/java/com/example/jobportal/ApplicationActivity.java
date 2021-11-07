package com.example.jobportal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jobportal.model.JobSeeker;
import com.example.jobportal.model.SeekerApply;
import com.example.jobportal.util.DBHealper;

public class ApplicationActivity extends AppCompatActivity {
    String useremail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application);

        TextView fname=findViewById(R.id.faname);
        TextView lname=findViewById(R.id.laname);
        TextView nid =findViewById(R.id.nids);
        TextView email =findViewById(R.id.emails);

        Bundle bundle = getIntent().getExtras();
        useremail = bundle.getString("useremail");
        Log.v("application Activ email", useremail);
        DBHealper db = new DBHealper(ApplicationActivity.this);
        JobSeeker p = db.getSeeker(useremail);
        if(bundle.getString("useremail")!= null){
            fname.setText(p.getFname());
            lname.setText(p.getLname());
            nid.setText(p.getNid());
            email.setText(p.getEmail());
            int pId=p.getId();
        }else{
            Toast.makeText(ApplicationActivity.this, "Data doesn't save", Toast.LENGTH_SHORT).show();
        }

        Button sumit = findViewById(R.id.btnsubmit);
        sumit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView fname=findViewById(R.id.faname);
                TextView lname=findViewById(R.id.laname);
                TextView nid =findViewById(R.id.nids);
                TextView email =findViewById(R.id.emails);
                EditText address = findViewById(R.id.homelocation);
                EditText projal = findViewById(R.id.propojal);


                SeekerApply ss = new SeekerApply();
                ss.setFname(fname.getText().toString());
                ss.setLname(lname.getText().toString());
                ss.setNid(nid.getText().toString());
                ss.setEmail(email.getText().toString());
                ss.setAddress(address.getText().toString());
                ss.setProjal(projal.getText().toString());

                DBHealper dbnn = new DBHealper(ApplicationActivity.this);
                Long l = dbnn.jobapply(ss);
                if (l>0){
                    Intent i = new Intent(ApplicationActivity.this, WelcomeActivity.class);
                    startActivity(i);

                    Toast.makeText(ApplicationActivity.this, "Application successful", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(ApplicationActivity.this, "Apply doesn't save", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}