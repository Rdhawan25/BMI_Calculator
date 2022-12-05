package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.app.Activity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText e1 = (EditText) findViewById(R.id.height);
        final EditText e2 = (EditText) findViewById(R.id.weight);
        final TextView result = (TextView) findViewById(R.id.calculate);

        findViewById(R.id.calculateButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str1 = e1.getText().toString();
                String str2 = e2.getText().toString();

                if(TextUtils.isEmpty(str1)){
                    e1.setError("Please enter Height");
                    e1.requestFocus();
                    return;
                }

                if(TextUtils.isEmpty(str2)){
                    e2.setError("Please enter Weight");
                    e2.requestFocus();
                    return;
                }

                Float height = Float.parseFloat(str1)/100;
                Float weight = Float.parseFloat(str2);

                Float BMIvalue = calculateBMI(height,weight);

                //String res = BMIvalue;
                result.setText(String.valueOf(BMIvalue));
              //  result.setText(BMIvalue.toString());
                System.out.println("Done :"+BMIvalue);

                String BMIinterpretation = checkBMi(BMIvalue);

                result.setText(String.valueOf(BMIvalue+" "+BMIinterpretation));





            }
        });

    }

    private float calculateBMI(Float height, Float weight){
        return(float) (weight/(height*height));
    }

    private String checkBMi(Float bmi){
        if (bmi < 16) {
            return "Severely underweight";
        } else if (bmi < 18.5) {

            return "Underweight";
        } else if (bmi < 25) {

            return "Normal";
        } else if (bmi < 30) {

            return "Overweight";
        } else {
            return "Obese";
        }
    }
}