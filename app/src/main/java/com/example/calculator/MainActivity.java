package com.example.calculator;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private TextView textViewResult;
    private TextView textViewHistory;

    private String number = null;

    private Button buttonOne, buttonTwo, buttonThree, buttonFour, buttonFive, buttonSix, buttonSeven, buttonEight, buttonNine, buttonZero, buttonEqual, buttonClear, buttonBackspace, buttonMultp, buttonPlus, buttonMinus, buttonPersent, buttonDivide, buttonDesimal;

    double firstValue = 0;
    double lastVavue = 0;

    String status = null;
    boolean operator = false;
    boolean dot = true;
    boolean buttonClearControl = true;
    boolean buttonEqualsControl = false;

    DecimalFormat formatter;

    String history, currentResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        formatter = new DecimalFormat("######.###");

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

        textViewResult = findViewById(R.id.textViewResult);
        textViewHistory = findViewById(R.id.textViewHistory);

    }

    public void setOnButtonsListener() {
        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickedNumber("1");
            }
        });

        buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickedNumber("2");
            }
        });

        buttonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickedNumber("3");
            }
        });

        buttonFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickedNumber("4");
            }
        });

        buttonFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickedNumber("5");
            }
        });

        buttonSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickedNumber("6");
            }
        });

        buttonSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickedNumber("7");
            }
        });

        buttonEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickedNumber("8");
            }
        });

        buttonNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickedNumber("9");
            }
        });

        buttonZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickedNumber("0");
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operator = false;
                status = null;
                number = null;
                firstValue = 0;
                lastVavue = 0;
                textViewResult.setText("0");
                textViewHistory.setText("");
                dot = true;
                buttonClearControl = true;
            }
        });

        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                history = textViewHistory.getText().toString();
                currentResult = textViewResult.getText().toString();
                textViewHistory.setText(history + currentResult + "+");

                if (operator) {
                    if (status == "multiplication") {
                        multiply();
                    } else if (status == "division") {
                        divide();
                    } else if (status == "substraction") {
                        minus();
                    } else {
                        plus();
                    }
                }
                status = "sum";
                operator = false;
                number = null;
            }
        });

        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                history = textViewHistory.getText().toString();
                currentResult = textViewResult.getText().toString();
                textViewHistory.setText(history + currentResult + "-");

                if (operator) {
                    if (status == "multiplication") {
                        multiply();
                    } else if (status == "division") {
                        divide();
                    } else if (status == "sum") {
                        plus();
                    } else {
                        minus();
                    }
                }
                status = "substraction";
                operator = false;
                number = null;
            }
        });

        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                history = textViewHistory.getText().toString();
                currentResult = textViewResult.getText().toString();
                textViewHistory.setText(history + currentResult + "/");

                if (operator) {
                    if (status == "multiplication") {
                        multiply();
                    } else if (status == "substraction") {
                        minus();
                    } else if (status == "sum") {
                        plus();
                    } else {
                        divide();
                    }
                }
                status = "division";
                operator = false;
                number = null;
            }
        });

        buttonMultp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                history = textViewHistory.getText().toString();
                currentResult = textViewResult.getText().toString();
                textViewHistory.setText(history + currentResult + "*");

                if (operator) {
                    if (status == "sum") {
                        plus();
                    } else if (status == "division") {
                        divide();
                    } else if (status == "substraction") {
                        minus();
                    } else {
                        multiply();
                    }
                }
                status = "multiplication";
                operator = false;
                number = null;
            }
        });

        buttonBackspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (buttonClearControl) {
                    textViewResult.setText("0");
                } else {
                    number = number.substring(0, number.length() - 1);
                    if (number.length() == 0) {
                        buttonBackspace.setClickable(false);
                    } else if (number.contains(".")) {
                        dot = false;
                    } else {
                        dot = true;
                    }
                    textViewResult.setText(number);
                }
            }
        });

        buttonPersent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        buttonDesimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (dot) {
                    if (number == null) {
                        number = "0.";
                    } else {
                        number = number + ".";
                    }
                }
                textViewResult.setText(number);
                dot = false;
            }
        });

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (operator) {
                    if (status == "sum") {
                        plus();
                    } else if (status == "substraction") {
                        minus();
                    } else if (status == "multiplication") {
                        multiply();
                    } else if (status == "division") {
                        divide();
                    } else {
                        firstValue = Double.parseDouble(textViewResult.getText().toString());
                    }
                }
                operator = false;
                buttonEqualsControl = true;
            }
        });
    }

    public void clickedNumber(String view) {
        if (number == null) {
            number = view;
        } else if (buttonEqualsControl) {
            firstValue = 0;
            lastVavue = 0;
            number = view;
        } else {
            number = number + view;
        }
        textViewResult.setText(number);
        operator = true;
        buttonClearControl = false;
        buttonBackspace.setClickable(true);
        buttonEqualsControl = false;
    }

    public void plus() {
        lastVavue = Double.parseDouble(textViewResult.getText().toString());
        firstValue = firstValue + lastVavue;
        myFormatView(firstValue);
        dot = true;

    }

    public void minus() {
        if (firstValue == 0) {
            firstValue = Double.parseDouble(textViewResult.getText().toString());
        } else {
            lastVavue = Double.parseDouble(textViewResult.getText().toString());
            firstValue = firstValue - lastVavue;
        }

        myFormatView(firstValue);
        dot = true;
    }

    public void multiply() {
        if (firstValue == 0) {
            firstValue = 1;
            lastVavue = Double.parseDouble(textViewResult.getText().toString());
            firstValue = firstValue * lastVavue;
        } else {
            lastVavue = Double.parseDouble(textViewResult.getText().toString());
            firstValue = firstValue * lastVavue;
        }

        myFormatView(firstValue);
        dot = true;
    }

    public void divide() {
        if (firstValue == 0) {
            lastVavue = Double.parseDouble(textViewResult.getText().toString());
            firstValue = lastVavue / 1;
        } else {
            lastVavue = Double.parseDouble(textViewResult.getText().toString());
            firstValue = firstValue / lastVavue;
        }

        myFormatView(firstValue);
        dot = true;
    }

    public void myFormatView(double value) {
        textViewResult.setText(formatter.format(value));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);

        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        } else {
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // Check if the correct item was clicked.
        if (item.getItemId() == R.id.night_mode) {
            int nightMode = AppCompatDelegate.getDefaultNightMode();
            if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode
                        (AppCompatDelegate.MODE_NIGHT_NO);
            } else {
                AppCompatDelegate.setDefaultNightMode
                        (AppCompatDelegate.MODE_NIGHT_YES);
            }
            recreate();
        }
        return true;
    }
}

