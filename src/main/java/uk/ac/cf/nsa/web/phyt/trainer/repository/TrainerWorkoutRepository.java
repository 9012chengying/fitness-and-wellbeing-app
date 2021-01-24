package uk.ac.cf.nsa.web.phyt.trainer.repository;

import uk.ac.cf.nsa.web.phyt.trainer.forms.WorkoutDetailsForm;
import uk.ac.cf.nsa.web.phyt.trainer.forms.WorkoutExercisesForm;

public interface TrainerWorkoutRepository {

    public boolean addWorkout(WorkoutDetailsForm workoutDetailsForm);
    public Object clientUsernameByTrainerID(int trainerID);
    public Object allWorkouts(int trainerID);
    public boolean addExercise(WorkoutExercisesForm workoutExercisesForm);

}
