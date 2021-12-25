package ru.gb.course1.androidl2layoutscalculatorhw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int countArgs = 0;
    private float arg1 = 0.0f, arg2 = 0.0f, totalResult = 0.0f;
    private String argument = "", textString = "";
    private char operation = ' ';
    private TextView resultTextView;
    private Button oneButton;
    private Button twoButton;
    private Button threeButton;
    private Button fourButton;
    private Button fiveButton;
    private Button sixButton;
    private Button sevenButton;
    private Button eightButton;
    private Button nineButton;
    private Button zeroButton;
    private Button multiplicationButton;
    private Button divideButton;
    private Button subtractionButton;
    private Button additionButton;
    private Button pointButton;
    private Button equalsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        multiplicationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (argument != "") {
                    if (countArgs == 0) {
                        arg1 = Float.parseFloat(argument);
                        operation = '*';
                        textString += "*";
                        resultTextView.setText(textString);
                    } else {
                        arg2 = Float.parseFloat(argument);
                        if (calculateResult(arg1, arg2, operation)) {
                            resultTextView.setText("Делить на ноль нельзя!");
                            totalResult = 0f;
                            textString = "";
                            operation = ' ';
                            countArgs = -1;
                        } else {
                            operation = '*';
                            textString += "*";
                            resultTextView.setText(textString);
                        }
                        arg1 = totalResult;
                    }
                    countArgs++;
                    argument = "";
                }
            }
        });
        subtractionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (argument != "") {
                    if (countArgs == 0) {
                        arg1 = Float.parseFloat(argument);
                        operation = '-';
                        textString += "-";
                        resultTextView.setText(textString);
                    } else {
                        arg2 = Float.parseFloat(argument);
                        if (calculateResult(arg1, arg2, operation)) {
                            resultTextView.setText("Делить на ноль нельзя!");
                            totalResult = 0f;
                            textString = "";
                            operation = ' ';
                            countArgs = -1;
                        } else {
                            operation = '-';
                            textString += "-";
                            resultTextView.setText(textString);
                        }
                        arg1 = totalResult;
                    }
                    countArgs++;
                    argument = "";
                }
            }
        });
        additionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (argument != "") {
                    if (countArgs == 0) {
                        arg1 = Float.parseFloat(argument);
                        operation = '+';
                        textString += "+";
                        resultTextView.setText(textString);
                    } else {
                        arg2 = Float.parseFloat(argument);
                        if (calculateResult(arg1, arg2, operation)) {
                            resultTextView.setText("Делить на ноль нельзя!");
                            totalResult = 0f;
                            textString = "";
                            operation = ' ';
                            countArgs = -1;
                        } else {
                            operation = '+';
                            textString += "+";
                            resultTextView.setText(textString);
                        }
                        arg1 = totalResult;
                    }
                    countArgs++;
                    argument = "";
                }
            }
        });
        divideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (argument != "") {
                    if (countArgs == 0) {
                        arg1 = Float.parseFloat(argument);
                        operation = '/';
                        textString += "/";
                        resultTextView.setText(textString);
                    } else {
                        arg2 = Float.parseFloat(argument);
                        if (calculateResult(arg1, arg2, operation)) {
                            resultTextView.setText("Делить на ноль нельзя!");
                            totalResult = 0f;
                            textString = "";
                            operation = ' ';
                            countArgs = -1;
                        } else {
                            operation = '/';
                            textString += "/";
                            resultTextView.setText(textString);
                        }
                        arg1 = totalResult;
                    }
                    countArgs++;
                    argument = "";
                }
            }
        });
        equalsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (argument != "" && countArgs >= 1) {
                    arg2 = Float.parseFloat(argument);
                    if (calculateResult(arg1, arg2, operation)) {
                        resultTextView.setText("Делить на ноль нельзя!");
                        totalResult = 0f;
                        textString = "";
                    } else {
                        resultTextView.setText(String.valueOf(totalResult));
                        operation = ' ';
                        textString = "";
                        totalResult = 0f;
                        countArgs = 0;
                        argument = "";
                    }
                }
            }
        });

        oneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                argument += "1";
                textString += "1";
                resultTextView.setText(textString);
            }
        });
        twoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                argument += "2";
                textString += "2";
                resultTextView.setText(textString);
            }
        });
        threeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                argument += "3";
                textString += "3";
                resultTextView.setText(textString);
            }
        });
        fourButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                argument += "4";
                textString += "4";
                resultTextView.setText(textString);
            }
        });
        fiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                argument += "5";
                textString += "5";
                resultTextView.setText(textString);
            }
        });
        sixButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                argument += "6";
                textString += "6";
                resultTextView.setText(textString);
            }
        });
        sevenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                argument += "7";
                textString += "7";
                resultTextView.setText(textString);
            }
        });
        eightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                argument += "8";
                textString += "8";
                resultTextView.setText(textString);
            }
        });
        nineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                argument += "9";
                textString += "9";
                resultTextView.setText(textString);
            }
        });
        zeroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textString != "") {
                    argument += "0";
                    textString += "0";
                    resultTextView.setText(textString);
                }

            }
        });
        pointButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                argument += ".";
                textString += ".";
                resultTextView.setText(textString);
            }
        });
    }

    private void initView() {
        resultTextView = findViewById(R.id.result_text_view);
        oneButton = findViewById(R.id.one_button);
        twoButton = findViewById(R.id.two_button);
        threeButton = findViewById(R.id.three_button);
        fourButton = findViewById(R.id.four_button);
        fiveButton = findViewById(R.id.five_button);
        sixButton = findViewById(R.id.six_button);
        sevenButton = findViewById(R.id.seven_button);
        eightButton = findViewById(R.id.eight_button);
        nineButton = findViewById(R.id.nine_button);
        zeroButton = findViewById(R.id.zero_button);
        multiplicationButton = findViewById(R.id.multiplication_button);
        divideButton = findViewById(R.id.divide_button);
        subtractionButton = findViewById(R.id.subtraction_button);
        additionButton = findViewById(R.id.addition_button);
        pointButton = findViewById(R.id.point_button);
        equalsButton = findViewById(R.id.equals_button);
    }

    private boolean calculateResult(float a1, float a2, char op) {
        switch (op) {
            case '*':
                totalResult = a1 * a2;
                break;
            case '-':
                totalResult = a1 - a2;
                break;
            case '+':
                totalResult = a1 + a2;
                break;
            case '/':
                if (a2 < 0.0000000001f) {
                    return true;
                }
                else totalResult = a1 / a2;

//  Почему-то не ловит(( Не непойму...((
//                try {
//                    totalResult = a1 / a2;
//                 } catch (Exception e) {
//                    e.printStackTrace();
//                    totalResult = 0f;
//                    textString = "";
//                    return true;
//                }
//                break;
        }
        return false;
    }
}