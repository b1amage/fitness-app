package com.example.fitnessapp.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fitnessapp.R;
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
        View viewWorkout;
        if (convertView == null) {
            viewWorkout = View.inflate(parent.getContext(), R.layout.workout, null);
        } else viewWorkout = convertView;

        Workout workout = (Workout) getItem(i);
        ((TextView) viewWorkout.findViewById(R.id.workoutCategory)).setText(workout.getCategory());
        ((ImageView) viewWorkout.findViewById(R.id.workoutImg)).setImageResource(workout.getImage());

        return viewWorkout;
    }
}
