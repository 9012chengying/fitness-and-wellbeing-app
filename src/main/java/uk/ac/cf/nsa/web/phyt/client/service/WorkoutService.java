/*package uk.ac.cf.nsa.web.phyt.workouts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.ac.cf.nsa.web.phyt.workouts.DTO.WorkoutDTO;
import uk.ac.cf.nsa.web.phyt.workouts.DTO.WorkoutExercisesDTO;
import uk.ac.cf.nsa.web.phyt.workouts.DTO.WorkoutSummaryDTO;
import uk.ac.cf.nsa.web.phyt.workouts.repository.WorkoutRepository;

import java.util.List;

@Service
public class WorkoutService {

    private WorkoutRepository workoutRepository;

    @Autowired
    public WorkoutService(WorkoutRepository pRepo) {
        workoutRepository = pRepo;
    }

    public List<WorkoutDTO> allExercisesInWorkout(int workoutID) {
        List<WorkoutExercisesDTO> workoutCategories = workoutRepository.workoutExerciseDetails(workoutID);
        for(int i = 0; i < workoutCategories.size(); i++) {
            WorkoutSummaryDTO workoutSummaryDTO = workoutCategories
        }
        return workoutCategories;
    }

}
*/