package uk.ac.cf.nsa.web.phyt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uk.ac.cf.nsa.web.phyt.forms.UserForm;
import uk.ac.cf.nsa.web.phyt.repository.RegisterRepository;

@Controller
public class RegisterController {

    @Autowired
    private RegisterRepository registerRepository;

    @RequestMapping(path="/register")
    public String trainerAllClients() {
        return "register";
    }



    @RequestMapping(path = "/register/user", method= RequestMethod.POST)
    public String trainerAddExercise (UserForm userForm, BindingResult br) {
        if (br.hasErrors()) {
            System.out.println(br.toString());
            return br.toString();
        } else {
            registerRepository.registerUser(userForm);
            return "redirect:all" ;
        }
    }
}
