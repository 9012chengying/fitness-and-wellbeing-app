//package uk.ac.cf.nsa.web.phyt.trainer.controllers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.Banner;
//import org.springframework.stereotype.Controller;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.ModelAndView;
//import uk.ac.cf.nsa.web.phyt.client.repository.ClientWorkoutRepository;
//import uk.ac.cf.nsa.web.phyt.exercises.data.repository.ExerciseRepository;
//import uk.ac.cf.nsa.web.phyt.trainer.forms.WorkoutDetailsForm;
//import uk.ac.cf.nsa.web.phyt.trainer.forms.WorkoutExercisesForm;
//import uk.ac.cf.nsa.web.phyt.trainer.repository.TrainerWorkoutRepository;
//import uk.ac.cf.nsa.web.phyt.users.data.DTO.UserEntity;
//import uk.ac.cf.nsa.web.phyt.users.service.UserService;
//
//@Controller
//@RequestMapping(path="trainer/workouts")
//public class TrainerWorkoutController {
//
//    private ExerciseRepository exerciseRepo;
//    private TrainerWorkoutRepository trainerWorkoutRepository;
//    private ClientWorkoutRepository clientWorkoutRepository;
//    private UserService userService;
//
//    @Autowired
//    public TrainerWorkoutController(ExerciseRepository exerciseRepo, TrainerWorkoutRepository trainerWorkoutRepository, ClientWorkoutRepository clientWorkoutRepository, UserService userService) {
//        this.exerciseRepo = exerciseRepo;
//        this.trainerWorkoutRepository = trainerWorkoutRepository;
//        this.clientWorkoutRepository = clientWorkoutRepository;
//        this.userService = userService;
//    }
//
//    @GetMapping(path="/all")
//    public ModelAndView allWorkouts() {
//        ModelAndView mav = new ModelAndView();
//        UserEntity currentUser = userService.authenticateUser();
//        int userID = currentUser.getUserId();
//        System.out.println(userID); //check prints correctly
//        mav.addObject("workouts", trainerWorkoutRepository.allWorkouts(userID));
//        mav.setViewName("AllWorkouts");
//        return mav;
//    }
//
//    @GetMapping(path="/create")
//    public ModelAndView detailsForm() {
//        ModelAndView mav = new ModelAndView();
//        UserEntity currentUser = userService.authenticateUser();
//        int userID = currentUser.getUserId();
//        mav.addObject("clients", trainerWorkoutRepository.clientUsernameByTrainerID(userID));
//        mav.setViewName("CreateWorkoutDetails");
//        return mav;
//    }
//
//    @PostMapping(path="/create/submit") //add message to confirm if successful
//    public ModelAndView addWorkout(WorkoutDetailsForm workoutDetailsForm, BindingResult br) {
//        ModelAndView mav = new ModelAndView();
//        UserEntity currentUser = userService.authenticateUser();
//        int userID = currentUser.getUserId();
//        if (br.hasErrors()) {
//            System.out.println(br.toString());
//            mav.setViewName("CreateWorkoutDetails");
//        } else
//            if (trainerWorkoutRepository.addWorkout(workoutDetailsForm)) {
//                System.out.println("Workout added to database");
//                mav.addObject("workouts", trainerWorkoutRepository.allWorkouts(userID));
//                mav.setViewName("AllWorkouts");
//            } else {
//                System.out.println("Not added to database");
//                mav.setViewName("CreateWorkoutDetails");
//            }
//            return mav;
//    }
//
//    @GetMapping(path="/exercises")
//    public ModelAndView viewExercises(@RequestParam(value="workoutID", defaultValue="null") int workoutID) {
//        ModelAndView mav = new ModelAndView();
//        UserEntity currentUser = userService.authenticateUser();
//        int userID = currentUser.getUserId();
//        mav.addObject("workoutID", workoutID);
//        mav.addObject("exercises", exerciseRepo.getAllExercises(userID));
//        mav.setViewName("CreateWorkoutExercises");
//        return mav;
//    }
//
//    @PostMapping(path="/exercises/submit")
//    public ModelAndView addExercise(WorkoutExercisesForm workoutExerciseForm, BindingResult br) {
//        ModelAndView mav = new ModelAndView();
//        UserEntity currentUser = userService.authenticateUser();
//        int userID = currentUser.getUserId();
//        if (br.hasErrors()) {
//            System.out.println(br.toString()); //need to show message confirming if exercise failed
//            mav.addObject("workoutID", workoutExerciseForm.getWorkoutID());
//            mav.addObject("exercises", exerciseRepo.getAllExercises(userID));
//            mav.setViewName("CreateWorkoutExercises");
//        } else
//            if (trainerWorkoutRepository.addExercise(workoutExerciseForm)) {
//                System.out.println("Exercise added to workout");
//                mav.addObject("workouts", trainerWorkoutRepository.allWorkouts(userID));
//                mav.setViewName("AllWorkouts");
//            } else {
//                System.out.println("Not added to database");
//                mav.addObject("workoutID", workoutExerciseForm.getWorkoutID());
//                mav.addObject("exercises", exerciseRepo.getAllExercises(userID));
//                mav.setViewName("CreateWorkoutExercises");
//            }
//        return mav;
//    }
//
//}
