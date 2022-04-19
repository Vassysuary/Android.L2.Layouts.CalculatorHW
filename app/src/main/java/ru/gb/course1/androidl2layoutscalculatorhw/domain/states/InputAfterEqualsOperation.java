package ru.gb.course1.androidl2layoutscalculatorhw.domain.states;

import java.util.ArrayList;
import java.util.List;

import ru.gb.course1.androidl2layoutscalculatorhw.domain.entities.InputSymbol;

public class InputAfterEqualsOperation extends BaseState {


    public InputAfterEqualsOperation() {}

    public InputAfterEqualsOperation(List<InputSymbol> input, float arg) {
        this.input.addAll(input);
        this.arg1 = arg;
    }

    @Override
    public BaseState onClickButton(InputSymbol inputSymbol) {
        switch (inputSymbol) {
            case ZERO_DIGIT:
                input = new ArrayList<>();
                input.add(inputSymbol);
                return new Input1stArgumentAfterZero(input);
            case ONE_DIGIT:
            case TWO_DIGIT:
            case THREE_DIGIT:
            case FOUR_DIGIT:
            case FIVE_DIGIT:
            case SIX_DIGIT:
            case SEVEN_DIGIT:
            case EIGHT_DIGIT:
            case NINE_DIGIT:
                input = new ArrayList<>();
                input.add(inputSymbol);
                return new Input1stIntegerPartOfArgument(input);
            case DEC_POINT:
                input = new ArrayList<>();
                input.add(InputSymbol.ZERO_DIGIT);
                input.add(InputSymbol.DEC_POINT);
                return new Input1stDecimalPartOfArgument(input);
            case INVERSION_OPERATION:
                if (Float.parseFloat(convertResultSymbolToString(input)) >= 0.0f)
                    input.add(0, InputSymbol.SUBSTRACT_OPERATION);
                else input.remove(0);
                break;
            case CLEAR_LAST_SYMBOL_OPERATION:
                if (!input.isEmpty()) {
                    input.remove(input.size() - 1);
                    arg1 = Float.parseFloat(convertResultSymbolToString(input));
                }
                break;
            case ADD_OPERATION:
            case DIVIDE_OPERATION:
            case MULTIPL_OPERATION:
            case SUBSTRACT_OPERATION:
                input.add(inputSymbol);
                textString = convertResultSymbolToString(input);
                operation = textString.charAt(textString.length()-1);
                return new Input2ndArgument(input, arg1, operation);
            case CLEAR_ALL_OPERATION:
                return new Input1stArgument();
            case SQRT_OPERATION:
                arg1 *= arg1;
                input = convertResultStringToInputSymbols(String.valueOf(arg1));
                break;
        }
        return this;
    }
}
