package uk.ac.cf.nsa.web.phyt.workouts.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.cf.nsa.web.phyt.UserInfo.Forms.GeneralinfoPT;
import uk.ac.cf.nsa.web.phyt.UserInfo.Forms.PersonalTrainer;
import uk.ac.cf.nsa.web.phyt.exercises.data.DTO.Exercise;
import uk.ac.cf.nsa.web.phyt.exercises.forms.ExerciseForm;
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


    // Show client 's personal information
    @RequestMapping(path = "/client/ClientAccountDetails")
    public ModelAndView clientInfo(String name) {
        ModelAndView mav = new ModelAndView();
        UserEntity currentUser = userService.authenticateUser();
        int userID = currentUser.getUserId();
        mav.addObject("info", clientRepository.getClientInfo(userID));
        mav.setViewName("ClientAccountDetails");
        return mav;
    }

  //   Edit client 's personal information

    @RequestMapping(path="/client/ClientInfoUpdate")
    public ModelAndView clientUpdateInfo() {
        UserEntity currentUser = userService.authenticateUser();
        int userID = currentUser.getUserId();
        ModelAndView mav = new ModelAndView();
        mav.addObject("info", clientRepository.getClientInfo(userID));
        mav.setViewName("ClientInfoUpdate");
        return mav;
    }


}