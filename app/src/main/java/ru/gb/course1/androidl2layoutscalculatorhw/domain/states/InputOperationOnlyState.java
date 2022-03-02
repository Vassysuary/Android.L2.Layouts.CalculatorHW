package ru.gb.course1.androidl2layoutscalculatorhw.domain.states;

import java.util.ArrayList;
import java.util.List;

import ru.gb.course1.androidl2layoutscalculatorhw.domain.entities.InputSymbol;

public class InputOperationOnlyState extends BaseState {

    public InputOperationOnlyState(List<InputSymbol> input) {
        this.input.addAll(input);
    }

    public InputOperationOnlyState() {

    }

    @Override
    public BaseState onClickButton(InputSymbol inputSymbol) {
        switch (inputSymbol) {
            case INVERSION_OPERATION:
                if (Float.parseFloat(convertArrayListInputSymbolsToString(input)) >= 0.0f)
                    input.add(0, InputSymbol.SUBSTRACT_OPERATION);
                else input.remove(0);
                textString += convertArrayListInputSymbolsToString(input);
//                arg1 = Float.parseFloat(textString);
//                totalResult = 0.0f;
//                arg2 = 0.0f;
//                textString = "";
//                operation = ' ';
//                countArgs = 1;
                resultTextViewCalc.setText(textString);
                break;
            case CLEAR_LAST_SYMBOL_OPERATION:
                if (input.size() != 0) {
                    input.remove(input.size() - 1);
                }
                break;
            case ZERO_DIGIT:
                if (arg1 != 0.0f || arg2 != 0.0f) {
                    input.add(inputSymbol);
                    textString += convertArrayListInputSymbolsToString(input);
                    resultTextViewCalc.setText(textString);
                }
                break;
            case ONE_DIGIT:
            case TWO_DIGIT:
            case THREE_DIGIT:
            case FOUR_DIGIT:
            case FIVE_DIGIT:
            case SIX_DIGIT:
            case SEVEN_DIGIT:
            case EIGHT_DIGIT:
            case NINE_DIGIT:
                input.add(inputSymbol);
                textString += convertArrayListInputSymbolsToString(input);
                resultTextViewCalc.setText(textString);
                break;
            case DEC_POINT:
                input.add(InputSymbol.DEC_POINT);
                return new InputDecimalPartOfArgumentState(input);
            case SQRT_OPERATION:
                if (countArgs == 0) {
                    arg1 = Float.parseFloat(convertArrayListInputSymbolsToString(input));
                }
// To do in this
                if (arg1 != 0.0f) {

                }
                break;
            case ADD_OPERATION:
            case DIVIDE_OPERATION:
            case MULTIPL_OPERATION:
            case SUBSTRACT_OPERATION:
                if (countArgs == 0) {
                    arg1 = Float.parseFloat(convertArrayListInputSymbolsToString(input));
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
                            break;
                    }
                    input.add(inputSymbol);
                    countArgs++;
                    textString = convertArrayListInputSymbolsToString(input);
                    resultTextViewCalc.setText(textString);
                } else if (countArgs >= 1) {
                    arg2 = Float.parseFloat(convertArrayListInputSymbolsToString(input));
                    if (calculateResult(arg1, arg2, operation)) {
                        resultTextViewCalc.setText("@string/can_not_divide_by_zero");
                        totalResult = 0.0f;
                        arg1 = 0.0f;
                        arg2 = 0.0f;
                        textString = "";
                        operation = ' ';
                        countArgs = 0;
                    } else {
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
                                break;
                        }
                        textString = String.valueOf(totalResult) + operation;
                        resultTextViewCalc.setText(textString);
                        countArgs = 1;
                        arg1 = totalResult;
                    }
                }
                List<InputSymbol> input = new ArrayList<>();
                break;

            case CLEAR_ALL_OPERATION:
                totalResult = 0.0f;
                arg1 = 0.0f;
                arg2 = 0.0f;
                textString = "@string/symbol_zero_on_button";
                operation = ' ';
                countArgs = 0;
                resultTextViewCalc.setText(textString);
                input = new ArrayList<>();
                break;

            default:
                return this;
        }
        return this;
    }
}
