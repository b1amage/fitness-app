package com.example.fitnessapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.fitnessapp.R;
import com.example.fitnessapp.helper.NumberConverter;

public class BodyIndexInputActivity extends AppCompatActivity {
    private EditText weightEditText;
    private EditText heightEditText;
    private Button bodyIndexNextBtn;
    private TextView weightError;
    private TextView heightError;

    private void initComponent() {
        weightEditText = findViewById(R.id.weightEditText);
        heightEditText = findViewById(R.id.heightEditText);
        bodyIndexNextBtn = findViewById(R.id.bodyIndexNextBtn);
        weightError = findViewById(R.id.weightError);
        heightError = findViewById(R.id.heightError);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body_index_input);

        initComponent();

        bodyIndexNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                weightError.setVisibility(View.GONE);
                heightError.setVisibility(View.GONE);

                String weightString = weightEditText.getText().toString();
                String heightString = heightEditText.getText().toString();
                double weight, height;

                // Check weight
                try {
                    weight = NumberConverter.getDouble(weightString);
                } catch (Exception e){
                    // Error message
                    weightError.setText("Weight is invalid!");
                    weightError.setVisibility(View.VISIBLE);
                    return;
                }

                // Check height
                try {
                    height = NumberConverter.getDouble(heightString);
                } catch (Exception e){
                    // Error message
                    heightError.setText("Height is invalid!");
                    heightError.setVisibility(View.VISIBLE);
                    return;
                }


                char gender = getIntent().getExtras().getChar("gender");
                int age = getIntent().getExtras().getInt("age");
                String name = getIntent().getExtras().getString("name");

                Intent intent = new Intent(BodyIndexInputActivity.this, GoalPickActivity.class);
                intent.putExtra("age", age);
                intent.putExtra("name", name);
                intent.putExtra("gender", gender);
                intent.putExtra("weight", weight);
                intent.putExtra("height", height);

                startActivity(intent);
                finish();
            }
        });
    }
}