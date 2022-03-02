package ru.gb.course1.androidl2layoutscalculatorhw.domain.states;

import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ru.gb.course1.androidl2layoutscalculatorhw.domain.entities.InputSymbol;

abstract public class BaseState {

    protected List<InputSymbol> input = new ArrayList<>();
    public int countArgs = 0;
    public float arg1 = 0.0f, arg2 = 0.0f, totalResult = 0.0f;
    public String argument = "", textString = "";
    public char operation = ' ';
    public boolean afterEquals = true;
    public TextView resultTextViewCalc;

    public abstract BaseState onClickButton(InputSymbol inputSymbol);

    public List<InputSymbol> getInput() {
        return new ArrayList<>(input);
    }

    public boolean calculateResult(float a1, float a2, char op) {
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

//  Почему-то не ловит(( Не пойму...((
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

    public String convertArrayListInputSymbolsToString(List<InputSymbol> inputSymbolList) {
        final StringBuilder sb = new StringBuilder();
        for (InputSymbol inputSymbol : inputSymbolList) {
            switch (inputSymbol) {
                case ZERO_DIGIT:
                    sb.append("@string/symbol_zero_on_button");
                    break;
                case ONE_DIGIT:
                    sb.append("1");
//                    sb.append("@string/symbol_one_on_button");
                    break;
                case TWO_DIGIT:
                    sb.append("@string/symbol_two_on_button");
                    break;
                case THREE_DIGIT:
                    sb.append("@string/symbol_three_on_button");
                    break;
                case FOUR_DIGIT:
                    sb.append("@string/symbol_four_on_button");
                    break;
                case FIVE_DIGIT:
                    sb.append("@string/symbol_five_on_button");
                    break;
                case SIX_DIGIT:
                    sb.append("@string/symbol_six_on_button");
                    break;
                case SEVEN_DIGIT:
                    sb.append("@string/symbol_seven_on_button");
                    break;
                case EIGHT_DIGIT:
                    sb.append("@string/symbol_eight_on_button");
                    break;
                case NINE_DIGIT:
                    sb.append("@string/symbol_nine_on_button");
                    break;
                case MULTIPL_OPERATION:
                    sb.append("@string/multiplication_operation");
                    break;
                case DIVIDE_OPERATION:
                    sb.append("@string/divide_operation");
                    break;
                case SUBSTRACT_OPERATION:
                    sb.append("@string/subtraction_operation");
                    break;
                case ADD_OPERATION:
                    sb.append("@string/addition_operation");
                    break;
                case DEC_POINT:
                    sb.append("@string/symbol_decimal_point_on_button");
                    break;
                default:
                    sb.append("@");
                    break;
            }
        }
        return sb.toString();
    }

    public String convertInputSymbolsToString(InputSymbol inputSymbol) {
        String symbol;
        switch (inputSymbol) {
            case ZERO_DIGIT:
                symbol = "@string/symbol_zero_on_button";
                break;
            case ONE_DIGIT:
                symbol = "@string/symbol_one_on_button";
                break;
            case TWO_DIGIT:
                symbol = "@string/symbol_two_on_button";
                break;
            case THREE_DIGIT:
                symbol = "@string/symbol_three_on_button";
                break;
            case FOUR_DIGIT:
                symbol = "@string/symbol_four_on_button";
                break;
            case FIVE_DIGIT:
                symbol = "@string/symbol_five_on_button";
                break;
            case SIX_DIGIT:
                symbol = "@string/symbol_six_on_button";
                break;
            case SEVEN_DIGIT:
                symbol = "@string/symbol_seven_on_button";
                break;
            case EIGHT_DIGIT:
                symbol = "@string/symbol_eight_on_button";
                break;
            case NINE_DIGIT:
                symbol = "@string/symbol_nine_on_button";
                break;
//                case MULTIPL_OPERATION:
//                    sb.append("@string/multiplication_operation");
//                    break;
//                case DIVIDE_OPERATION:
//                    sb.append("@string/divide_operation");
//                    break;
//                case SUBSTRACT_OPERATION:
//                    sb.append("@string/subtraction_operation");
//                    break;
//                case ADD_OPERATION:
//                    sb.append("@string/addition_operation");
//                    break;
//                case DEC_POINT:
//                    sb.append("@string/symbol_decimal_point_on_button");
//                    break;
            default:
                symbol = "@";
                break;
        }
        return symbol;
    }

    public BaseState performingAnOperation(InputSymbol inputSymbol) {

        switch (inputSymbol) {
            case CLEAR_ALL_OPERATION:
                totalResult = 0.0f;
                arg1 = 0.0f;
                arg2 = 0.0f;
                textString = "@string/symbol_zero_on_button";
                operation = ' ';
                countArgs = 0;
                input = new ArrayList<>();
                return new InputArgumentState(input);
            case CLEAR_LAST_SYMBOL_OPERATION:
                if (input.size() != 0) {
                    input.remove(input.size() - 1);
                }
                return new InputArgumentState(input);
        }

        if (countArgs == 0 || operation == ' ') {
            if (arg1 == 0.0f) {
                textString = convertArrayListInputSymbolsToString(input);
                arg1 = Float.parseFloat(textString);
            }
            countArgs = 1;
            switch (inputSymbol) {
                case MULTIPL_OPERATION:
                case DIVIDE_OPERATION:
                case SUBSTRACT_OPERATION:
                case ADD_OPERATION:
                    operationCodeAssignment(inputSymbol);
                    textString = String.valueOf(arg1) + operation;
                    break;
                case INVERSION_OPERATION:
                    if (arg1 != 0.0f) {
                        if (arg1 > 0.0f)
                            input.add(0, InputSymbol.SUBSTRACT_OPERATION);
                        else input.remove(0);
                        textString = convertArrayListInputSymbolsToString(input);
                        resultTextViewCalc.setText(textString);
                        arg1 = -arg1;
                        countArgs = 1;
                    }
                    return new InputArgumentState(input);
                case SQRT_OPERATION:
                    arg1 *= arg1;
                    textString = String.valueOf(arg1);
                    break;
                case PERFORM_CALC:
                    break;
                default:
                    return this;
            }
            resultTextViewCalc.setText(textString);
            input = new ArrayList<>();
            return new InputOperationOnlyState(input);
        } else {
            if (arg2 == 0.0f) {
                arg2 = Float.parseFloat(convertArrayListInputSymbolsToString(input));
            }
            switch (inputSymbol) {
                case MULTIPL_OPERATION:
                case DIVIDE_OPERATION:
                case SUBSTRACT_OPERATION:
                case ADD_OPERATION:
                    if (calculateResult(arg1, arg2, operation)) {
                        resultTextViewCalc.setText("@string/can_not_divide_by_zero");
                        totalResult = 0.0f;
                        arg1 = 0.0f;
                        arg2 = 0.0f;
                        textString = "";
                        operation = ' ';
                        countArgs = 0;
                        input = new ArrayList<>();
                    } else {
                        operationCodeAssignment(inputSymbol);
                        textString = String.valueOf(totalResult) + operation;
                        resultTextViewCalc.setText(textString);
                        countArgs = 1;
                        arg1 = totalResult;
                        arg2 = 0.0f;
                    }
                    return new InputArgumentState(input);
                case INVERSION_OPERATION:
                    if (arg2 != 0.0f) {
                        if (arg2 > 0.0f)
                            input.add(0, InputSymbol.SUBSTRACT_OPERATION);
                        else input.remove(0);
                        textString = convertArrayListInputSymbolsToString(input);
                        resultTextViewCalc.setText(textString);
                        arg2 = -arg2;
                        countArgs = 1;
                    }
                    return new InputArgumentState(input);
                case SQRT_OPERATION:
                    arg2 *= arg2;
                    textString += String.valueOf(arg2);
                    resultTextViewCalc.setText(textString);
                    input = new ArrayList<>();
                    return new InputOperationOnlyState(input);
                case PERFORM_CALC:
                    if (calculateResult(arg1, arg2, operation)) {
                        resultTextViewCalc.setText("@string/can_not_divide_by_zero");
                        totalResult = 0.0f;
                        arg1 = 0.0f;
                        arg2 = 0.0f;
                        textString = "";
                        operation = ' ';
                        countArgs = 0;
                        input = new ArrayList<>();
                        return new InputArgumentState(input);
                    } else {
                        textString = String.valueOf(totalResult);
                        resultTextViewCalc.setText(textString);
                        countArgs = 1;
                        arg1 = totalResult;
                        arg2 = 0.0f;
                        return new InputOperationOnlyState(input);
                    }
                default:
                    return this;
            }
        }
//        return this;
    }

    private void operationCodeAssignment(InputSymbol inputSymbol) {
        switch (inputSymbol) {
            case ADD_OPERATION:
                operation = "@string/addition_operation".charAt(0);
                break;
            case DIVIDE_OPERATION:
                operation = "@string/divide_operation".charAt(0);
                break;
            case MULTIPL_OPERATION:
                operation = "@string/multiplication_operation".charAt(0);
                break;
            case SUBSTRACT_OPERATION:
                operation = "@string/subtraction_operation".charAt(0);
        }
    }
}
