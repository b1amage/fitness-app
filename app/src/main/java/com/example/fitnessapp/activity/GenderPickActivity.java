package com.example.fitnessapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import com.example.fitnessapp.R;

public class GenderPickActivity extends AppCompatActivity {
    private RadioGroup genderRadioGroup;
    private Button nextButton;
    private char gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender_pick);

        genderRadioGroup = findViewById(R.id.genderRadio);
        nextButton = findViewById(R.id.genderNextBtn);
        gender = 'm'; // default value: male

        genderRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                switch(checkedId) {
                    case R.id.radioMale:
                        gender = 'm';
                        break;
                    case R.id.radioFemale:
                        gender = 'f';
                        break;
                }
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GenderPickActivity.this, AgePickActivity.class);
                String name = getIntent().getExtras().getString("name");
                intent.putExtra("name", name);
                intent.putExtra("gender", gender);
                startActivity(intent);
                finish();
            }
        });
    }


}