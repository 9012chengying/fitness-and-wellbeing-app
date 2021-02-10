//package uk.ac.cf.nsa.web.phyt.exercises.controllers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.servlet.ModelAndView;
//import uk.ac.cf.nsa.web.phyt.exercises.data.DTO.ImageBlob;
//import uk.ac.cf.nsa.web.phyt.exercises.forms.ExerciseForm;
//import uk.ac.cf.nsa.web.phyt.exercises.forms.ImageForm;
//import uk.ac.cf.nsa.web.phyt.exercises.service.ExerciseManagementService;
//import uk.ac.cf.nsa.web.phyt.exercises.service.FileUploadService;
//import uk.ac.cf.nsa.web.phyt.users.data.DTO.UserEntity;
//import uk.ac.cf.nsa.web.phyt.users.service.UserService;
//
//
//@Controller
//@RequestMapping(path ="/trainer/exercises")
//public class ExerciseController {
//
//    //Use Services to run methods to send data from and to controller
//    private final ExerciseManagementService exerciseService;
//    private final UserService userService;
//    private final FileUploadService fileUploadService;
//
//    @Autowired
//    public ExerciseController(ExerciseManagementService exerciseService, UserService userService, FileUploadService fileUploadService) {
//        this.exerciseService = exerciseService;
//        this.userService = userService;
//        this.fileUploadService = fileUploadService;
//    }
//
//    //List all exercises
//    @GetMapping(path = "/all")
//
//    public ModelAndView allExercises() {
//        ModelAndView mav = new ModelAndView();
//        UserEntity currentUser = userService.authenticateUser();
//        int userID = currentUser.getUserId();
//        mav.addObject("exercises", exerciseService.listAllExercises(userID));
//        mav.setViewName("AllExercises");
//        return mav;
//    }
//
//    //Filter exercises by category
//    @GetMapping(path = "/filter")
//    public ModelAndView filterExercises(@RequestParam(value = "categoryFilter", defaultValue = "All") String exerciseCat) {
//        ModelAndView mav = new ModelAndView();
//        UserEntity currentUser = userService.authenticateUser();
//        int userID = currentUser.getUserId();
//        mav.addObject("exercises", exerciseService.listExercisesByCategory(exerciseCat,userID));
//        mav.setViewName("AllExercises");
//        return mav;
//    }
//
//    //View an individual exercise
//    @GetMapping(path = "/view")
//    public ModelAndView getExercise(@RequestParam(value = "exerciseID", defaultValue = "") String exerciseID) {
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("exercise", exerciseService.viewExercise(exerciseID));
//        mav.addObject("images", exerciseService.viewExercise(exerciseID).getImages());
//        mav.addObject("videos", exerciseService.viewExercise(exerciseID).getVideos());
//        mav.setViewName("ViewExercise");
//        return mav;
//    }
//
//    //Show 'Create Exercise' Form
//    @GetMapping(path = "/add")
//    public ModelAndView createExercise() {
//        ModelAndView mav = new ModelAndView();
//        UserEntity currentUser = userService.authenticateUser();
//        int userID = currentUser.getUserId();
//        mav.addObject("userID", userID);
//        mav.setViewName("CreateExercise");
//        return mav;
//    }
//
//    //Create new exercise in database
//    @PostMapping(path = "/add")
//    public String trainerAddExercise(ExerciseForm exerciseForm,  BindingResult br) {
//        if (br.hasErrors()) {
//            System.out.println(br.toString());
//            return br.toString();
//        } else {
//            if (exerciseService.createNewExercise(exerciseForm)) {
//                return "redirect:all";
//            } else {
//                return "redirect:add";
//            }
//        }
//    }
//
//    //Edit existing exercise
//    @GetMapping(path = "/edit")
//    public ModelAndView getEditExercise(@RequestParam(value = "exerciseID", defaultValue = "") String exerciseID) {
//        ModelAndView mav = new ModelAndView();
//        if( exerciseService.viewExercise(exerciseID).getVideos().size() != 0){
//            mav.addObject("exercise", exerciseService.viewExercise(exerciseID));
//            mav.addObject("videos", exerciseService.viewExercise(exerciseID).getVideos());
//            mav.setViewName("EditExercise");
//        } else {
//            mav.addObject("exercise", exerciseService.viewExercise(exerciseID));
//            mav.setViewName("EditExerciseNoVideo");
//        }
//        return mav;
//    }
//
//    @PostMapping(path="/edit")
//    public  ModelAndView updateExercise(ExerciseForm exerciseForm, BindingResult br){
//        ModelAndView mav = new ModelAndView();
//        if (br.hasErrors()) {
//            System.out.println(br.toString());
//            mav.setViewName("EditExercise");
//            return mav;
//        }
//            exerciseService.editExercise(exerciseForm);
//            int id = exerciseForm.getExerciseID();
//            String ID = String.valueOf(id);
//            mav.addObject("exercise",exerciseService.viewExercise(ID));
//            mav.addObject("refresh", "Refresh Page");
//            mav.setViewName("ViewExercise");
//            return mav;
//        }
//
//    @GetMapping(path="/uploadImages")
//    public ModelAndView getUploadImagesForm(@RequestParam(value = "exerciseID", defaultValue = "") String exerciseID){
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("exercise", exerciseService.viewExercise(exerciseID));
//        mav.setViewName("AddImages");
//        return mav;
//    }
//
//    @PostMapping(path="/uploadImages")
//    public ModelAndView uploadImageFiles(ImageForm imageForm, @RequestParam("image") MultipartFile multipartFile, BindingResult br){
//        ModelAndView mav = new ModelAndView();
//        String exerciseID = String.valueOf(imageForm.getExerciseID());
//        if (br.hasErrors()) {
//            System.out.println(br.toString());
//            mav.addObject("message", "Image failed to upload");
//            mav.setViewName("AddImages");
//            return mav;
//        } else
//        //add images to the database in the media table.
//        fileUploadService.addFilesToDatabase(imageForm, multipartFile);
//        mav.addObject("message", "Image successfully added");
//        mav.addObject("exercise", exerciseService.viewExercise(exerciseID));
//        mav.setViewName("AddImages");
//        return mav;
//    }
//}
//
//
//
