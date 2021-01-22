package uk.ac.cf.nsa.web.phyt.trainer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.cf.nsa.web.phyt.exercises.data.repository.ExerciseRepository;
import uk.ac.cf.nsa.web.phyt.trainer.forms.WorkoutDetailsForm;
import uk.ac.cf.nsa.web.phyt.trainer.repository.TrainerWorkoutRepository;
import uk.ac.cf.nsa.web.phyt.users.data.DTO.UserEntity;
import uk.ac.cf.nsa.web.phyt.users.service.UserService;

@Controller
@RequestMapping(path="trainer/workout/create")
public class TrainerWorkoutController {

    private ExerciseRepository exerciseRepo;
    private TrainerWorkoutRepository trainerWorkoutRepository;
    private UserService userService;

    @Autowired
    public TrainerWorkoutController(ExerciseRepository exerciseRepo, TrainerWorkoutRepository trainerWorkoutRepository, UserService userService) {
        this.exerciseRepo = exerciseRepo;
        this.trainerWorkoutRepository = trainerWorkoutRepository;
        this.userService = userService;
    }

    @GetMapping(path="")
    public ModelAndView detailsForm() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("CreateWorkoutDetails");
        return mav;
    }

    @PostMapping(path="/submitDetails")
    public ModelAndView addWorkout(WorkoutDetailsForm workoutDetailsForm, BindingResult br) {
        ModelAndView mav = new ModelAndView();
        if (br.hasErrors()) {
            System.out.println(br.toString());
            mav.setViewName("CreateWorkoutDetails");
        } else
            if (trainerWorkoutRepository.addWorkout(workoutDetailsForm)) {
                System.out.println("Workout added to database");
                mav.setViewName("CreateWorkoutExercises");
            } else {
                System.out.println("Not added to database");
                mav.setViewName("CreateWorkoutDetails");
            }
            return mav;
    }

    @GetMapping(path="/exercises") //uses last workoutID
    public ModelAndView viewExercises() {
        ModelAndView mav = new ModelAndView();
        UserEntity currentUser = userService.authenticateUser();
        int userID = currentUser.getUserId();
        mav.addObject("exercises", exerciseRepo.getAllExercises(userID));
        mav.setViewName("CreateWorkoutExercises");
        return mav;
    }



}
