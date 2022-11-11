package com.example.fitnessapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import com.example.fitnessapp.R;
import com.example.fitnessapp.helper.CsvWriter;
import com.example.fitnessapp.model.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

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

//                try {
//                    FileWriter fileWriter = new FileWriter("/Users/quocbaonguyenluu/Desktop/fitness-app/app/src/main/java/com/example/fitnessapp/data/user.txt");
//                    fileWriter.write(user.getName());
//                    fileWriter.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }

                String fileName = "data.txt";
                String fileContent = "avsrfe";
                FileOutputStream fileOutputStream;

                try {
                    fileOutputStream = openFileOutput(fileName, Context.MODE_APPEND);
                    fileOutputStream.write(fileContent.getBytes(StandardCharsets.UTF_8));
                    fileOutputStream.close();
                    System.out.println("Write success");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}