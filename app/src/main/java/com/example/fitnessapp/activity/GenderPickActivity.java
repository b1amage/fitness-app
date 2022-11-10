package com.example.fitnessapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioGroup;

import com.example.fitnessapp.R;

public class GenderPickActivity extends AppCompatActivity {
    private RadioGroup genderRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender_pick);
        genderRadioGroup = findViewById(R.id.genderRadio);

        genderRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                switch(checkedId){
                    case R.id.radioMale:
                        // do operations specific to this selection
                        System.out.println("Male");
                        break;
                    case R.id.radioFemale:
                        System.out.println("Female");
                        // do operations specific to this selection
                        break;
                }
            }
        });
    }


}