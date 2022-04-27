package ru.gb.course1.androidl2layoutscalculatorhw.domain.states;

import static ru.gb.course1.androidl2layoutscalculatorhw.domain.entities.InputSymbol.ADD_OPERATION;
import static ru.gb.course1.androidl2layoutscalculatorhw.domain.entities.InputSymbol.DEC_POINT;
import static ru.gb.course1.androidl2layoutscalculatorhw.domain.entities.InputSymbol.DIVIDE_OPERATION;
import static ru.gb.course1.androidl2layoutscalculatorhw.domain.entities.InputSymbol.EIGHT_DIGIT;
import static ru.gb.course1.androidl2layoutscalculatorhw.domain.entities.InputSymbol.FIVE_DIGIT;
import static ru.gb.course1.androidl2layoutscalculatorhw.domain.entities.InputSymbol.FOUR_DIGIT;
import static ru.gb.course1.androidl2layoutscalculatorhw.domain.entities.InputSymbol.MULTIPL_OPERATION;
import static ru.gb.course1.androidl2layoutscalculatorhw.domain.entities.InputSymbol.NINE_DIGIT;
import static ru.gb.course1.androidl2layoutscalculatorhw.domain.entities.InputSymbol.ONE_DIGIT;
import static ru.gb.course1.androidl2layoutscalculatorhw.domain.entities.InputSymbol.SEVEN_DIGIT;
import static ru.gb.course1.androidl2layoutscalculatorhw.domain.entities.InputSymbol.SIX_DIGIT;
import static ru.gb.course1.androidl2layoutscalculatorhw.domain.entities.InputSymbol.SUBSTRACT_OPERATION;
import static ru.gb.course1.androidl2layoutscalculatorhw.domain.entities.InputSymbol.THREE_DIGIT;
import static ru.gb.course1.androidl2layoutscalculatorhw.domain.entities.InputSymbol.TWO_DIGIT;
import static ru.gb.course1.androidl2layoutscalculatorhw.domain.entities.InputSymbol.ZERO_DIGIT;

import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ru.gb.course1.androidl2layoutscalculatorhw.MainActivity;
import ru.gb.course1.androidl2layoutscalculatorhw.domain.entities.InputSymbol;

abstract public class BaseState {

    public float arg1 = 0.0f, arg2 = 0.0f, totalResult = 0.0f;
    public String textString = "";
    public char operation = ' ';

    protected List<InputSymbol> input = new ArrayList<>();
    protected List<InputSymbol> input1 = new ArrayList<>();

    public abstract BaseState onClickButton(InputSymbol inputSymbol);

    public List<InputSymbol> getInput() {
        return new ArrayList<>(input);
    }

    public String convertResultSymbolToString(List<InputSymbol> inputSymbolList) {
        final StringBuilder sb = new StringBuilder();
        for (InputSymbol inputSymbol : inputSymbolList) {
            switch (inputSymbol) {
                case ZERO_DIGIT:
                    sb.append("0");
                    break;
                case ONE_DIGIT:
                    sb.append("1");
//                    sb.append("@string/symbol_one_on_button");            эта тема не работает! ((
                    break;
                case TWO_DIGIT:
                    sb.append("2");
                    break;
                case THREE_DIGIT:
                    sb.append("3");
                    break;
                case FOUR_DIGIT:
                    sb.append("4");
                    break;
                case FIVE_DIGIT:
                    sb.append("5");
                    break;
                case SIX_DIGIT:
                    sb.append("6");
                    break;
                case SEVEN_DIGIT:
                    sb.append("7");
                    break;
                case EIGHT_DIGIT:
                    sb.append("8");
                    break;
                case NINE_DIGIT:
                    sb.append("9");
                    break;
                case DEC_POINT:
                    sb.append(".");
                    break;
                case ADD_OPERATION:
                    sb.append("+");
                    break;
                case DIVIDE_OPERATION:
                    sb.append("/");
                    break;
                case MULTIPL_OPERATION:
                    sb.append("*");
                    break;
                case SUBSTRACT_OPERATION:
                    sb.append("-");
                    break;
                case PERFORM_CALC:
                    sb.append("=");
                    break;
                case CLEAR_ALL_OPERATION:
                    sb.append("C");
                    break;
                case DIVIDE_BY_ZERO:
                    sb.append("Нельзя делить на ноль!");
                    break;
                default:
                    sb.append("@");
                    break;
            }
        }
        if (sb.toString().equals("-")) return "0";
        else return sb.toString();
    }

    public List<InputSymbol> convertResultStringToInputSymbols(String str) {
        final StringBuilder sb = new StringBuilder();
        List<InputSymbol> inp = new ArrayList<>();
        for (int i = 0; i< str.length(); i++) {
            String s = str.substring(i,i+1);
            switch (str.substring(i,i+1)) {
                case "0":
                    inp.add(ZERO_DIGIT);
                    break;
                case "1":
                    inp.add(ONE_DIGIT);
                    break;
                case "2":
                    inp.add(TWO_DIGIT);
                    break;
                case "3":
                    inp.add(THREE_DIGIT);
                    break;
                case "4":
                    inp.add(FOUR_DIGIT);
                    break;
                case "5":
                    inp.add(FIVE_DIGIT);
                    break;
                case "6":
                    inp.add(SIX_DIGIT);
                    break;
                case "7":
                    inp.add(SEVEN_DIGIT);
                    break;
                case "8":
                    inp.add(EIGHT_DIGIT);
                    break;
                case "9":
                    inp.add(NINE_DIGIT);
                    break;
                case ".":
                    inp.add(DEC_POINT);
                    break;
                case "+":
                    inp.add(ADD_OPERATION);
                    break;
                case "/":
                    inp.add(DIVIDE_OPERATION);
                    break;
                case "*":
                    inp.add(MULTIPL_OPERATION);
                    break;
                case "-":
                    inp.add(SUBSTRACT_OPERATION);
                    break;
            }
        }
        return inp;
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
                if (Math.abs(a2) < 0.0000000001f) {
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
}
