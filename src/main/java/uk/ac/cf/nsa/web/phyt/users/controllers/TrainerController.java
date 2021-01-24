package uk.ac.cf.nsa.web.phyt.users.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.cf.nsa.web.phyt.users.data.DTO.UserDTO;
import uk.ac.cf.nsa.web.phyt.users.data.DTO.UserEntity;
import uk.ac.cf.nsa.web.phyt.users.data.repository.RegisterRepository;
import uk.ac.cf.nsa.web.phyt.users.forms.UserForm;
import uk.ac.cf.nsa.web.phyt.users.service.UserService;

@Controller
public class TrainerController {

    private final RegisterRepository registerRepository;
    private final UserService userService;

    @Autowired
    public TrainerController (RegisterRepository registerRepository, UserService userService){
        this.registerRepository = registerRepository;
        this.userService = userService;
    }

    @RequestMapping(path = "/trainer/update")
    public String trainerUpdate(UserForm userForm) {
        UserEntity currentUser = userService.authenticateUser();
        int userID = currentUser.getUserId();
        UserDTO bean = userService.getUserInfo(userForm);
        if (userID!=bean.getUserID()){
            return "redirect:/login";
        }
        //todo NEED TO CHECK SQL QUERY STILL VALID
        registerRepository.updateUser(userForm);
        return "redirect:/trainer/info/"+userForm.getUsername();
    }

    //Made route admin only as there should be security around people deleting users
    @RequestMapping(path = "/admin/user/delete")
    public String deleteUser() {
        UserEntity currentUser = userService.authenticateUser();
        String username = currentUser.getUsername();
        boolean success= registerRepository.deleteUser(username);
        return "redirect:/register";
    }


}
