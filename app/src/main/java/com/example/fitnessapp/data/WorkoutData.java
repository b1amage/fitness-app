package com.example.fitnessapp.data;

import com.example.fitnessapp.R;
import com.example.fitnessapp.model.Workout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WorkoutData {
    private static List<Workout> workoutList = new ArrayList<>(
            Arrays.asList(
                    new Workout("Basketball", 50, R.drawable.basketball),
                    new Workout("Gym", 60, R.drawable.gym),
                    new Workout("Volleyball", 70, R.drawable.volleyball),
                    new Workout("Yoga", 80, R.drawable.yoga),
                    new Workout("Cardio", 90, R.drawable.cardio),
                    new Workout("Badminton", 100, R.drawable.badminton),
                    new Workout("Tennis", 100, R.drawable.tennis),
                    new Workout("Running", 100, R.drawable.running),
                    new Workout("Cycling", 100, R.drawable.cycling)
            )
    );

    private WorkoutData() {}

    public static List<Workout> getWorkoutList() {
        return  workoutList;
    }

}
