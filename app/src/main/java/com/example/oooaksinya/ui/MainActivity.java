package com.example.oooaksinya.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.oooaksinya.R;
import com.example.oooaksinya.model.CalculatorImpl;
import com.example.oooaksinya.model.Operator;

import java.util.*;


public class MainActivity extends AppCompatActivity implements CalculatorView {


    private TextView resultTxt;

    private CalculatorPresenter presenter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTxt = findViewById(R.id.result);

        presenter = new CalculatorPresenter(this, new CalculatorImpl());

        Map<Integer, Integer> digits = new HashMap<>();
        digits.put(R.id.button1, 1);
        digits.put(R.id.button2, 2);
        digits.put(R.id.button3, 3);
        digits.put(R.id.button4, 4);
        digits.put(R.id.button5, 5);
        digits.put(R.id.button6, 6);
        digits.put(R.id.button7, 7);
        digits.put(R.id.button8, 8);
        digits.put(R.id.button9, 9);
        digits.put(R.id.button0, 0);


        View.OnClickListener digitClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onDigitPressed(digits.get(view.getId()));
            }
        };

        findViewById(R.id.button1).setOnClickListener(digitClickListener);
        findViewById(R.id.button2).setOnClickListener(digitClickListener);
        findViewById(R.id.button3).setOnClickListener(digitClickListener);
        findViewById(R.id.button4).setOnClickListener(digitClickListener);
        findViewById(R.id.button5).setOnClickListener(digitClickListener);
        findViewById(R.id.button6).setOnClickListener(digitClickListener);
        findViewById(R.id.button7).setOnClickListener(digitClickListener);
        findViewById(R.id.button8).setOnClickListener(digitClickListener);
        findViewById(R.id.button9).setOnClickListener(digitClickListener);
        findViewById(R.id.button0).setOnClickListener(digitClickListener);

        Map<Integer, Operator> operators = new HashMap<>();
        operators.put(R.id.button_division, Operator.DIV);
        operators.put(R.id.button_minus, Operator.SUB);
        operators.put(R.id.button_plus, Operator.ADD);
        operators.put(R.id.button_increase, Operator.MULT);

        View.OnClickListener operatorsClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onOperatorPressed(operators.get(view.getId()));
            }
        };


        findViewById(R.id.button_division).setOnClickListener(operatorsClickListener);
        findViewById(R.id.button_minus).setOnClickListener(operatorsClickListener);
        findViewById(R.id.button_plus).setOnClickListener(operatorsClickListener);
        findViewById(R.id.button_increase).setOnClickListener(operatorsClickListener);

        findViewById(R.id.button_dot).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onDotPressed();
            }
        });
    }

    @Override
    public void showResult(String result) {
        resultTxt.setText(result);
    }
}