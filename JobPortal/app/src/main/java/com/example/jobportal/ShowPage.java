package com.example.jobportal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ShowPage extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_page);
        Button apply = findViewById(R.id.btnApply);


        Bundle b = getIntent().getExtras();
        Intent intent = getIntent();
        String jobTitle = intent.getStringExtra("jobtitle");

        TextView jobtitle = findViewById(R.id.tjobtitle);
        TextView respons = findViewById(R.id.tresponsibilities);
        TextView expreance = findViewById(R.id.texperience);
        TextView age = findViewById(R.id.tage);
        TextView salary = findViewById(R.id.tsalary);
        TextView joblocation = findViewById(R.id.tlocation);
        TextView educational = findViewById(R.id.teducational);

        String url = "http://192.168.0.109:8080/createJob/getJob/";
        //Senior Programmer (Java) Software Development Department
        RequestQueue queue = Volley.newRequestQueue(ShowPage.this);
        String[] words = jobTitle.split(" ");
        for(String s: words){
            url += s + ",";
        }

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, response -> {
            try {
                jobtitle.append(response.getString("jobtitle"));
                respons.append(response.getString("responsibilities"));
                expreance.append(response.getString("experience"));
                age.append(response.getString("age"));
                salary.append(response.getString("salary"));
                joblocation.append(response.getString("joblocation"));
                educational.append(response.getString("educational"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }, error -> {
            System.out.println(error);
        });

        queue.add(request);

        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ShowPage.this, LoginActivity.class);
                startActivity(i);
            }
        });
    }

}
