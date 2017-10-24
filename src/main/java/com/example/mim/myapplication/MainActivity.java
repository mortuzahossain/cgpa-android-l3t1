package com.example.mim.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.support.design.widget.Snackbar;

public class MainActivity extends AppCompatActivity {

    Button calculate;
    // FromString Resource file
    String[] result, resultValue, subjectName, subjectCredit;
    // Initilizing the textview and spinner
    TextView subjectName1, subjectName2, subjectName3, subjectName4, subjectName5, subjectName6, subjectName7;
    Spinner gainSubject1, gainSubject2, gainSubject3, gainSubject4, gainSubject5, gainSubject6, gainSubject7;
    // Initilizing the array adaptor to combine data into spinner
    ArrayAdapter<String> arrayAdapter;
    // Show Text
    TextView showValueView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        subjectName1 = (TextView) findViewById(R.id.sub1);
        subjectName2 = (TextView) findViewById(R.id.sub2);
        subjectName3 = (TextView) findViewById(R.id.sub3);
        subjectName4 = (TextView) findViewById(R.id.sub4);
        subjectName5 = (TextView) findViewById(R.id.sub5);
        subjectName6 = (TextView) findViewById(R.id.sub6);
        subjectName7 = (TextView) findViewById(R.id.sub7);

        gainSubject1 = (Spinner) findViewById(R.id.spinner1);
        gainSubject2 = (Spinner) findViewById(R.id.spinner2);
        gainSubject3 = (Spinner) findViewById(R.id.spinner3);
        gainSubject4 = (Spinner) findViewById(R.id.spinner4);
        gainSubject5 = (Spinner) findViewById(R.id.spinner5);
        gainSubject6 = (Spinner) findViewById(R.id.spinner6);
        gainSubject7 = (Spinner) findViewById(R.id.spinner7);


        calculate = (Button) findViewById(R.id.calculate);

        showValueView = (TextView) findViewById(R.id.showTextView);

        result = getResources().getStringArray(R.array.result);
        resultValue = getResources().getStringArray(R.array.result_value);
        subjectName = getResources().getStringArray(R.array.subject_name);
        subjectCredit = getResources().getStringArray(R.array.subject_credit);

        arrayAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, result);

        gainSubject1.setAdapter(arrayAdapter);
        gainSubject2.setAdapter(arrayAdapter);
        gainSubject3.setAdapter(arrayAdapter);
        gainSubject4.setAdapter(arrayAdapter);
        gainSubject5.setAdapter(arrayAdapter);
        gainSubject6.setAdapter(arrayAdapter);
        gainSubject7.setAdapter(arrayAdapter);

        subjectName1.setText(subjectName[0] + " : " + subjectCredit[0]);
        subjectName2.setText(subjectName[1] + " : " + subjectCredit[1]);
        subjectName3.setText(subjectName[2] + " : " + subjectCredit[2]);
        subjectName4.setText(subjectName[3] + " : " + subjectCredit[3]);
        subjectName5.setText(subjectName[4] + " : " + subjectCredit[4]);
        subjectName6.setText(subjectName[5] + " : " + subjectCredit[5]);
        subjectName7.setText(subjectName[6] + " : " + subjectCredit[6]);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.calculate:
                        int s1, s2, s3, s4, s5, s6, s7, s8, s9;
                        String v1, v2, v3, v4, v5, v6, v7, v8, v9;
                        float c1, c2, c3, c4, c5, c6, c7, c8, c9;
                        // Taking Spinner Input
                        s1 = gainSubject1.getSelectedItemPosition();
                        s2 = gainSubject2.getSelectedItemPosition();
                        s3 = gainSubject3.getSelectedItemPosition();
                        s4 = gainSubject4.getSelectedItemPosition();
                        s5 = gainSubject5.getSelectedItemPosition();
                        s6 = gainSubject6.getSelectedItemPosition();
                        s7 = gainSubject7.getSelectedItemPosition();
                        // Changing The Value With There Grade String
                        v1 = resultValue[s1];
                        v2 = resultValue[s2];
                        v3 = resultValue[s3];
                        v4 = resultValue[s4];
                        v5 = resultValue[s5];
                        v6 = resultValue[s6];
                        v7 = resultValue[s7];
                        // Converting Them Into Float
                        c1 = Float.parseFloat(v1);
                        c2 = Float.parseFloat(v2);
                        c3 = Float.parseFloat(v3);
                        c4 = Float.parseFloat(v4);
                        c5 = Float.parseFloat(v5);
                        c6 = Float.parseFloat(v6);
                        c7 = Float.parseFloat(v7);

                        // Calculating Part
                        float achievement, calculationValue, total;

                        achievement = ((c1 * Float.parseFloat(subjectCredit[0])) +
                                (c2 * Float.parseFloat(subjectCredit[1])) +
                                (c3 * Float.parseFloat(subjectCredit[2])) +
                                (c4 * Float.parseFloat(subjectCredit[3])) +
                                (c5 * Float.parseFloat(subjectCredit[4])) +
                                (c6 * Float.parseFloat(subjectCredit[5])) +
                                (c7 * Float.parseFloat(subjectCredit[6]))
                        );

                        total = (Float.parseFloat(subjectCredit[0]) +
                                Float.parseFloat(subjectCredit[1]) +
                                Float.parseFloat(subjectCredit[2]) +
                                Float.parseFloat(subjectCredit[3]) +
                                Float.parseFloat(subjectCredit[4]) +
                                Float.parseFloat(subjectCredit[5]) +
                                Float.parseFloat(subjectCredit[6])
                        );

                        calculationValue = achievement / total;

                        Snackbar.make(v, "Calculation :  " + String.valueOf(achievement) + "  /  " + String.valueOf(total) + "  =  " + String.valueOf(calculationValue),
                                Snackbar.LENGTH_LONG).setAction("Action", null).show();
                        showValueView.setText("Your CGPA : " + String.valueOf(calculationValue));

                        break;
                }
            }
        });

    }


}
