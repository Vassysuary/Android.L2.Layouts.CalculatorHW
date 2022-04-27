package ru.gb.course1.androidl2layoutscalculatorhw;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import ru.gb.course1.androidl2layoutscalculatorhw.domain.entities.InputSymbol;
import ru.gb.course1.androidl2layoutscalculatorhw.domain.states.BaseState;
import ru.gb.course1.androidl2layoutscalculatorhw.domain.states.CalculatorOnStateMachine;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private String resultText = "";
    private TextView resultTextView;
    private Button digitOneButton;
    private Button digitTwoButton;
    private Button digitThreeButton;
    private Button digitFourButton;
    private Button digitFiveButton;
    private Button digitSixButton;
    private Button digitSevenButton;
    private Button digitEightButton;
    private Button digitNineButton;
    private Button digitZeroButton;
    private Button operationMultiplicationButton;
    private Button operationDivideButton;
    private Button operationSubtractionButton;
    private Button operationAdditionButton;
    private Button decimalPointButton;
    private Button performCalculationButton;
    private Button clearLastDigitOrSymbolButton;
    private Button clearAllButton;
    private Button operationSqrtButton;
    private Button operationInversionButton;
    private static final String OUR_RESULT_STRING_KEY = "@@@";
    public SavedData savedDatas = new SavedData();
    private CalculatorOnStateMachine calculatorOnStateMachine;
    public BaseState calculatorBaseState = new BaseState() {
        @Override
        public BaseState onClickButton(InputSymbol inputSymbol) {
            return null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        calculatorOnStateMachine = new CalculatorOnStateMachine();
        initView();
        initListeners();
        Button bigDigit = findViewById(R.id.open_new_activity_with_big_digits);
        bigDigit.setOnClickListener((View.OnClickListener) this);

//        findViewById(R.id.open_new_activity_with_big_digits).setOnClickListener(view -> {
//            Intent intent = new Intent(this, BigDigitActivity.class);
//            initialSaveData();
//            intent.putExtra(BigDigitActivity.HASH_FOR_VALUE_KEY, savedDatas);
//            startActivity(intent);
//        });
    }

    @Override
    public void onClick(View v) {
            Intent intent = new Intent("android.intent.action.bigdigit");
            initialSaveData();
            intent.putExtra(BigDigitActivity.HASH_FOR_VALUE_KEY, savedDatas);
            startActivity(intent);

}

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        initialSaveData();
//        outState.putSerializable(OUR_RESULT_STRING_KEY, savedDatas);
        outState.putParcelable(OUR_RESULT_STRING_KEY, savedDatas);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        SavedData savedData = new SavedData();
//        savedData = (SavedData) savedInstanceState.getSerializable(OUR_RESULT_STRING_KEY);
        savedData = (SavedData) savedInstanceState.getParcelable(OUR_RESULT_STRING_KEY);
//        calculatorBaseState.countArgs = savedData.countArgsSave;
        calculatorBaseState.arg1 = savedData.arg1Save;
        calculatorBaseState.arg2 = savedData.arg2Save;
        calculatorBaseState.totalResult = savedData.totalResultSave;
//        calculatorBaseState.argument = savedData.argumentSave;
        calculatorBaseState.textString = savedData.textStringSave;
        calculatorBaseState.operation = savedData.operationSave;
//        calculatorBaseState.afterEquals = savedData.afterEqualsSave;
        resultTextView.setText(calculatorBaseState.textString);
    }

    private void initView() {
        resultTextView = findViewById(R.id.result_text_view);
        digitOneButton = findViewById(R.id.digit_one_button);
        digitTwoButton = findViewById(R.id.digit_two_button);
        digitThreeButton = findViewById(R.id.digit_three_button);
        digitFourButton = findViewById(R.id.digit_four_button);
        digitFiveButton = findViewById(R.id.digit_five_button);
        digitSixButton = findViewById(R.id.digit_six_button);
        digitSevenButton = findViewById(R.id.digit_seven_button);
        digitEightButton = findViewById(R.id.digit_eight_button);
        digitNineButton = findViewById(R.id.digit_nine_button);
        digitZeroButton = findViewById(R.id.digit_zero_button);
        operationMultiplicationButton = findViewById(R.id.operation_multiplication_button);
        operationDivideButton = findViewById(R.id.operation_divide_button);
        operationSubtractionButton = findViewById(R.id.operation_subtraction_button);
        operationAdditionButton = findViewById(R.id.operation_addition_button);
        decimalPointButton = findViewById(R.id.decimal_point_button);
        performCalculationButton = findViewById(R.id.perform_calculation_button);
        clearLastDigitOrSymbolButton = findViewById(R.id.clear_last_digit_or_symbol_button);
        clearAllButton = findViewById(R.id.clear_all_button);
        operationSqrtButton = findViewById(R.id.operation_sqrt_button);
        operationInversionButton = findViewById(R.id.operation_inversion_button);
    }

    private void initListeners() {
        digitOneButton.setOnClickListener(v -> updateInput(InputSymbol.ONE_DIGIT));
        digitTwoButton.setOnClickListener(v -> updateInput(InputSymbol.TWO_DIGIT));
        digitThreeButton.setOnClickListener(v -> updateInput(InputSymbol.THREE_DIGIT));
        digitFourButton.setOnClickListener(v -> updateInput(InputSymbol.FOUR_DIGIT));
        digitFiveButton.setOnClickListener(v -> updateInput(InputSymbol.FIVE_DIGIT));
        digitSixButton.setOnClickListener(v -> updateInput(InputSymbol.SIX_DIGIT));
        digitSevenButton.setOnClickListener(v -> updateInput(InputSymbol.SEVEN_DIGIT));
        digitEightButton.setOnClickListener(v -> updateInput(InputSymbol.EIGHT_DIGIT));
        digitNineButton.setOnClickListener(v -> updateInput(InputSymbol.NINE_DIGIT));
        digitZeroButton.setOnClickListener(v -> updateInput(InputSymbol.ZERO_DIGIT));
        operationMultiplicationButton.setOnClickListener(v -> updateInput(InputSymbol.MULTIPL_OPERATION));
        operationDivideButton.setOnClickListener(v -> updateInput(InputSymbol.DIVIDE_OPERATION));
        operationSubtractionButton.setOnClickListener(v -> updateInput(InputSymbol.SUBSTRACT_OPERATION));
        operationAdditionButton.setOnClickListener(v -> updateInput(InputSymbol.ADD_OPERATION));
        operationInversionButton.setOnClickListener(v -> updateInput(InputSymbol.INVERSION_OPERATION));
        operationSqrtButton.setOnClickListener(v -> updateInput(InputSymbol.SQRT_OPERATION));
        decimalPointButton.setOnClickListener(v -> updateInput(InputSymbol.DEC_POINT));
        performCalculationButton.setOnClickListener(v -> updateInput(InputSymbol.PERFORM_CALC));
        clearAllButton.setOnClickListener(v -> updateInput(InputSymbol.CLEAR_ALL_OPERATION));
        clearLastDigitOrSymbolButton.setOnClickListener(v -> updateInput(InputSymbol.CLEAR_LAST_SYMBOL_OPERATION));
    }

    private void updateInput(InputSymbol inputSymbol) {
        calculatorOnStateMachine.onClickButton(inputSymbol);
        List<InputSymbol> inputSymbolList = calculatorOnStateMachine.getInput();
        resultText = calculatorBaseState.convertResultSymbolToString(inputSymbolList);
        if (resultText.isEmpty()) resultText = "0";
        calculatorBaseState.textString = resultText;
        resultTextView.setText(resultText);
    }

    private void initialSaveData() {
//        savedDatas.countArgsSave = calculatorBaseState.countArgs;
        savedDatas.arg1Save = calculatorBaseState.arg1;
        savedDatas.arg2Save = calculatorBaseState.arg2;
        savedDatas.totalResultSave = calculatorBaseState.totalResult;
//        savedDatas.argumentSave = calculatorBaseState.argument;
        savedDatas.textStringSave = calculatorBaseState.textString;
        savedDatas.operationSave = calculatorBaseState.operation;
//        savedDatas.afterEqualsSave = calculatorBaseState.afterEquals;
    }
}