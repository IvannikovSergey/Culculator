package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textViewShowResult;

    Button buttonOne, buttonTwo, buttonThree, buttonFour, buttonFive, buttonSix, buttonSeven, buttonEight, buttonNine, buttonZero, buttonEqual, buttonClear, buttonBackspace, buttonMultp, buttonPlus, buttonMinus, buttonPersent, buttonDivide, buttonDesimal;
    double valueOne, valueTwo;
    boolean isAddition, isDivision, isMulty, isSubstract;
    String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();
        setOnButtonsListener();

    }

    public void initUI() {
        buttonOne = findViewById(R.id.buttonOne);
        buttonTwo = findViewById(R.id.buttonTwo);
        buttonThree = findViewById(R.id.buttonThree);
        buttonFour = findViewById(R.id.buttonFour);
        buttonFive = findViewById(R.id.buttonFive);
        buttonSix = findViewById(R.id.buttonSix);
        buttonSeven = findViewById(R.id.buttonSeven);
        buttonEight = findViewById(R.id.buttonEight);
        buttonNine = findViewById(R.id.buttonNine);
        buttonZero = findViewById(R.id.buttonZero);
        buttonMinus = findViewById(R.id.buttonMinus);
        buttonPlus = findViewById(R.id.buttonPlus);
        buttonMultp = findViewById(R.id.buttonMultp);
        buttonDivide = findViewById(R.id.buttonDivide);
        buttonEqual = findViewById(R.id.buttonEqual);
        buttonDesimal = findViewById(R.id.buttonDecimal);
        buttonBackspace = findViewById(R.id.buttonBackspace);
        buttonPersent = findViewById(R.id.buttonPersent);
        buttonClear = findViewById(R.id.buttonClear);
        textViewShowResult = findViewById(R.id.textViewResult);

    }

    public void setOnButtonsListener() {
        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setText("1");
            }
        });

        buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setText("2");
            }
        });

        buttonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setText("3");
            }
        });

        buttonFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setText("4");
            }
        });

        buttonFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setText("5");
            }
        });

        buttonSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setText("6");
            }
        });

        buttonSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setText("7");
            }
        });

        buttonEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setText("8");
            }
        });

        buttonNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setText("9");
            }
        });

        buttonZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setText("0");
            }
        });

        buttonClear.setOnClickListener(v -> textViewShowResult.setText(""));

        buttonDesimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setText(".");
            }
        });


        buttonBackspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = textViewShowResult.getText().toString();
                if (result.length() != 0) {
                    result = result.substring(0, result.length() - 1);
                }
                textViewShowResult.setText(result);
            }
        });

        buttonPlus.setOnClickListener(v -> {
            try {
                valueOne = Double.parseDouble(textViewShowResult.getText() + "");
            } catch (NumberFormatException ex) {
            }
            isAddition = true;
            textViewShowResult.setText(null);
        });

        buttonMinus.setOnClickListener(v -> {
            try {
                valueOne = Double.parseDouble(textViewShowResult.getText() + "");
            } catch (NumberFormatException ex) {
            }
            isSubstract = true;
            textViewShowResult.setText(null);
        });

        buttonMultp.setOnClickListener(v -> {
            try {
                valueOne = Double.parseDouble(textViewShowResult.getText() + "");
            } catch (NumberFormatException ex) {
            }
            isMulty = true;
            textViewShowResult.setText(null);
        });

        buttonDivide.setOnClickListener(v -> {
            try {
                valueOne = Double.parseDouble(textViewShowResult.getText() + "");
            } catch (NumberFormatException ex) {
            }
            isDivision = true;
            textViewShowResult.setText(null);
        });

        buttonEqual.setOnClickListener(v -> {
            try {
                valueTwo = Double.parseDouble(textViewShowResult.getText() + "");
            } catch (NumberFormatException ex) {
                textViewShowResult.setText("");
            }
            if (isAddition) {
                textViewShowResult.setText(valueOne + valueTwo + "");
                isAddition = false;
            } else if (isSubstract) {
                textViewShowResult.setText(valueOne - valueTwo + "");
                isSubstract = false;
            } else if (isMulty) {
                textViewShowResult.setText(valueOne * valueTwo + "");
                isMulty = false;
            } else if (isDivision) {
                if (valueTwo != 0) {
                    textViewShowResult.setText(valueOne / valueTwo + "");
                    isDivision = false;
                } else {
                    Toast.makeText(this, "На ноль делить нельзя", Toast.LENGTH_SHORT).show();
                    textViewShowResult.setText("");
                }
            }
        });
    }

    public void setText(String s) {
        textViewShowResult.setText(textViewShowResult.getText().toString() + s);
    }
}