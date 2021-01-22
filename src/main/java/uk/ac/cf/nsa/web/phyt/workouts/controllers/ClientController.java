package uk.ac.cf.nsa.web.phyt.workouts.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.cf.nsa.web.phyt.workouts.DTO.ClientDTO;
import uk.ac.cf.nsa.web.phyt.users.data.DTO.UserEntity;
import uk.ac.cf.nsa.web.phyt.users.service.UserService;

import uk.ac.cf.nsa.web.phyt.workouts.repository.ClientRepository;

@Controller
public class ClientController {

    private ClientRepository clientRepository;
    private UserService userService;

    @Autowired

    public ClientController(ClientRepository pRepo,UserService userService) {
        clientRepository = pRepo;
        this.userService = userService;
    }



    @RequestMapping(path = "/client/ClientAccountDetails")
    public ModelAndView clientInfo(String name) {
        ModelAndView mav = new ModelAndView();
        UserEntity currentUser = userService.authenticateUser();
        int userID = currentUser.getUserId();
        mav.addObject("info", clientRepository.getClientInfo(userID));
        mav.setViewName("ClientAccountDetails");
        return mav;
    }

    @RequestMapping(path = "/client/ClientInfoUpdate", method = RequestMethod.GET)
    public String getClientInfoUpdate() {
        return "ClientInfoUpdate";
    }


}