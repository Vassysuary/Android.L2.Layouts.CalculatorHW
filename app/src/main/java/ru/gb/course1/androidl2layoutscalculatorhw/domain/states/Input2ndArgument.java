package ru.gb.course1.androidl2layoutscalculatorhw.domain.states;

import java.util.ArrayList;
import java.util.List;

import ru.gb.course1.androidl2layoutscalculatorhw.domain.entities.InputSymbol;

public class Input2ndArgument extends BaseState {


    public Input2ndArgument() {}

    public Input2ndArgument(List<InputSymbol> input, float arg, char op) {
        this.input.addAll(input);
        this.arg1 = arg;
        this.operation = op;
    }

    @Override
    public BaseState onClickButton(InputSymbol inputSymbol) {
        input1 = new ArrayList<>();
        switch (inputSymbol) {
            case ZERO_DIGIT:
                input.add(inputSymbol);
                input1.add(inputSymbol);
                return new Input2ndArgumentAfterZero(input, input1, arg1, operation);
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
                return new Input2ndIntegerPartOfArgument(input, input1, arg1, operation);
            case DEC_POINT:
                input.add(InputSymbol.ZERO_DIGIT);
                input1.add(InputSymbol.ZERO_DIGIT);
                input.add(InputSymbol.DEC_POINT);
                input1.add(InputSymbol.DEC_POINT);
                return new Input2ndDecimalPartOfArgument(input, input1, arg1, operation);
            case CLEAR_ALL_OPERATION:
                return new Input1stArgument();
        }
        return this;
    }
}
