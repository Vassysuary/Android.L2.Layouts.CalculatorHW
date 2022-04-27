package ru.gb.course1.androidl2layoutscalculatorhw.domain.states;

import java.util.List;

import ru.gb.course1.androidl2layoutscalculatorhw.domain.entities.InputSymbol;

public class Input1stIntegerPartOfArgument extends BaseState {

    public Input1stIntegerPartOfArgument(List<InputSymbol> input) {
        this.input.addAll(input);
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
                return this;
            case DEC_POINT:
                input.add(InputSymbol.DEC_POINT);
                return new Input1stDecimalPartOfArgument(input);
            case ADD_OPERATION:
            case DIVIDE_OPERATION:
            case MULTIPL_OPERATION:
            case SUBSTRACT_OPERATION:
                arg1 = Float.parseFloat(convertResultSymbolToString(input));
                input.add(inputSymbol);
                textString = convertResultSymbolToString(input);
                operation = textString.charAt(textString.length() - 1);
                return new Input2ndArgument(input, arg1, operation);
            case INVERSION_OPERATION:
                if (Float.parseFloat(convertResultSymbolToString(input)) >= 0.0f)
                    input.add(0, InputSymbol.SUBSTRACT_OPERATION);
                else input.remove(0);
                break;
            case CLEAR_LAST_SYMBOL_OPERATION:
                if (!input.isEmpty()) input.remove(input.size() - 1);
                break;
            case CLEAR_ALL_OPERATION:
                return new Input1stArgument();
            case SQRT_OPERATION:
                arg1 = Float.parseFloat(convertResultSymbolToString(input));
                arg1 *= arg1;
                input = convertResultStringToInputSymbols(String.valueOf(arg1));
                break;
        }
        return this;
    }
}
