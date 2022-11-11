package com.example.fitnessapp.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.fitnessapp.model.Workout;

import java.util.List;

public class WorkoutAdapter extends BaseAdapter {
    private List<Workout> workouts;

    public WorkoutAdapter(List<Workout> workouts) {
        this.workouts = workouts;
    }

    @Override
    public int getCount() {
        return workouts.size();
    }

    @Override
    public Object getItem(int i) {
        return workouts.get(i);
    }

    @Override
    public long getItemId(int i) {
        return workouts.get(i).getId();
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        return null;
    }
}
