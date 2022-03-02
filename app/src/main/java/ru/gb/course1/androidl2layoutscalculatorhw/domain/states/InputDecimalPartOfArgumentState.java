package ru.gb.course1.androidl2layoutscalculatorhw.domain.states;

import java.util.ArrayList;
import java.util.List;

import ru.gb.course1.androidl2layoutscalculatorhw.domain.entities.InputSymbol;

public class InputDecimalPartOfArgumentState extends BaseState {

    public InputDecimalPartOfArgumentState(List<InputSymbol> input) {
        super();
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

            case ADD_OPERATION:
            case DIVIDE_OPERATION:
            case MULTIPL_OPERATION:
            case SUBSTRACT_OPERATION:
            case INVERSION_OPERATION:
            case CLEAR_LAST_SYMBOL_OPERATION:
            case CLEAR_ALL_OPERATION:
            case SQRT_OPERATION:
            case PERFORM_CALC:
                performingAnOperation(inputSymbol);
            case DEC_POINT:
            default:
                return this;
        }
    }
}
