package com.example.vittal.sfcms;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;


public class DatabaseHandler {
    SQLiteDatabase database;
    Activity activity;

    public DatabaseHandler(Activity activity) {
        this.activity = activity;
        database = activity.openOrCreateDatabase("ASSIST", activity.MODE_PRIVATE, null);
        createTable();
    }

    public void createTable()
    {

        try {
            String qu = "CREATE TABLE IF NOT EXISTS STUDENT(name varchar(100)," +
                    "cl varchar(100), " +
                    "regno varchar(100) primary key, contact integer(10),roll varchar(10));";
            database.execSQL(qu);
        }catch (Exception e)
        {
            Toast.makeText(activity,"Error occurred for create table",Toast.LENGTH_LONG).show();
        }

/*
        try {
            String qu = "CREATE TABLE IF NOT EXISTS STUDENT(cl varchar(100), " +
                    "regno varchar(100), contact integer(10),roll varchar(10) primary key);";
            database.execSQL(qu);
        }catch (Exception e)
        {
            Toast.makeText(activity,"Error occurred for create table",Toast.LENGTH_LONG).show();
        }

*/
        try {
            String qu = "CREATE TABLE IF NOT EXISTS ATTENDANCE(datex date," +
                    "hour int, " +
                    "register varchar(100) ,isPresent boolean);";
            database.execSQL(qu);
        }catch (Exception e)
        {
            Toast.makeText(activity,"Error occurred for create table",Toast.LENGTH_LONG).show();
        }


        try {
            String qu = "CREATE TABLE IF NOT EXISTS NOTES(title varchar(100) not null," +
                    "body varchar(10000), cls varchar(10), sub varchar(100) ,datex TIMESTAMP default CURRENT_TIMESTAMP);";
            database.execSQL(qu);
        }catch (Exception e)
        {
            Toast.makeText(activity,"Error occurred for create table",Toast.LENGTH_LONG).show();
        }


        try {
            String qu = "CREATE TABLE IF NOT EXISTS NOTICE(title varchar(100) not null," +
                    "body varchar(10000), cls varchar(10), type varchar(100) , datex TIMESTAMP default CURRENT_TIMESTAMP);";
            database.execSQL(qu);
        }catch (Exception e)
        {
            Toast.makeText(activity,"Error occurred for create table",Toast.LENGTH_LONG).show();
        }

/*
        try {
            String qu = "CREATE TABLE IF NOT EXISTS NOTICE(title varchar(100) not null," +
                    "body varchar(10000), datex TIMESTAMP default CURRENT_TIMESTAMP);";
            database.execSQL(qu);
        }catch (Exception e)
        {
            Toast.makeText(activity,"Error occurred for create table",Toast.LENGTH_LONG).show();
        }
 */

/*
        try {
            String qu = "CREATE TABLE IF NOT EXISTS MARKS(roll varchar(10) primary key, " +
                    "course1 integer(10),course2 integer(10),course3 integer(10),course4 integer(10)" +
                    "total float(5),percentage float(5));";
            database.execSQL(qu);
        }catch (Exception e)
        {
            Toast.makeText(activity,"Error occurred for create table",Toast.LENGTH_LONG).show();
        }
*/

        try {
            String qu = "CREATE TABLE IF NOT EXISTS SCHEDULE(cl varchar(100),subject varchar(100)," +
                    "timex time, day_week varchar(100));";
            database.execSQL(qu);
        }catch (Exception e)
        {
            Toast.makeText(activity,"Error occurred for create table",Toast.LENGTH_LONG).show();
        }

    }

    public boolean execAction(String qu)
    {
        Log.i("DatabaseHandler", qu);
        try {
            database.execSQL(qu);
        }
        catch (Exception e)
        {
            Log.e("DatabaseHandler", qu);
            Toast.makeText(activity,"Error occurred @ execAction",Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }

    public Cursor execQuery(String qu)
    {
        try {
            return database.rawQuery(qu,null);
        }catch (Exception e)
        {
            Log.e("DatabaseHandler", qu);
            Toast.makeText(activity,"Error occurred @ execQuery",Toast.LENGTH_LONG).show();
        }
        return null;
    }
}



