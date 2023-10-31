package com.example.bmiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    EditText edtHeightFeet, edtHeightInches, edtWeight;
    TextView result;
    Button btnCalculate;
    ImageView imgBody;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtWeight = findViewById(R.id.edtWeight);
        edtHeightFeet = findViewById(R.id.edtHeightFeet);
        edtHeightInches = findViewById(R.id.edtHeightInches);
        btnCalculate = findViewById(R.id.btnCalculate);
        result = findViewById(R.id.txtResult);
        imgBody = findViewById(R.id.imgBody);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int weight = Integer.parseInt(edtWeight.getText().toString());
                int heightFt = Integer.parseInt(edtHeightFeet.getText().toString());
                int heightIn = Integer.parseInt(edtHeightInches.getText().toString());

                int totalIn = heightFt*12 + heightIn;
                double totalCm = totalIn * 2.53;
                double totalM = totalCm/100;
                double bmi = weight / (totalM*totalM);
                result.setVisibility(View.VISIBLE);
                if(bmi > 25){
                    result.setText("You are Overweight");
                    imgBody.setVisibility(View.VISIBLE);
                    Glide.with(MainActivity.this).load(R.drawable.fat).into(imgBody);
                }else if(bmi < 18){
                    result.setText("You are UnderWeight");
                    imgBody.setVisibility(View.VISIBLE);
                    Glide.with(MainActivity.this).load(R.drawable.anorexia).into(imgBody);
                }else{
                    result.setText("You are Healthy");
                    imgBody.setVisibility(View.VISIBLE);
                    Glide.with(MainActivity.this).load(R.drawable.healthy).into(imgBody);
                }
            }
        });
    }
}