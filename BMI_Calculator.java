package com.example.individualassignment_mohamadarif;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class BMI_Calculator extends AppCompatActivity {

    EditText weight, height;
    TextView resulttext;
    String calculation, BMIcategory, healthRisk;
    Button calculate_button, calculateBMI;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_calculator);

        Toast.makeText(getApplicationContext(), "Please enter your details here", Toast.LENGTH_SHORT).show();

        weight = (EditText) findViewById(R.id.weight);
        height = (EditText) findViewById(R.id.height);
        resulttext = findViewById(R.id.result);
        calculate_button = (Button) findViewById(R.id.calculate_button);


        calculate_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (weight.length() == 0)
                    {
                        weight.setError("Enter Weight");
                    }
                else if (height.length() == 0)
                    {
                        height.setError("Enter Height");
                    }
                else
                    {
                        String S1 = weight.getText().toString();
                        String S2 = height.getText().toString();

                        float weightValue = Float.parseFloat(S1);
                        float heightValue = Float.parseFloat(S2) / 100;

                        float bmi = weightValue / (heightValue * heightValue);

                            if (bmi < 18.4)
                                {
                                    BMIcategory = "Underweight";
                                    healthRisk  = "Malnutrition risk";
                                }
                            else if (bmi >= 18.5 && bmi <= 24.9)
                                {
                                    BMIcategory = "Normal Weight";
                                    healthRisk  = "Low risk";
                                }
                            else if (bmi >= 25 && bmi <= 29.9)
                                {
                                    BMIcategory = "Overweight";
                                    healthRisk  = "Enhanced risk";
                                }
                            else if (bmi >= 30 && bmi <= 34.9)
                                {
                                    BMIcategory = "Moderately Obese";
                                    healthRisk  = "Medium risk";
                                }
                            else if (bmi >= 35 && bmi <= 39.9)
                                {
                                    BMIcategory = "Severely Obese";
                                    healthRisk  = "High risk";
                                }
                            else
                                {
                                    BMIcategory = "Very Severely Obese";
                                    healthRisk  = "Very High risk";
                                }

                            calculation = "Result : " + bmi
                                    + "\n\nBMI Category : " + BMIcategory
                                    + "\n\nHealth Risk  : " + healthRisk;

                            resulttext.setText(calculation);
                }
            }

        });
    }
}

