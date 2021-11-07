package com.example.jobportal.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;
import com.example.jobportal.model.JobSeeker;
import com.example.jobportal.model.SeekerApply;

public class DBHealper extends SQLiteOpenHelper {

    private static final String DBNAME = "JOBPORTAL";
    private static final int VERSION = 1;
    public DBHealper(@Nullable Context context) {
        super(context, DBNAME, null, VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "Create table jobseeker(id INTEGER PRIMARY KEY, fname TEXT, lname TEXT, permanentaddress TEXT, email TEXT, password TEXT, nid TEXT)";
        db.execSQL(sql);
        String sqls = "Create table seekerApply(id INTEGER PRIMARY KEY, fname TEXT, lname TEXT, email TEXT, nid TEXT, address TEXT, projal TEXT, file TEXT)";
        db.execSQL(sqls);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }

    public Long addSeeeker(JobSeeker j) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("fname", j.getFname());
        values.put("lname", j.getLname());
        values.put("permanentaddress", j.getPermanentaddress());
        values.put("email", j.getEmail());
        values.put("password", j.getPassword());
        values.put("nid", j.getNid());
        Long l = db.insert("jobseeker", null, values);
        db.close();
        return l;
    }

    public JobSeeker getSeeker(JobSeeker j) {
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "select * from jobseeker where email = '"+j.getEmail()+"' ";
        Cursor c = db.rawQuery(sql, null);
        JobSeeker job = new JobSeeker();
        if(c.moveToFirst()){
            job.setId(Integer.parseInt(c.getString(0)));
            job.setEmail(c.getString(4));
            job.setPassword(c.getString(5));
        }
        return job;
    }

    public JobSeeker getSeeker(String emails) {
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "select * from jobseeker where email = '"+emails.toString() +"'";
        Cursor c = db.rawQuery(sql, null);
        JobSeeker user = new JobSeeker();
        if(c.moveToFirst()){
            user.setId(Integer.parseInt(c.getString(0)));
            user.setFname(c.getString(1));
            user.setLname(c.getString(2));
            user.setEmail(c.getString(4));
            Log.v("DBhelper email", c.getString(4));
            user.setPassword(c.getString(5));
            user.setNid(c.getString(6));
        }
        return user;
    }

    public Long jobapply(SeekerApply s) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("fname", s.getFname());
        values.put("lname", s.getLname());
        values.put("email", s.getEmail());
        values.put("nid", s.getNid());
        values.put("address", s.getAddress());
        values.put("projal", s.getProjal());
        values.put("file", s.getFile());

        Long ls = db.insert("seekerApply", null, values);
        db.close();
        return ls;
    }
}
