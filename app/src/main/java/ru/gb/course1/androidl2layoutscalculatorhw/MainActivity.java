package ru.gb.course1.androidl2layoutscalculatorhw;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private int countArgs = 0;
    private float arg1 = 0.0f, arg2 = 0.0f, totalResult = 0.0f;
    private String argument = "", textString = "";
    private char operation = ' ';
    private boolean afterEquals = true;
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
    private Button clearEndButton;
    private Button clearButton;
    private Button sqrtButton;
    private Button cubeButton;
    private static final String OUR_RESULT_STRING_KEY = "@@@";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
//        if (savedInstanceState != null && savedInstanceState.containsKey(OUR_RESULT_STRING_KEY)){
//            textString = savedInstanceState.getString(OUR_RESULT_STRING_KEY);
//            resultTextView.setText(textString);
//        }
        findViewById(R.id.open_new_activity_with_big_digits).setOnClickListener(view -> {
            Intent intent = new Intent(this, BigDigitActivity.class);
            startActivity(intent);
        });

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
                    afterEquals = false;
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
                    afterEquals = false;
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
                    afterEquals = false;
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
                    afterEquals = false;
                }
            }
        });
        equalsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (argument != "" && countArgs >= 1 && operation != ' ') {
                    arg2 = Float.parseFloat(argument);
                    if (calculateResult(arg1, arg2, operation)) {
                        resultTextView.setText("Делить на ноль нельзя!");
                        totalResult = 0f;
                        argument = "";
                        textString = "";
                    } else {
                        resultTextView.setText(String.valueOf(totalResult));
                        argument = String.valueOf(totalResult);
                        textString = String.valueOf(totalResult);
                    }
                    countArgs = 0;
                    operation = ' ';
                    afterEquals = true;
                }
            }
        });
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                totalResult = 0f;
                argument = "";
                textString = "";
                resultTextView.setText(String.valueOf(totalResult));
                countArgs = 0;
                operation = ' ';
            }
        });
        clearEndButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tS;
                if (textString != "") {
                    char op = textString.charAt(textString.length()-1);
                    if ( op == '/' || op == '*' || op == '+' || op == '-') operation = ' ';
                    else {
                        tS = argument.substring(0, argument.length() - 1);
                        argument = tS;
                    }
                    tS = textString.substring(0, textString.length() - 1);
                    textString = tS;
                    resultTextView.setText(textString);
                }
            }
        });
        sqrtButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (argument != "") {
                    if (countArgs == 0) {
                        arg1 = Float.parseFloat(argument);
                        totalResult = arg1 * arg1;
                        argument = String.valueOf(totalResult);
                        textString = String.valueOf(totalResult);
                        resultTextView.setText(String.valueOf(totalResult));
                    } else {
                        arg2 = Float.parseFloat(argument);
                        if (calculateResult(arg1, arg2, operation)) {
                            resultTextView.setText("Делить на ноль нельзя!");
                            totalResult = 0f;
                            argument = "";
                            textString = "";
                        } else {
                            totalResult *= totalResult;
                            resultTextView.setText(String.valueOf(totalResult));
                            argument = String.valueOf(totalResult);
                            textString = String.valueOf(totalResult);
                        }
                    }
                    countArgs = 0;
                    operation = ' ';
                    afterEquals = true;
                }
            }
        });
        cubeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (argument != "") {
                    if (countArgs == 0) {
                        arg1 = Float.parseFloat(argument);
                        totalResult = arg1 * arg1 * arg1;
                        argument = String.valueOf(totalResult);
                        textString = String.valueOf(totalResult);
                        resultTextView.setText(String.valueOf(totalResult));
                    } else {
                        arg2 = Float.parseFloat(argument);
                        if (calculateResult(arg1, arg2, operation)) {
                            resultTextView.setText("Делить на ноль нельзя!");
                            totalResult = 0f;
                            argument = "";
                            textString = "";
                        } else {
                            totalResult = totalResult * totalResult * totalResult;
                            resultTextView.setText(String.valueOf(totalResult));
                            argument = String.valueOf(totalResult);
                            textString = String.valueOf(totalResult);
                        }
                    }
                    countArgs = 0;
                    operation = ' ';
                    afterEquals = true;
                }
            }
        });
        oneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (afterEquals) {
                    textString = "1";
                    argument = "1";
                    resultTextView.setText(textString);
                    afterEquals = false;
                } else {
                    argument += "1";
                    textString += "1";
                    resultTextView.setText(textString);
                }
            }
        });
        twoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (afterEquals) {
                    textString = "2";
                    argument = "2";
                    resultTextView.setText(textString);
                    afterEquals = false;
                } else {
                    argument += "2";
                    textString += "2";
                    resultTextView.setText(textString);
                }
            }
        });
        threeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (afterEquals) {
                    textString = "3";
                    argument = "3";
                    resultTextView.setText(textString);
                    afterEquals = false;
                } else {
                    argument += "3";
                    textString += "3";
                    resultTextView.setText(textString);
                }
            }
        });
        fourButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (afterEquals) {
                    textString = "4";
                    argument = "4";
                    resultTextView.setText(textString);
                    afterEquals = false;
                } else {
                    argument += "4";
                    textString += "4";
                    resultTextView.setText(textString);
                }
            }
        });
        fiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (afterEquals) {
                    textString = "5";
                    argument = "5";
                    resultTextView.setText(textString);
                    afterEquals = false;
                } else {
                    argument += "5";
                    textString += "5";
                    resultTextView.setText(textString);
                }
            }
        });
        sixButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (afterEquals) {
                    textString = "6";
                    argument = "6";
                    resultTextView.setText(textString);
                    afterEquals = false;
                } else {
                    argument += "6";
                    textString += "6";
                    resultTextView.setText(textString);
                }
            }
        });
        sevenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (afterEquals) {
                    textString = "7";
                    argument = "7";
                    resultTextView.setText(textString);
                    afterEquals = false;
                } else {
                    argument += "7";
                    textString += "7";
                    resultTextView.setText(textString);
                }
            }
        });
        eightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (afterEquals) {
                    textString = "8";
                    argument = "8";
                    resultTextView.setText(textString);
                    afterEquals = false;
                } else {
                    argument += "8";
                    textString += "8";
                    resultTextView.setText(textString);
                }
            }
        });
        nineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (afterEquals) {
                    textString = "9";
                    argument = "9";
                    resultTextView.setText(textString);
                    afterEquals = false;
                } else {
                    argument += "9";
                    textString += "9";
                    resultTextView.setText(textString);
                }
            }
        });
        zeroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (afterEquals) {
                    textString = "0";
                    argument = "0";
                    resultTextView.setText(textString);
                    afterEquals = false;
                } else {
                    argument += "0";
                    textString += "0";
                    resultTextView.setText(textString);
                }

            }
        });
        pointButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (afterEquals) {
                    textString = ".";
                    argument = ".";
                    resultTextView.setText(textString);
                    afterEquals = false;
                } else {
                    argument += ".";
                    textString += ".";
                    resultTextView.setText(textString);
                }
            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        SavedData savedDatas = new SavedData();
        outState.putSerializable(OUR_RESULT_STRING_KEY, savedDatas);
    }

//    @Override
//    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//        SavedData savedData = new SavedData();
//        savedData = (SavedData) savedInstanceState.getSerializable(OUR_RESULT_STRING_KEY);
//        countArgs = savedData.countArgsSave;
//        arg1 = savedData.arg1Save;
//        arg2 = savedData.arg2Save;
//        totalResult = savedData.totalResultSave;
//        argument = savedData.argumentSave;
//        textString = savedData.textStringSave;
//        operation = savedData.operationSave;
//        afterEquals = savedData.afterEqualsSave;
//        resultTextView.setText(textString);
//    }

    class SavedData implements Serializable {
        public int countArgsSave = countArgs;
        public float arg1Save = arg1, arg2Save = arg2, totalResultSave = totalResult;
        public String argumentSave = argument, textStringSave = textString;
        public char operationSave = operation;
        public boolean afterEqualsSave = afterEquals;
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
        clearEndButton = findViewById(R.id.clear_end_button);
        clearButton = findViewById(R.id.clear_button);
        sqrtButton = findViewById(R.id.sqrt_button);
        cubeButton = findViewById(R.id.cube_button);
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
                } else totalResult = a1 / a2;

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