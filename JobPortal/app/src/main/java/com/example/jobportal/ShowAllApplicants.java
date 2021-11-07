package com.example.jobportal;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ShowAllApplicants extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all_applicants);
        addData();
    }
    private TextView getTextView(int id, String title, int color, int typeface, int bgColor) {
        TextView tv = new TextView(this);
        tv.setId(id);
        tv.setText(title.toUpperCase());
        tv.setTextColor(color);
        tv.setPadding(40, 40, 40, 40);
        tv.setTypeface(Typeface.DEFAULT, typeface);
        tv.setBackgroundColor(bgColor);
        tv.setLayoutParams(getLayoutParams());
        tv.setOnClickListener(this);
        return tv;
    }
    @NonNull
    public TableRow.LayoutParams getLayoutParams() {
        TableRow.LayoutParams params = new TableRow.LayoutParams(
                TableRow.LayoutParams.MATCH_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT);
        params.setMargins(2, 0, 0, 2);
        return params;
    }
    @NonNull
    public TableLayout.LayoutParams getTblLayoutParams() {
        return new TableLayout.LayoutParams(
                TableRow.LayoutParams.MATCH_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT);
    }
    public void addData() {
        TableLayout tl = findViewById(R.id.tableShow);
        RequestQueue queue = Volley.newRequestQueue(ShowAllApplicants.this);
        String url ="http://192.168.0.109:8080/createJob/view";

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        List<JSONObject> items = new ArrayList<>();
                        for(int i = 0;  i < response.length(); i++){
                            try {
                               items.add(response.getJSONObject(i));
                                TableRow tr = new TableRow(ShowAllApplicants.this);
                                tr.setLayoutParams(getLayoutParams());
                                tr.addView(getTextView(i, response.getJSONObject(i).get("jobtitle").toString(), Color.WHITE, Typeface.NORMAL, ContextCompat.getColor(ShowAllApplicants.this, R.color.purple_200)));
                                tr.addView(getTextView(i, response.getJSONObject(i).get("joblocation").toString(), Color.WHITE, Typeface.NORMAL, ContextCompat.getColor(ShowAllApplicants.this, R.color.purple_500)));
                                tr.addView(getTextView(i, response.getJSONObject(i).get("salary").toString(), Color.WHITE, Typeface.NORMAL, ContextCompat.getColor(ShowAllApplicants.this, R.color.purple_500)));
                                tl.addView(tr, getTblLayoutParams());
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ShowAllApplicants.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(request);
    }
    @Override
    public void onClick(View view) {
        int id = view.getId();
        TextView tv = findViewById(id);
        if (null != tv) {
            Intent i = new Intent(ShowAllApplicants.this, ShowPage.class);
            i.putExtra("jobtitle", tv.getText());

            Toast.makeText(this, "Clicked on row :: " + tv.getText(), Toast.LENGTH_SHORT).show();
            startActivity(i);
        }
    }
}