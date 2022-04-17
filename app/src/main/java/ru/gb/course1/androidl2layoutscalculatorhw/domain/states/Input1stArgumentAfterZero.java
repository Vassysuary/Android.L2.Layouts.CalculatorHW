package ru.gb.course1.androidl2layoutscalculatorhw.domain.states;

import java.util.ArrayList;
import java.util.List;

import ru.gb.course1.androidl2layoutscalculatorhw.domain.entities.InputSymbol;

public class Input1stArgumentAfterZero extends BaseState {


    public Input1stArgumentAfterZero() {}

    public Input1stArgumentAfterZero(List<InputSymbol> input) {
        this.input.addAll(input);
    }

    @Override
    public BaseState onClickButton(InputSymbol inputSymbol) {
        switch (inputSymbol) {
            case ONE_DIGIT:
            case TWO_DIGIT:
            case THREE_DIGIT:
            case FOUR_DIGIT:
            case FIVE_DIGIT:
            case SIX_DIGIT:
            case SEVEN_DIGIT:
            case EIGHT_DIGIT:
            case NINE_DIGIT:
                input.remove(input.size() - 1);
                input.add(inputSymbol);
                return new Input1stIntegerPartOfArgument(input);
            case DEC_POINT:
                input.add(InputSymbol.DEC_POINT);
                return new Input1stDecimalPartOfArgument(input);
            case CLEAR_ALL_OPERATION:
                return new Input1stArgument();
            case CLEAR_LAST_SYMBOL_OPERATION:
                input.remove(input.size() - 1);
                return new Input1stArgument();
        }
        return this;
    }
}
