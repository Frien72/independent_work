package com.example.oooaksinya.ui;

import com.example.oooaksinya.model.Calculator;
import com.example.oooaksinya.model.Operator;

import java.text.DecimalFormat;

public class CalculatorPresenter {


    private CalculatorView view;
    private Calculator calculator;

    private double firstArg;
    private Double secondArg;
    private Operator selectedOperator;

    public CalculatorPresenter(CalculatorView view, Calculator calculator) {
        this.view = view;
        this.calculator = calculator;
    }

    public void button1Pressed() {

    }

    public void onDigitPressed(int digit){
        if (secondArg == null) {


            firstArg = firstArg * 10 + digit;
            view.showResult(String.valueOf(firstArg));

        } else {

            secondArg = secondArg * 10 + digit;
            view.showResult(String.valueOf(secondArg));

    }}


    public void onOperatorPressed(Operator operator) {
        if(selectedOperator != null) {
        firstArg = calculator.perform(firstArg,secondArg,selectedOperator);
         view.showResult(String.valueOf(firstArg));
        }
        secondArg = 0.0;
        selectedOperator = operator;

    }

    public void onDotPressed() {
    }
}
