package com.example.fitnessapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_detail);

        initComponent();
    }

    private void initComponent() {
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
        ingredient1Name.setText(String.format("%s: ", getIntent().getExtras().getString("ingredient1Name")));
        ingredient2Name.setText(String.format("%s: ", getIntent().getExtras().getString("ingredient2Name")));
        ingredient3Name.setText(String.format("%s: ", getIntent().getExtras().getString("ingredient3Name")));

        ingredient1Calo.setText(String.format("%.2f calories", getIntent().getExtras().getDouble("ingredient1Calo")));
        ingredient2Calo.setText(String.format("%.2f calories", getIntent().getExtras().getDouble("ingredient2Calo")));
        ingredient3Calo.setText(String.format("%.2f calories", getIntent().getExtras().getDouble("ingredient3Calo")));

        totalCalories.setText(String.format("%.2f calories", getIntent().getExtras().getDouble("totalCalo")));

        Resources res = getResources(); //resource handle
        Drawable drawable = res.getDrawable(getIntent().getExtras().getInt("img")); //new Image that was added to the res folder

        imgView.setBackground(drawable);
    }

    public void onChooseMealBtnClick(View v) {
        SharedPreferences sh = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sh.edit();
        double caloIn = sh.getFloat("caloIn", 0);
        caloIn += getIntent().getExtras().getDouble("totalCalo");
        myEdit.putFloat("caloIn", (float) caloIn);

        myEdit.commit();

        Intent intent = new Intent(MealDetailActivity.this, MealActivity.class);
        intent.putExtra("totalCalo", getIntent().getExtras().getDouble("totalCalo"));
        setResult(RESULT_OK, intent);
        finish();
    }

    public void onBackBtnClick(View v) {
        Intent intent = new Intent(MealDetailActivity.this, MealActivity.class);
        setResult(RESULT_CANCELED, intent);
        finish();
    }
}