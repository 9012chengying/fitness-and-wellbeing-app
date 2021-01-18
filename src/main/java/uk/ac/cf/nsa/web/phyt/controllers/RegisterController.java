//package uk.ac.cf.nsa.web.phyt.controllers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//import uk.ac.cf.nsa.web.phyt.DTO.UserEntity;
//import uk.ac.cf.nsa.web.phyt.forms.UserForm;
//import uk.ac.cf.nsa.web.phyt.repository.RegisterRepository;
//
//@Controller
//public class RegisterController {
//
//    @Autowired
//    private RegisterRepository registerRepository;
//
//    @RequestMapping(path="/register")
//    public String trainerRegister() {
//        return "register";
//    }
//
//    @RequestMapping(path = "/register/user")
//    public String trainerAdd(UserForm userForm) {
//        UserEntity user = registerRepository.getUserInfo(userForm.getUsername());
//        if (user!=null){
//            return "failRegister";
//        }
//            registerRepository.registerUser(userForm);
//            return "redirect:info/"+userForm.getUsername();
//    }
//
//    @RequestMapping(path = "/update/user")
//    public String trainerUpdate(UserForm userForm) {
//        registerRepository.updateUser(userForm);
//        return "redirect:/register/info/"+userForm.getUsername();
//    }
//
//    @RequestMapping(path="/register/info/{username}")
//    public ModelAndView trainerInfo(@PathVariable("username") String username) {
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("info", registerRepository.getUserInfo(username));
//        mav.setViewName("PtHomePage");
//        return mav;
//    }
//
//    @RequestMapping(path="/update/info")
//    public ModelAndView trainerUpdateInfo(String username) {
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("info", registerRepository.getUserInfo(username));
//        mav.setViewName("update");
//        return mav;
//    }
//
//    @RequestMapping(path = "/user/delete")
//    public String deleteUser(String username) {
//        boolean success= registerRepository.deleteUser(username);
//            return "redirect:/register";
//    }
//
//}
