package com.example.fitnessapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.fitnessapp.R;
import com.example.fitnessapp.helper.StringChecker;

public class NameInputActivity extends AppCompatActivity {
    private EditText nameEditText;
    private Button nextBtn;
    private TextView nameError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_input);

        nameEditText = findViewById(R.id.nameEditText);
        nextBtn = findViewById(R.id.nameNextBtn);
        nameError = findViewById(R.id.nameError);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameError.setVisibility(View.GONE);
                String name = nameEditText.getText().toString();

                if (StringChecker.containsDigit(name)) {
                    nameError.setText("Name must not contains digit!");
                    nameError.setVisibility(View.VISIBLE);
                    return;
                }

                Intent intent = new Intent(NameInputActivity.this, GenderPickActivity.class);
                intent.putExtra("name", name);
                startActivity(intent);
                finish();
            }
        });
    }
}