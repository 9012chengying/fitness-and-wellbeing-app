//package uk.ac.cf.nsa.web.phyt.client.controllers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.ModelAndView;
//import uk.ac.cf.nsa.web.phyt.client.form.ClientWorkoutForm;
//import uk.ac.cf.nsa.web.phyt.users.data.DTO.UserEntity;
//import uk.ac.cf.nsa.web.phyt.users.service.UserService;
//import uk.ac.cf.nsa.web.phyt.client.repository.ClientWorkoutRepository;
//
//@Controller
//@RequestMapping(path="/client/workout")
//public class ClientWorkoutController {
//
//    private ClientWorkoutRepository clientWorkoutRepository;
//    private UserService userService;
//
//    @Autowired
//    public ClientWorkoutController(ClientWorkoutRepository clientWorkoutRepository, UserService userService) {
//        this.clientWorkoutRepository = clientWorkoutRepository;
//        this.userService = userService;
//    }
//
//    @GetMapping(path="")
//    public ModelAndView latestWorkout() {
//        ModelAndView mav = new ModelAndView();
//        UserEntity currentUser = userService.authenticateUser();
//        int userID = currentUser.getUserId();
//        int workoutID = clientWorkoutRepository.findIncompleteWorkoutID(userID);
//        if (workoutID == -1) {
//            mav.setViewName("NoNewWorkouts");
//        } else {
//            mav.addObject("workout", clientWorkoutRepository.workoutOverview(workoutID));
//            mav.addObject("exercises", clientWorkoutRepository.workoutExerciseDetails(workoutID));
//            mav.addObject("categories", clientWorkoutRepository.workoutCategories(workoutID));
//            mav.setViewName("ClientWorkoutPreview");
//        }
//        return mav;
//    }
//
//    @GetMapping(path="/exercise")
//    public ModelAndView viewExercise(int exerciseID) {
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("exercise", clientWorkoutRepository.viewExerciseByID(exerciseID));
//        mav.addObject("media", clientWorkoutRepository.mediaByExerciseID(exerciseID));
//        mav.setViewName("ClientExerciseView");
//        return mav;
//    }
//
//    @GetMapping(path="/timer")
//    public ModelAndView startTimer(@RequestParam(value="workoutID", defaultValue="null") int workoutID) {
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("workout", clientWorkoutRepository.workoutOverview(workoutID));
//        mav.addObject("exercises", clientWorkoutRepository.exerciseNameByWorkoutID(workoutID));
//        mav.addObject("thumbnails", clientWorkoutRepository.exerciseThumbnailByWorkoutID(workoutID));
//        mav.setViewName("Timer");
//        return mav;
//    }
//
//    @PostMapping(path="/timer/complete")
//    public ModelAndView workoutComplete(ClientWorkoutForm clientWorkoutForm) {
//        ModelAndView mav = new ModelAndView();
//        System.out.println(clientWorkoutForm.getWorkoutID());
//        if (clientWorkoutRepository.workoutComplete(clientWorkoutForm)) {
//            UserEntity currentUser = userService.authenticateUser();
//            int userID = currentUser.getUserId();
//            mav.addObject("workouts", clientWorkoutRepository.clientWorkoutDiary(userID));
//            mav.setViewName("ClientDiary");
//        } else {
//            System.out.println("Workout not updated");
//            mav.setViewName("Timer");
//        }
//        return mav;
//    }
//}
