package com.example.vittal.sfcms;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.vittal.sfcms.AppBase_Admin;
import com.example.vittal.sfcms.R;

/**
 * Created by Vittal on 28-02-2018.
 */


public class NoticeCreateActivity extends AppCompatActivity {
    EditText title,body;
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_notice);

        Button btn = findViewById(R.id.noticeSaveButton);
        assert btn != null;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });

        spinner = findViewById(R.id.pinSpinner);
        ArrayAdapter<String> adapterSpinner = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, AppBase_Admin.noticetype);
        assert spinner != null;
        spinner.setAdapter(adapterSpinner);
    }

    private void saveData() {
        title = findViewById(R.id.noticeTitle);
        body = findViewById(R.id.noticeBody);
        EditText type = findViewById(R.id.clsSelector);


        String qu = " INSERT INTO NOTICE(title,body,cls,type) VALUES('" + title.getText().toString() + "','" + body.getText().toString() +"'," +
                "'" + spinner.getSelectedItem().toString() + "','" + type.getText().toString().toUpperCase() + "')";

        /*
        String qu = " INSERT INTO NOTICE(title,body,spinner) VALUES('" + title.getText().toString() + "','" + body.getText().toString() +"'," +
                "'" + spinner.getSelectedItem().toString()+ "')";

        String qu = " INSERT INTO NOTICE(title,body,type) VALUES('" + title.getText().toString() + "','" + body.getText().toString() +"'," +
                "'" + type.getSelectedItem().toString()  + "')";
       */

        if(AppBase_Admin.handler.execAction(qu))
        {
            Toast.makeText(getBaseContext(),"Notice Saved",Toast.LENGTH_LONG).show();
            this.finish();
        }
    }

}


