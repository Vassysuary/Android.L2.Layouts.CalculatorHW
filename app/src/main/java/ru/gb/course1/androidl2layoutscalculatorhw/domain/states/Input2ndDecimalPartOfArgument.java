package ru.gb.course1.androidl2layoutscalculatorhw.domain.states;

import java.util.ArrayList;
import java.util.List;

import ru.gb.course1.androidl2layoutscalculatorhw.domain.entities.InputSymbol;

public class Input2ndDecimalPartOfArgument extends BaseState {

    public Input2ndDecimalPartOfArgument(List<InputSymbol> input, List<InputSymbol> input1, float arg, char op) {
        this.input.addAll(input);
        this.input1.addAll(input1);
        this.arg1 = arg;
        this.operation = op;
    }

    @Override
    public BaseState onClickButton(InputSymbol inputSymbol) {
        switch (inputSymbol) {
            case ZERO_DIGIT:
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
                input1.add(inputSymbol);
                return this;
            case ADD_OPERATION:
            case DIVIDE_OPERATION:
            case MULTIPL_OPERATION:
            case SUBSTRACT_OPERATION:
                arg2 = Float.parseFloat(convertResultSymbolToString(input1));
                if (operation == '/') {
                    if (calculateResult(arg1, arg2, operation)) {
                        totalResult = 0.0f;
                        arg1 = 0.0f;
                        arg2 = 0.0f;
                        textString = "";
                        operation = ' ';
                        input = new ArrayList<>();
                        input.add(InputSymbol.DIVIDE_BY_ZERO);
                        return new Input1stArgument(input);
                    }
                } else calculateResult(arg1, arg2, operation);
                input = new ArrayList<>();
                input = convertResultStringToInputSymbols(String.valueOf(totalResult));
                arg1 = totalResult;
                input.add(inputSymbol);
                textString = convertResultSymbolToString(input);
                operation = textString.charAt(textString.length() - 1);
                return new Input2ndArgument(input, arg1, operation);
            case INVERSION_OPERATION:
                if (Float.parseFloat(convertResultSymbolToString(input1)) == 0.0f);
                else if (Float.parseFloat(convertResultSymbolToString(input1)) >= 0.0f)
                    input1.add(0, InputSymbol.SUBSTRACT_OPERATION);
                else input1.remove(0);
                input = new ArrayList<>();
                input.addAll(input1);
                break;
            case PERFORM_CALC:
                arg2 = Float.parseFloat(convertResultSymbolToString(input1));
                if (operation == '/') {
                    if (calculateResult(arg1, arg2, operation)) {
                        totalResult = 0.0f;
                        arg1 = 0.0f;
                        arg2 = 0.0f;
                        textString = "";
                        operation = ' ';
                        input = new ArrayList<>();
                        input.add(inputSymbol.DIVIDE_BY_ZERO);
                        return new Input1stArgument(input);
                    }
                } else calculateResult(arg1, arg2, operation);
                input = new ArrayList<>();
                textString = String.valueOf(totalResult);
                input = convertResultStringToInputSymbols(String.valueOf(totalResult));
                arg1 = totalResult;
                return new InputAfterEqualsOperation(input, arg1);
            case CLEAR_LAST_SYMBOL_OPERATION:
                if (!input1.isEmpty()) input1.remove(input1.size() - 1);
                input = new ArrayList<>();
                input.addAll(input1);
                break;
            case CLEAR_ALL_OPERATION:
                return new Input1stArgument();
            case SQRT_OPERATION:
                arg2 = Float.parseFloat(convertResultSymbolToString(input1));
                arg2 *= arg2;
                input = convertResultStringToInputSymbols(String.valueOf(arg2));
                input1 = convertResultStringToInputSymbols(String.valueOf(arg2));
                break;
        }
        return this;
    }
}
