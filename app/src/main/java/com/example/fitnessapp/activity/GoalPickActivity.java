package com.example.fitnessapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import com.example.fitnessapp.R;

public class GoalPickActivity extends AppCompatActivity {
    private RadioGroup goalRadioGroup;
    private Button nextBtn;
    private String goal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal_pick);

        goal = "loss";

        goalRadioGroup = findViewById(R.id.goalRadio);
        nextBtn = findViewById(R.id.goalNextBtn);

        goalRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                switch(checkedId) {
                    case R.id.radioWeightGain:
                        goal = "gain";
                        break;
                    case R.id.radioWeightLoss:
                        goal="loss";
                        break;
                    case R.id.radioStay:
                        goal = "stay";
                        break;
                }
            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                char gender = getIntent().getExtras().getChar("gender");
                int age = getIntent().getExtras().getInt("age");
                double weight = getIntent().getExtras().getDouble("weight");
                double height = getIntent().getExtras().getDouble("height");
                String name = getIntent().getExtras().getString("name");

                System.out.println("Gender " + gender);
                System.out.println("Age " + age);
                System.out.println("Weight " + weight);
                System.out.println("Height " + height);
                System.out.println("Goal: " + goal);
                System.out.println("Name: " + name);
            }
        });
    }
}