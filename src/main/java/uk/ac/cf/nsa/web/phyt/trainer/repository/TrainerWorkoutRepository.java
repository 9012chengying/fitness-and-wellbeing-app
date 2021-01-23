package uk.ac.cf.nsa.web.phyt.trainer.repository;

import uk.ac.cf.nsa.web.phyt.trainer.forms.WorkoutDetailsForm;

public interface TrainerWorkoutRepository {

    public boolean addWorkout(WorkoutDetailsForm workoutDetailsForm);
    public Object clientUsernameByTrainerID(int trainerID);

}
