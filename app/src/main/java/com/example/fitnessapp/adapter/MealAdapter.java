package com.example.fitnessapp.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fitnessapp.R;
import com.example.fitnessapp.model.Dish;
import com.example.fitnessapp.model.Workout;

import java.util.List;

public class MealAdapter extends BaseAdapter {

    private List<Dish> meals;

    public MealAdapter(List<Dish> meals) {
        this.meals = meals;
    }

    @Override
    public int getCount() {
        return meals.size();
    }

    @Override
    public Object getItem(int i) {
        return meals.get(i);
    }

    @Override
    public long getItemId(int i) {
        return meals.get(i).getId();
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        View viewMeal;
        if (convertView == null) {
            viewMeal = View.inflate(parent.getContext(), R.layout.meal, null);
        } else viewMeal = convertView;

        Dish meal = (Dish) getItem(i);

        ((ImageView) viewMeal.findViewById(R.id.mealImg)).setImageResource(meal.getImg());
        ((TextView) viewMeal.findViewById(R.id.txtMealName)).setText(meal.getName());
        ((TextView) viewMeal.findViewById(R.id.txtCalo)).setText(String.valueOf(meal.getCalories()) + " calories");

        return viewMeal;
    }
}
