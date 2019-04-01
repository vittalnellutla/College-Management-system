package com.example.vittal.sfcms;

/**
 * Created by Vittal on 01-01-2018.
 */

import android.app.Activity;
import android.content.DialogInterface;
import android.net.ConnectivityManager;


import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.vittal.sfcms.R;
import com.example.vittal.sfcms.activities.AdminLoginActivity;
import com.example.vittal.sfcms.activities.FacultyLoginActivity;
import com.example.vittal.sfcms.activities.StudentLoginActivity;


public class WelcomeActivity extends Activity {

    Button admin,faculty,student;

    /*  public static int pos;
    Toast toast;
    ActionBar bar;
    Context context; */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        isOnline();

        admin= (Button) findViewById(R.id.admin);               // casting to Android.widget.Button
        faculty= (Button) findViewById(R.id.faculty);
        student= (Button) findViewById(R.id.student);

        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(WelcomeActivity.this,AdminLoginActivity.class);
                startActivity(i);
            }
        });

        faculty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(WelcomeActivity.this,FacultyLoginActivity.class);
                startActivity(i);
            }
        });


        student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(WelcomeActivity.this,StudentLoginActivity.class);
                startActivity(i);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        /* Handle action bar item clicks here.
           The action bar will automatically handle clicks on the MainActivity/Up button until we specify a parent activity in AndroidManifest.xml */
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.about) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        WelcomeActivity.this.finish();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }


    public boolean isOnline() {
        ConnectivityManager conMgr = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = conMgr.getActiveNetworkInfo();

        if(netInfo == null || !netInfo.isConnected() || !netInfo.isAvailable()){
            new AlertDialog.Builder(this)
                    .setMessage("No Internet Connection")
                    .setCancelable(false)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            WelcomeActivity.this.finish();
                        }
                    })

                    .show();
        }
        return true;
    }
}

