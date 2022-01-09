package ru.gb.course1.androidl2layoutscalculatorhw;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class BigDigitActivity extends AppCompatActivity {

    private Button finishForActivityBigDigitsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_big_digit);
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