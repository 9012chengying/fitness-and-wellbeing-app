//package uk.ac.cf.nsa.web.phyt.users.controllers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;
//import uk.ac.cf.nsa.web.phyt.users.data.DTO.UserDTO;
//import uk.ac.cf.nsa.web.phyt.users.data.DTO.UserEntity;
//import uk.ac.cf.nsa.web.phyt.users.forms.UserForm;
//import uk.ac.cf.nsa.web.phyt.users.service.UserService;
//
//
//@Controller
//public class UserController {
//
//    private final UserService userService;
//
//    @Autowired
//    public UserController(UserService userService){
//        this.userService = userService;
//    }
//
//
//    @RequestMapping(path="/register", method=RequestMethod.GET)
//    public String trainerRegister() {
//        return "register";
//    }
//
//    @RequestMapping(path="/register/client", method=RequestMethod.GET)
//    public String clientRegister() {
//        return "registerClient";
//    }
//
//    //Route for registering a Trainer to the app
//    @RequestMapping(path = "/register", method = RequestMethod.POST)
//    public String trainerAdd(UserForm userForm, Model model) {
//        //Create user object by checking userForm username details against database
//        UserDTO user = userService.getUserInfo(userForm);
//        if (user != null) {
//            model.addAttribute("registerMessage", "Username already taken");
//            return "register";
//        } else {
//            userForm.setRole("Trainer");
//            if (!userService.setUpNewTrainer(userForm)) {
//                return "register";
//            } else {
//                return "redirect:/login";
//            }
//        }
//    }
//
//    @RequestMapping(path = "/register/client", method = RequestMethod.POST)
//    public String clientAdd(UserForm userForm, Model model) {
//        UserDTO user = userService.getUserInfo(userForm);
//        if (user != null) {
//            model.addAttribute("registerMessage", "Username already taken");
//            return "registerClient";
//        } else {
//            userForm.setRole("Client");
//            if (!userService.setUpNewTrainer(userForm)) {
//                return "registerClient";
//            } else {
//                return "redirect:/login";
//            }
//        }
//    }
//
//    //sets redirect to login page if user goes doesn't enter a specific route
//    @RequestMapping(path = "/" , method=RequestMethod.GET)
//    public String getHomepage() {
//        return "redirect:/login";
//    }
//
//
//    //Gets the login page and displays on browser
//    @RequestMapping(path="/login", method = RequestMethod.GET)
//    public String getLoginPage(){
//        return "login";
//    }
//
//
//    //User info route opens relevant page depending on user role details
//    @RequestMapping(path="/home")
//    public ModelAndView userAccountInfo() {
//        ModelAndView mav = new ModelAndView();
//        UserEntity currentUser = userService.authenticateUser();
//        String name = currentUser.getFirstname();
//        String username = currentUser.getUsername();
//        if(currentUser.getRole().equals("Trainer")){
//            mav.addObject("name", name);
//            mav.addObject("username",username);
//            mav.setViewName("Trainer");
//            return mav;
//        } else {
//            mav.addObject("name", name);
//            mav.addObject("username",username);
//            mav.setViewName("User");
//            return mav;
//        }
//    }
//
//    @RequestMapping(path = "/update/user")
//    public String trainerUpdate(UserForm userForm) {
//        userService.updateUser(userForm);
//        return "redirect:/trainer/info/"+userForm.getUsername();
//    }
//    //trainer info page
//    @RequestMapping(path="/trainer/info/{username}")
//    public ModelAndView trainerInfo(@PathVariable("username") String username) {
//        ModelAndView mav = new ModelAndView();
//        UserForm userForm = new UserForm(username,null,null,null,null);
//        UserDTO bean = userService.getUserInfo(userForm);
//        mav.addObject("info", bean);
//        mav.setViewName("PtHomePage");
//        return mav;
//    }
//
//    //client info page
//    @RequestMapping(path="/client/info/{username}") //Displays user information
//    public ModelAndView clientInfo(@PathVariable("username") String username) {
//        ModelAndView mav = new ModelAndView();
//        UserForm userForm = new UserForm(username,null,null,null,null);
//        mav.addObject("info", userService.getUserInfo(userForm));
//        mav.setViewName("ClientAccountDetails");
//        return mav;
//    }
//
//    //update trainer info
//    @RequestMapping(path="/trainer/query") //
//    public ModelAndView trainerUpdateInfo(String username) {
//        ModelAndView mav = new ModelAndView();
//        UserEntity currentUser = userService.authenticateUser();
//        int userID = currentUser.getUserId();
//        UserForm userForm = new UserForm(username,null,null,null,null);
//        UserDTO bean = userService.getUserInfo(userForm);
//        if (userID!=bean.getUserID()){
//            mav.setViewName("login");
//            return mav;
//        }
//        mav.addObject("info", userService.getUserInfo(userForm));
//        mav.setViewName("update");
//        return mav;
//    }
//
//    //update client info
//    @RequestMapping(path="/client/query", method=RequestMethod.GET) //Gets the update page for the user
//    public ModelAndView clientUpdateInfo(String username) {
//        ModelAndView mav = new ModelAndView();
//        UserForm userForm = new UserForm(username,null,null,null,null);
//        mav.addObject("info", userService.getUserInfo(userForm));
//        mav.setViewName("ClientInfoUpdate");
//        return mav;
//    }
//
//    //New Post route to update user info for client - client/ClientInfoUpdate
//    @RequestMapping(path="/client/ClientInfoUpdate", method=RequestMethod.POST)
//    public ModelAndView updateClientInfo(UserForm userForm){
//        ModelAndView mav = new ModelAndView();
//        boolean success = userService.updateUser(userForm);
//        if(!success){
//            mav.addObject("updateMessage", "Unable to update your details");
//            mav.addObject("info", userService.getUserInfo(userForm));
//            mav.setViewName("ClientInfoUpdate");
//        } else {
//            mav.addObject("info", userService.getUserInfo(userForm));
//            mav.setViewName("ClientAccountDetails");
//        }
//        return mav;
//    }
//
//    //delete trainer info
//    @RequestMapping(path = "/user/delete")
//    public String deleteUser(String username) {
//        boolean success= userService.deleteUser(username);
//        return "redirect:/register";
//    }
//
//
//}
