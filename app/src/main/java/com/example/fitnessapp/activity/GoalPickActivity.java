package com.example.fitnessapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import com.example.fitnessapp.R;
import com.example.fitnessapp.model.User;


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

                User user = new User(name, age, weight, height, gender, goal);

                // Storing data into SharedPreferences
                SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);

                // Creating an Editor object to edit(write to the file)
                SharedPreferences.Editor myEdit = sharedPreferences.edit();

                // Storing the key and its value as the data fetched from edittext
                myEdit.putBoolean("passFirstTime", true);
                myEdit.putString("name", user.getName());
                myEdit.putInt("age", user.getAge());
                myEdit.putString("goal", user.getGoal());
                myEdit.putString("gender", String.valueOf(user.getGender()));
                myEdit.putFloat("weight", (float) user.getWeight());
                myEdit.putFloat("height", (float) user.getHeight());


                myEdit.commit();

                Intent intent = new Intent(GoalPickActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}