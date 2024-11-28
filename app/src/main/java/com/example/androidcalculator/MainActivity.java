package com.example.androidcalculator;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView tvResult;
    private

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult = findViewById(R.id.tvResult);
    }

    public void onButtonClick(View view) {
        Button button = (Button) view;
        String buttonText = button.getText().toString();

        switch (buttonText) {
            case "=":
                calculateResult();
                break;
            case "C":
                input.setLength(0);
                tvResult.setText("0");
                break;
            case "sin(":
                tvResult.setTest(input.toString());
            default:
                input.append(buttonText);
                tvResult.setText(input.toString());
                break;
        }
    }
    private void calculateResult() {
        try {
            double result = evaluateExpression(input.toString());
            tvResult.setText(String.valueOf(result));
            input.setLength(0);
        } catch (Exception e) {
            tvResult.setText("Error");
        }
    }
    private double evaluateExpression(String expression) {
        double result=0;
        if (expression.contains("sin")){

        }
    }
}