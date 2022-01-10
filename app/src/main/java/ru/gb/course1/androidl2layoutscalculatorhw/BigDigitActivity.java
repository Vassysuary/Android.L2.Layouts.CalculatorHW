package ru.gb.course1.androidl2layoutscalculatorhw;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class BigDigitActivity extends AppCompatActivity {

    public static final String HASH_FOR_VALUE_KEY = "hash_key";
    private Button finishForActivityBigDigitsButton;
    private TextView bigDigits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_big_digit);
        bigDigits = findViewById(R.id.big_digits_textview);
        SavedData savedData = (SavedData) getIntent().getParcelableExtra(HASH_FOR_VALUE_KEY);
        String value_for_screen = savedData.textStringSave;
        if (value_for_screen.isEmpty()) value_for_screen = "0";
        bigDigits.setText(value_for_screen);
        finishForActivityBigDigitsButton = findViewById(R.id.finish_for_activity_big_digits_button);
        finishForActivityBigDigitsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
//        Log.d(TAG, "onCreate() called with: savedInstanceState = [" + savedInstanceState + "]");
    }
}