package com.example.jobportal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        TextView nn1 = findViewById(R.id.textView);
        TextView nn2 = findViewById(R.id.textView1);
        TextView nn3 = findViewById(R.id.textView2);
        TextView nn4 = findViewById(R.id.textView3);
    }
}