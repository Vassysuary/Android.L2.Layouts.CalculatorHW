package ru.gb.course1.androidl2layoutscalculatorhw.domain.states;

import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ru.gb.course1.androidl2layoutscalculatorhw.domain.entities.InputSymbol;

public class CalculatorOnStateMachine {

    private BaseState currentState = new Input1stArgument();

    public void onClickButton(InputSymbol inputSymbol) {
        BaseState newState = currentState.onClickButton(inputSymbol);
        currentState = newState;
    }

    public List<InputSymbol> getInput() {
        return new ArrayList<>(currentState.getInput());
    }
}


