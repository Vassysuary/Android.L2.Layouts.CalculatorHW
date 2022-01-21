package ru.gb.course1.androidl2layoutscalculatorhw;

import android.app.NativeActivity;
import android.widget.TextView;
import android.widget.Toast;

public class Calculator {
    public int countArgs = 0;
    public float arg1 = 0.0f, arg2 = 0.0f, totalResult = 0.0f;
    public String argument = "", textString = "";
    public char operation = ' ';
    public boolean afterEquals = true;
    public TextView resultTextViewCalc;

    public void OperationMultiplication() {
        if (argument != "") {
            if (CheckArgForCorrectInput(argument)) {
                if (countArgs == 0) {
                    arg1 = Float.parseFloat(argument);
                    operation = '*';
                    textString += "*";
                    resultTextViewCalc.setText(textString);
                } else {
                    arg2 = Float.parseFloat(argument);
                    if (calculateResult(arg1, arg2, operation)) {
                        resultTextViewCalc.setText("Делить на ноль нельзя!");
                        totalResult = 0f;
                        textString = "";
                        operation = ' ';
                        countArgs = -1;
                    } else {
                        operation = '*';
                        textString += "*";
                        resultTextViewCalc.setText(textString);
                    }
                    arg1 = totalResult;
                }
                countArgs++;
                argument = "";
                afterEquals = false;
            } else {
                Toast.makeText(resultTextViewCalc.getContext(), "Неправильный ввод!", Toast.LENGTH_SHORT).show();
            }
        }
    }
    public void OperationSubtraction() {
        if (argument != "") {
            if (CheckArgForCorrectInput(argument)) {
                if (countArgs == 0) {
                    arg1 = Float.parseFloat(argument);
                    operation = '-';
                    textString += "-";
                    resultTextViewCalc.setText(textString);
                } else {
                    arg2 = Float.parseFloat(argument);
                    if (calculateResult(arg1, arg2, operation)) {
                        resultTextViewCalc.setText("Делить на ноль нельзя!");
                        totalResult = 0f;
                        textString = "0";
                        operation = ' ';
                        countArgs = -1;
                    } else {
                        operation = '-';
                        textString += "-";
                        resultTextViewCalc.setText(textString);
                    }
                    arg1 = totalResult;
                }
                countArgs++;
                argument = "";
                afterEquals = false;
            } else {
                Toast.makeText(resultTextViewCalc.getContext(), "Неправильный ввод!", Toast.LENGTH_SHORT).show();
            }
        }
    }
    public void OperationAddition() {
        if (argument != "") {
            if (CheckArgForCorrectInput(argument)) {
                if (countArgs == 0) {
                    arg1 = Float.parseFloat(argument);
                    operation = '+';
                    textString += "+";
                    resultTextViewCalc.setText(textString);
                } else {
                    arg2 = Float.parseFloat(argument);
                    if (calculateResult(arg1, arg2, operation)) {
                        resultTextViewCalc.setText("Делить на ноль нельзя!");
                        totalResult = 0f;
                        textString = "";
                        operation = ' ';
                        countArgs = -1;
                    } else {
                        operation = '+';
                        textString += "+";
                        resultTextViewCalc.setText(textString);
                    }
                    arg1 = totalResult;
                }
                countArgs++;
                argument = "";
                afterEquals = false;
            }else {
                Toast.makeText(resultTextViewCalc.getContext(), "Неправильный ввод!", Toast.LENGTH_SHORT).show();
            }
        }
    }
    public void OperationDivide() {
        if (argument != "") {
            if (CheckArgForCorrectInput(argument)) {
                if (countArgs == 0) {
                    arg1 = Float.parseFloat(argument);
                    operation = '/';
                    textString += "/";
                    resultTextViewCalc.setText(textString);
                } else {
                    arg2 = Float.parseFloat(argument);
                    if (calculateResult(arg1, arg2, operation)) {
                        resultTextViewCalc.setText("Делить на ноль нельзя!");
                        totalResult = 0f;
                        textString = "";
                        operation = ' ';
                        countArgs = -1;
                    } else {
                        operation = '/';
                        textString += "/";
                        resultTextViewCalc.setText(textString);
                    }
                    arg1 = totalResult;
                }
                countArgs++;
                argument = "";
                afterEquals = false;
            }else {
                Toast.makeText(resultTextViewCalc.getContext(), "Неправильный ввод!", Toast.LENGTH_SHORT).show();
            }
        }
    }
    public void PerformCalculation() {
        if (argument != "" && countArgs >= 1 && operation != ' ') {
            if (CheckArgForCorrectInput(argument)) {
                arg2 = Float.parseFloat(argument);
                if (calculateResult(arg1, arg2, operation)) {
                    resultTextViewCalc.setText("Делить на ноль нельзя!");
                    totalResult = 0f;
                    argument = "";
                    textString = "";
                } else {
                    resultTextViewCalc.setText(String.valueOf(totalResult));
                    argument = String.valueOf(totalResult);
                    textString = String.valueOf(totalResult);
                }
                countArgs = 0;
                operation = ' ';
                afterEquals = true;
            }else {
                Toast.makeText(resultTextViewCalc.getContext(), "Неправильный ввод!", Toast.LENGTH_SHORT).show();
            }
        }
    }
    public void ClearAll() {
        totalResult = 0f;
        argument = "";
        textString = "";
        resultTextViewCalc.setText(String.valueOf(totalResult));
        countArgs = 0;
        operation = ' ';
    }
    public void ClearLastDigitOrSymbol() {
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
            resultTextViewCalc.setText(textString);
        }
        else {
            totalResult = 0f;
            argument = "";
            textString = "";
            resultTextViewCalc.setText(String.valueOf(totalResult));
            countArgs = 0;
            operation = ' ';
        }
    }
    public void OperationSqrt() {
        if (argument != "") {
            if (CheckArgForCorrectInput(argument)) {
                if (countArgs == 0) {
                    arg1 = Float.parseFloat(argument);
                    totalResult = arg1 * arg1;
                    argument = String.valueOf(totalResult);
                    textString = String.valueOf(totalResult);
                    resultTextViewCalc.setText(String.valueOf(totalResult));
                } else {
                    arg2 = Float.parseFloat(argument);
                    if (calculateResult(arg1, arg2, operation)) {
                        resultTextViewCalc.setText("Делить на ноль нельзя!");
                        totalResult = 0f;
                        argument = "";
                        textString = "";
                    } else {
                        totalResult *= totalResult;
                        resultTextViewCalc.setText(String.valueOf(totalResult));
                        argument = String.valueOf(totalResult);
                        textString = String.valueOf(totalResult);
                    }
                }
                countArgs = 0;
                operation = ' ';
                afterEquals = true;
            }else {
                Toast.makeText(resultTextViewCalc.getContext(), "Неправильный ввод!", Toast.LENGTH_SHORT).show();
            }
        }
    }
    public void OperationCube() {
        if (argument != "") {
            if (CheckArgForCorrectInput(argument)) {
                if (countArgs == 0) {
                    arg1 = Float.parseFloat(argument);
                    totalResult = arg1 * arg1 * arg1;
                    argument = String.valueOf(totalResult);
                    textString = String.valueOf(totalResult);
                    resultTextViewCalc.setText(String.valueOf(totalResult));
                } else {
                    arg2 = Float.parseFloat(argument);
                    if (calculateResult(arg1, arg2, operation)) {
                        resultTextViewCalc.setText("Делить на ноль нельзя!");
                        totalResult = 0f;
                        argument = "";
                        textString = "";
                    } else {
                        totalResult = totalResult * totalResult * totalResult;
                        resultTextViewCalc.setText(String.valueOf(totalResult));
                        argument = String.valueOf(totalResult);
                        textString = String.valueOf(totalResult);
                    }
                }
                countArgs = 0;
                operation = ' ';
                afterEquals = true;
            }else {
                Toast.makeText(resultTextViewCalc.getContext(), "Неправильный ввод!", Toast.LENGTH_SHORT).show();
            }
        }
    }
    public void DigitOne() {
        InputDigitOrSymbolToString("1");
    }
    public void DigitTwo() {
        InputDigitOrSymbolToString("2");
    }
    public void DigitThree() {
        InputDigitOrSymbolToString("3");
    }
    public void DigitFour() {
        InputDigitOrSymbolToString("4");
    }
    public void DigitFive() {
        InputDigitOrSymbolToString("5");
    }
    public void DigitSix() {
        InputDigitOrSymbolToString("6");
    }
    public void DigitSeven() {
        InputDigitOrSymbolToString("7");
    }
    public void DigitEight() {
        InputDigitOrSymbolToString("8");
    }
    public void DigitNine() {
        InputDigitOrSymbolToString("9");
    }
    public void DigitZero() {
        InputDigitOrSymbolToString("0");
    }
    public void DecimalPoint() {
        InputDigitOrSymbolToString(".");
    }

    private void InputDigitOrSymbolToString(String str) {
        if (afterEquals) {
            textString = str;
            argument = str;
            resultTextViewCalc.setText(textString);
            afterEquals = false;
        } else {
            argument += str;
            textString += str;
            resultTextViewCalc.setText(textString);
        }
    }

    // Проверка аргумента на правильный ввод
    public boolean CheckArgForCorrectInput(String arg) {
        if (arg.length() > 1 && arg.substring(0, 2).equals("00")) {
            return false;
        }
        try {
            Float.parseFloat(arg);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
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
