package ru.gb.course1.androidl2layoutscalculatorhw;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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
    private Button digitOneButton;
    private Button digitTwoButton;
    private Button digitThreeButton;
    private Button digitFourButton;
    private Button digitFiveButton;
    private Button digitSixButton;
    private Button digitSevenButton;
    private Button digitEightButton;
    private Button digitNineButton;
    private Button digitZeroButton;
    private Button operationMultiplicationButton;
    private Button operationDivideButton;
    private Button operationSubtractionButton;
    private Button operationAdditionButton;
    private Button decimalPointButton;
    private Button performCalculationButton;
    private Button clearLastDigitOrSymbolButton;
    private Button clearAllButton;
    private Button operationSqrtButton;
    private Button operationCubeButton;
    private static final String TAG = "@@@@@";
    private static final String OUR_RESULT_STRING_KEY = "@@@";
    public SavedData savedDatas = new SavedData();

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
            initialSaveData();
            intent.putExtra(BigDigitActivity.HASH_FOR_VALUE_KEY, savedDatas);
            startActivity(intent);
        });

        operationMultiplicationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (argument != "") {
                    if (CheckArgForCorrectInput(argument)) {
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
            }
        });
        operationSubtractionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (argument != "") {
                    if (CheckArgForCorrectInput(argument)) {
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
            }
        });
        operationAdditionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (argument != "") {
                    if (CheckArgForCorrectInput(argument)) {
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
            }
        });
        operationDivideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (argument != "") {
                    if (CheckArgForCorrectInput(argument)) {
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
            }
        });
        performCalculationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (argument != "" && countArgs >= 1 && operation != ' ') {
                    if (CheckArgForCorrectInput(argument)) {
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
            }
        });
        clearAllButton.setOnClickListener(new View.OnClickListener() {
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
        clearLastDigitOrSymbolButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tS;
                if (!textString.isEmpty()) {
                    char op = textString.charAt(textString.length() - 1);
                    if (op == '/' || op == '*' || op == '+' || op == '-') operation = ' ';
                    else {
                        if (!argument.isEmpty()) {
                            tS = argument.substring(0, argument.length() - 1);
                            argument = tS;
                        }
                    }
                    tS = textString.substring(0, textString.length() - 1);
                    textString = tS;
                    resultTextView.setText(textString);
                }
                else {
                    totalResult = 0f;
                    argument = "";
                    textString = "";
                    resultTextView.setText(String.valueOf(totalResult));
                    countArgs = 0;
                    operation = ' ';
                }
            }
        });
        operationSqrtButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (argument != "") {
                    if (CheckArgForCorrectInput(argument)) {
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
            }
        });
        operationCubeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (argument != "") {
                    if (CheckArgForCorrectInput(argument)) {
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
            }
        });
        digitOneButton.setOnClickListener(new View.OnClickListener() {
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
        digitTwoButton.setOnClickListener(new View.OnClickListener() {
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
        digitThreeButton.setOnClickListener(new View.OnClickListener() {
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
        digitFourButton.setOnClickListener(new View.OnClickListener() {
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
        digitFiveButton.setOnClickListener(new View.OnClickListener() {
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
        digitSixButton.setOnClickListener(new View.OnClickListener() {
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
        digitSevenButton.setOnClickListener(new View.OnClickListener() {
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
        digitEightButton.setOnClickListener(new View.OnClickListener() {
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
        digitNineButton.setOnClickListener(new View.OnClickListener() {
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
        digitZeroButton.setOnClickListener(new View.OnClickListener() {
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
        decimalPointButton.setOnClickListener(new View.OnClickListener() {
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
// Проверка аргумента на правильный ввод
    private boolean CheckArgForCorrectInput(String arg) {
//        Log.d(TAG, "CheckArgForCorrectInput() called with: arg = [" + arg.length() + "]");
//        Log.d(TAG, "CheckArgForCorrectInput() called with: arg = [" + arg.substring(0,2) + "]");
        if (arg.length() > 1 && arg.substring(0, 2).equals("00")) {
            Toast.makeText(this, "Неправильный ввод!", Toast.LENGTH_SHORT).show();
            return false;
        }
        try {
            Float.parseFloat(arg);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Неправильный ввод!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        initialSaveData();
//        outState.putSerializable(OUR_RESULT_STRING_KEY, savedDatas);
        outState.putParcelable(OUR_RESULT_STRING_KEY, savedDatas);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        SavedData savedData = new SavedData();
//        savedData = (SavedData) savedInstanceState.getSerializable(OUR_RESULT_STRING_KEY);
        savedData = (SavedData) savedInstanceState.getParcelable(OUR_RESULT_STRING_KEY);
        countArgs = savedData.countArgsSave;
        arg1 = savedData.arg1Save;
        arg2 = savedData.arg2Save;
        totalResult = savedData.totalResultSave;
        argument = savedData.argumentSave;
        textString = savedData.textStringSave;
        operation = savedData.operationSave;
        afterEquals = savedData.afterEqualsSave;
        resultTextView.setText(textString);
    }

    private void initView() {
        resultTextView = findViewById(R.id.result_text_view);
        digitOneButton = findViewById(R.id.digit_one_button);
        digitTwoButton = findViewById(R.id.digit_two_button);
        digitThreeButton = findViewById(R.id.digit_three_button);
        digitFourButton = findViewById(R.id.digit_four_button);
        digitFiveButton = findViewById(R.id.digit_five_button);
        digitSixButton = findViewById(R.id.digit_six_button);
        digitSevenButton = findViewById(R.id.digit_seven_button);
        digitEightButton = findViewById(R.id.digit_eight_button);
        digitNineButton = findViewById(R.id.digit_nine_button);
        digitZeroButton = findViewById(R.id.digit_zero_button);
        operationMultiplicationButton = findViewById(R.id.operation_multiplication_button);
        operationDivideButton = findViewById(R.id.operation_divide_button);
        operationSubtractionButton = findViewById(R.id.operation_subtraction_button);
        operationAdditionButton = findViewById(R.id.operation_addition_button);
        decimalPointButton = findViewById(R.id.decimal_point_button);
        performCalculationButton = findViewById(R.id.perform_calculation_button);
        clearLastDigitOrSymbolButton = findViewById(R.id.clear_last_digit_or_symbol_button);
        clearAllButton = findViewById(R.id.clear_all_button);
        operationSqrtButton = findViewById(R.id.operation_sqrt_button);
        operationCubeButton = findViewById(R.id.operation_cube_button);
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

    private void initialSaveData() {
        savedDatas.countArgsSave = countArgs;
        savedDatas.arg1Save = arg1;
        savedDatas.arg2Save = arg2;
        savedDatas.totalResultSave = totalResult;
        savedDatas.argumentSave = argument;
        savedDatas.textStringSave = textString;
        savedDatas.operationSave = operation;
        savedDatas.afterEqualsSave = afterEquals;
    }
}