package com.example.androidcalculator;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvResult;
    private Expression expression=new Expression();

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
                expression=new Expression();
                tvResult.setText("0");
                break;
            case "(":
                expression.openExpression();
                tvResult.setText(expression.toString());
                break;
            case ")":
                expression.closeExpression();
                tvResult.setText(expression.toString());
                break;
            case "+":
                expression.addOperand(buttonText);
                tvResult.setText(expression.toString());
                break;
            default:
                //numbers
                expression.addNumber(buttonText);
                tvResult.setText(expression.toString());

        }
    }
    private void calculateResult() {

    }
    private double evaluateExpression(String expression) {
        return 0;
    }
}