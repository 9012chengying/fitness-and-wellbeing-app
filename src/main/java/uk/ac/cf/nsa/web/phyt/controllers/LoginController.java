package uk.ac.cf.nsa.web.phyt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.cf.nsa.web.phyt.DTO.UserDTO;
import uk.ac.cf.nsa.web.phyt.forms.UserForm;
import uk.ac.cf.nsa.web.phyt.repository.LoginRepository;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private LoginRepository loginRepository;

    /**
     * init
     */
    @RequestMapping(path = "/")
    public String initLogin() {
        return "redirect:LoginPage";
    }

    /**
     * login
     */
    @RequestMapping(value = "/LoginPage", method = RequestMethod.POST)
    public String login(UserForm user, Model model, HttpSession session) {
        // get username and password
        String username= user.getUsername();
        String password= user.getPassword();
        if (username !=null&&username.equals("") && password !=null &&password.equals("")){
            session.setAttribute("user", user);
            // redirect
            return "redirect:main";
        }
        model.addAttribute("msg", "Error, please enter again! ");
        return "login";
    }

    @RequestMapping(value = "/LoginPage", method = RequestMethod.GET)
    public ModelAndView  showLogin(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("LoginPage");
        return mav;
    }

    /**
     * jump to main
     */
    @RequestMapping(path = "/main")
    public String toMain() {
        return "main";
    }

    /**
     * logout
     */
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        // clear session
        session.invalidate();
        return "redirect:LoginPage";
    }

    @RequestMapping(path="/register/info/{username}")
    public ModelAndView trainerInfo(@PathVariable("username") String username) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("info", loginRepository.getUserInfo(username));
        mav.setViewName("PtHomePage");
        return mav;
    }
}
