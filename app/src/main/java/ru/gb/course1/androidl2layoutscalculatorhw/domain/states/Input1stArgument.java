package ru.gb.course1.androidl2layoutscalculatorhw.domain.states;

import java.util.ArrayList;
import java.util.List;

import ru.gb.course1.androidl2layoutscalculatorhw.domain.entities.InputSymbol;

public class Input1stArgument extends BaseState {


    public Input1stArgument() {}

    public Input1stArgument(List<InputSymbol> input) {
        this.input.addAll(input);
    }

    @Override
    public BaseState onClickButton(InputSymbol inputSymbol) {
        input = new ArrayList<>();
        switch (inputSymbol) {
            case ZERO_DIGIT:
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
                input.add(inputSymbol);
                return new Input1stIntegerPartOfArgument(input);
            case DEC_POINT:
                input.add(InputSymbol.ZERO_DIGIT);
                input.add(InputSymbol.DEC_POINT);
                return new Input1stDecimalPartOfArgument(input);
        }
        return this;
    }
}
