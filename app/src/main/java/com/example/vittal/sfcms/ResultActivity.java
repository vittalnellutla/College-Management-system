package com.example.vittal.sfcms;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vittal.sfcms.R;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ResultActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        EditText total_marks, percentage;

            total_marks = findViewById(R.id.total_marks);
            percentage = findViewById(R.id.percentage);
            TextView t1 = findViewById(R.id.total);
            TextView t2 = findViewById(R.id.percent);


            try {

                Bundle b = getIntent().getExtras();
                float marks = b.getFloat("total");
                int flag = b.getInt("flag");
                float perc = b.getFloat("percent");


                if (flag == 0) {
                    total_marks.setText("Your Total is ");
                    percentage.setVisibility(View.INVISIBLE);
                    t1.setVisibility(View.INVISIBLE);
                }

                BigDecimal bd = new BigDecimal(marks).setScale(2, RoundingMode.HALF_EVEN);
                marks = bd.floatValue();


                BigDecimal bd1 = new BigDecimal(perc).setScale(2, RoundingMode.HALF_EVEN);
                perc = bd1.floatValue();
                total_marks.setText(String.valueOf(total_marks));
                percentage.setText(String.valueOf(percentage + "%"));
            }

            catch (Exception e)
            {
                Toast.makeText(getBaseContext(),"Exception Occured",Toast.LENGTH_LONG).show();
            }
        }

    }