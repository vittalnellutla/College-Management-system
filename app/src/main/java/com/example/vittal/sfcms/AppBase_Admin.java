package com.example.vittal.sfcms;

/**
 * Created by Vittal on 26-02-2018.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.GridView;

import com.example.vittal.sfcms.*;
import com.example.vittal.sfcms.About;

import java.util.ArrayList;


public class AppBase_Admin extends AppCompatActivity {

    ArrayList<String> basicFields;
    GridAdapter_Admin adapter;
    public static ArrayList<String> divisions ;
    public static ArrayList<String> noticetype ;
    GridView gridView;
    public static DatabaseHandler handler;
    public static Activity activity;

/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }
*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_layout);
        basicFields = new ArrayList<>();
        handler = new DatabaseHandler(this);
        activity = this;

        getSupportActionBar().show();
        divisions = new ArrayList();
        divisions.add("CSE A");
        divisions.add("CSE B");
        divisions.add("CSE C");
        noticetype = new ArrayList();
        noticetype.add("Exams");
        noticetype.add("Fees");
        noticetype.add("TimeTable");
        noticetype.add("Events");
        noticetype.add("Workshops/Seminars");
        noticetype.add("Sports");
        noticetype.add("Circular");
        gridView = findViewById(R.id.grid);
        basicFields.add("ATTENDANCE");
        basicFields.add("NOTICE");
        basicFields.add("NOTES");
        basicFields.add("PROFILE");
        adapter = new GridAdapter_Admin(this,basicFields);
        gridView.setAdapter(adapter);
    }

    public void loadSettings(MenuItem item) {
        Intent launchIntent = new Intent(this, SettingsActivity.class);
        startActivity(launchIntent);
    }

    public void loadAbout(MenuItem item) {
        Intent launchIntent = new Intent(this,About.class);
        startActivity(launchIntent);
    }
}


