package com.example.fitnessapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.example.fitnessapp.R;

public class AgePickActivity extends AppCompatActivity {

    private NumberPicker numberPicker;
    private Button nextBtn;
    private TextView txtAge;
    private static final int MIN_AGE = 1;
    private static final int MAX_AGE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age_pick);

        txtAge = findViewById(R.id.txtAge);
        txtAge.setText(String.valueOf(1));
        nextBtn = findViewById(R.id.ageNextBtn);
        numberPicker = findViewById(R.id.agePicker);
        numberPicker.setMinValue(MIN_AGE);
        numberPicker.setMaxValue(MAX_AGE);

        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int oldVal, int newVal) {
                txtAge.setText(String.valueOf(newVal));
            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                char gender  = getIntent().getExtras().getChar("gender");
                String name = getIntent().getExtras().getString("name");
                Intent intent = new Intent(AgePickActivity.this, BodyIndexInputActivity.class);
                intent.putExtra("gender", gender);
                intent.putExtra("name", name);
                intent.putExtra("age", Integer.parseInt(txtAge.getText().toString()));
                startActivity(intent);
                finish();
            }
        });
    }
}