package com.example.vittal.sfcms;

/**
 * Created by VITTAL on 04-03-2018.
 */



import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.vittal.sfcms.AppBase_Student;
import com.example.vittal.sfcms.R;
import com.example.vittal.sfcms.activities.StudentRegisterActivity;

public class DetailsEntryActivity extends AppCompatActivity {


    Activity activity = this;
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_entry);

        spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, AppBase_Student.divisions);
        spinner.setAdapter(adapter);

        Button btn = findViewById(R.id.buttonSAVE);
        assert btn != null;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveToDatabase(v);
               // Intent intentSave = new Intent(getApplicationContext(), AppBase_Student.class);
               // startActivity(intentSave);
            }
        });
    }


    public void saveToDatabase(View view) {
        EditText name = findViewById(R.id.edit_name);
        EditText roll = findViewById(R.id.roll);
        EditText register = findViewById(R.id.register);
        EditText contact = findViewById(R.id.contact);
        String classSelected = spinner.getSelectedItem().toString();

        if(name.getText().length()<2||roll.getText().length()==0||register.getText().length()<2||
                contact.getText().length()<2||classSelected.length()<2)
        {
            AlertDialog.Builder alert = new AlertDialog.Builder(activity);
            alert.setTitle("Invalid");
            alert.setMessage("Insufficient Data");
            alert.setPositiveButton("OK", null);
            alert.show();
            return;
        }

        String qu = "INSERT INTO STUDENT VALUES('" +name.getText().toString()+ "'," +
                "'" + classSelected +"',"+
                "'" + register.getText().toString().toUpperCase() +"',"+
                "'" + contact.getText().toString() +"',"+
                "" + Integer.parseInt(roll.getText().toString()) +");";
        Log.d("Student Reg" , qu);
        AppBase_Student.handler.execAction(qu);
        qu = "SELECT * FROM STUDENT WHERE regno = '" + register.getText().toString() +  "';";
        Log.d("Student Reg" , qu);
        if(AppBase_Student.handler.execQuery(qu)!=null)
        {
            Toast.makeText(getBaseContext(),"Student Added", Toast.LENGTH_LONG).show();
            this.finish();
        }
    }
}

