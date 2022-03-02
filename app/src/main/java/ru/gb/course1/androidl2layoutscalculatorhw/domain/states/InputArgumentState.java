package ru.gb.course1.androidl2layoutscalculatorhw.domain.states;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import ru.gb.course1.androidl2layoutscalculatorhw.domain.entities.InputSymbol;

public class InputArgumentState extends BaseState {

    public InputArgumentState(List<InputSymbol> input) {
        this.input.addAll(input);
    }

    @Override
    public BaseState onClickButton(InputSymbol inputSymbol) {
        switch (inputSymbol) {
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
                resultTextViewCalc.setText("1");

//  Вылетает на этом месте!!! Что не нравится?!!
//                resultTextViewCalc.setText(textString);
                break;
            case DEC_POINT:
                input.add(InputSymbol.DEC_POINT);
                return new InputDecimalPartOfArgumentState(input);
            case INVERSION_OPERATION:
            case CLEAR_LAST_SYMBOL_OPERATION:
            case SQRT_OPERATION:
            case ADD_OPERATION:
            case DIVIDE_OPERATION:
            case MULTIPL_OPERATION:
            case SUBSTRACT_OPERATION:
            case CLEAR_ALL_OPERATION:
            case PERFORM_CALC:
                performingAnOperation(inputSymbol);
            default:
                return this;
        }
        return this;
    }
}
