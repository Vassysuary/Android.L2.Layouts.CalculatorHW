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
import ru.gb.course1.androidl2layoutscalculatorhw.domain.states.CalculatorOnStateMachine;

public class MainActivity extends AppCompatActivity {

    public int countArgs = 0;
    private float arg1 = 0.0f, arg2 = 0.0f, totalResult = 0.0f;
    private String argument = "", textString = "";
    private char operation = ' ';
    private boolean afterEquals = true;
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
    public CalculatorOnStateMachine calculatorOnStateMachine = new CalculatorOnStateMachine();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        initView();
        initListeners();
        findViewById(R.id.open_new_activity_with_big_digits).setOnClickListener(view -> {
            Intent intent = new Intent(this, BigDigitActivity.class);
            initialSaveData();
            intent.putExtra(BigDigitActivity.HASH_FOR_VALUE_KEY, savedDatas);
            startActivity(intent);
        });

//        operationMultiplicationButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                calculator.OperationMultiplication();
//            }
//        });
//        operationSubtractionButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                calculator.OperationSubtraction();
//            }
//        });
//        operationAdditionButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                calculator.OperationAddition();
//            }
//        });
//        operationDivideButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                calculator.OperationDivide();
//            }
//        });
//        performCalculationButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                calculator.PerformCalculation();
//            }
//        });
//        clearAllButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                calculator.ClearAll();
//            }
//        });
//        clearLastDigitOrSymbolButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                calculator.ClearLastDigitOrSymbol();
//            }
//        });
//        operationSqrtButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                calculator.OperationSqrt();
//            }
//        });
//        operationCubeButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                calculator.OperationCube();
//            }
//        });
//        digitOneButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                calculator.DigitOne();
//            }
//        });
//        digitTwoButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                calculator.DigitTwo();
//            }
//        });
//        digitThreeButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                calculator.DigitThree();
//            }
//        });
//        digitFourButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                calculator.DigitFour();
//            }
//        });
//        digitFiveButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                calculator.DigitFive();
//            }
//        });
//        digitSixButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                calculator.DigitSix();
//            }
//        });
//        digitSevenButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                calculator.DigitSeven();
//            }
//        });
//        digitEightButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                calculator.DigitEight();
//            }
//        });
//        digitNineButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                calculator.DigitNine();
//            }
//        });
//        digitZeroButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                calculator.DigitZero();
//
//            }
//        });
//        decimalPointButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                calculator.DecimalPoint();
//            }
//        });
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
        countArgs = savedData.countArgsSave;
        arg1 = savedData.arg1Save;
        arg2 = savedData.arg2Save;
        totalResult = savedData.totalResultSave;
        argument = savedData.argumentSave;
        textString = savedData.textStringSave;
        operation = savedData.operationSave;
        afterEquals = savedData.afterEqualsSave;
        resultTextView.setText(textString);
    }

    private void initView() {
        resultTextView = findViewById(R.id.result_text_view);
        calculatorOnStateMachine.resultTextViewCalc = findViewById(R.id.result_text_view);
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
//        List<InputSymbol> inputSymbolList = calculatorOnStateMachine.getInput();
//        resultTextView.setText(convertResultSymbolToString(inputSymbolList));
    }

//    private String convertResultSymbolToString(List<InputSymbol> inputSymbolList) {
//        final StringBuilder sb = new StringBuilder();
//        for (InputSymbol inputSymbol : inputSymbolList) {
//            switch (inputSymbol) {
//                case ZERO_DIGIT:
//                    sb.append("@string/symbol_zero_on_button");
//                    break;
//                case ONE_DIGIT:
//                    sb.append("@string/symbol_one_on_button");
//                    break;
//                case TWO_DIGIT:
//                    sb.append("@string/symbol_two_on_button");
//                    break;
//                case THREE_DIGIT:
//                    sb.append("@string/symbol_three_on_button");
//                    break;
//                case FOUR_DIGIT:
//                    sb.append("@string/symbol_four_on_button");
//                    break;
//                case FIVE_DIGIT:
//                    sb.append("@string/symbol_five_on_button");
//                    break;
//                case SIX_DIGIT:
//                    sb.append("@string/symbol_six_on_button");
//                    break;
//                case SEVEN_DIGIT:
//                    sb.append("@string/symbol_seven_on_button");
//                    break;
//                case EIGHT_DIGIT:
//                    sb.append("@string/symbol_eight_on_button");
//                    break;
//                case NINE_DIGIT:
//                    sb.append("@string/symbol_nine_on_button");
//                    break;
//                default:
//                    sb.append("@");
//                    break;
//            }
//        }
//        return sb.toString();
//    }

    private void initialSaveData() {
        savedDatas.countArgsSave = countArgs;
        savedDatas.arg1Save = arg1;
        savedDatas.arg2Save = arg2;
        savedDatas.totalResultSave = totalResult;
        savedDatas.argumentSave = argument;
        savedDatas.textStringSave = textString;
        savedDatas.operationSave = operation;
        savedDatas.afterEqualsSave = afterEquals;
    }
}