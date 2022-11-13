package com.example.fitnessapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.fitnessapp.R;

public class MealDetailActivity extends AppCompatActivity {

    private RelativeLayout imgView;
    private TextView mealName;

    private TextView ingredient1Name;
    private TextView ingredient2Name;
    private TextView ingredient3Name;

    private TextView ingredient1Calo;
    private TextView ingredient2Calo;
    private TextView ingredient3Calo;

    private TextView totalCalories;

    private Button chooseMealBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_detail);

        initComponent();
    }

    private void initComponent() {
        chooseMealBtn = findViewById(R.id.chooseMealBtn);
        imgView = findViewById(R.id.detailMealImg);
        mealName = findViewById(R.id.detailMealNameTxt);

        ingredient1Name = findViewById(R.id.ingredient1Name);
        ingredient1Calo = findViewById(R.id.ingredient1Calo);

        ingredient2Name = findViewById(R.id.ingredient2Name);
        ingredient2Calo = findViewById(R.id.ingredient2Calo);

        ingredient3Name = findViewById(R.id.ingredient3Name);
        ingredient3Calo = findViewById(R.id.ingredient3Calo);

        totalCalories = findViewById(R.id.detailCaloTxt);


        mealName.setText(getIntent().getExtras().getString("name"));
        ingredient1Name.setText(getIntent().getExtras().getString("ingredient1Name") + ": ");
        ingredient2Name.setText(getIntent().getExtras().getString("ingredient2Name") + ": ");
        ingredient3Name.setText(getIntent().getExtras().getString("ingredient3Name") + ": ");

        ingredient1Calo.setText(getIntent().getExtras().getDouble("ingredient1Calo") + " calories");
        ingredient2Calo.setText(getIntent().getExtras().getDouble("ingredient2Calo") + " calories");
        ingredient3Calo.setText(getIntent().getExtras().getDouble("ingredient3Calo") + " calories");

        totalCalories.setText(getIntent().getExtras().getDouble("totalCalo") + " calories");


        Resources res = getResources(); //resource handle
        Drawable drawable = res.getDrawable(getIntent().getExtras().getInt("img")); //new Image that was added to the res folder

        imgView.setBackground(drawable);
    }

    public void onChooseMealBtnClick(View v) {
        Intent intent = new Intent(MealDetailActivity.this, MealActivity.class);
        setResult(RESULT_OK, intent);
        finish();
    }
}