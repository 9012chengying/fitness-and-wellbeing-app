package uk.ac.cf.nsa.web.phyt.UserInfo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uk.ac.cf.nsa.web.phyt.UserInfo.Forms.PersonalTrainer;
import uk.ac.cf.nsa.web.phyt.UserInfo.Repository.ptRepo;

@Controller
@RequestMapping(path ="/Login")
public class PtController {

    private final ptRepo personaltRepo;

    @Autowired
    public PtController(ptRepo personaltRepo) {
        this.personaltRepo = personaltRepo;
    }

    @GetMapping(path="/PersonalTrainer")
    public String getPT(){
        return "PtHomePage";
    }

//    @GetMapping(path = "/PersonalTrainer/YourAccount")
//    public String PTAccountedit(){
//        return "YourAccountPage";
//    }
    @GetMapping(path = "/PersonalTrainer/YourAccount")
    public String getyourDetails(Model model){

        model.addAttribute("PersonalTrainer",new PersonalTrainer());

        return "YourAccountPage";
    }

//     @GetMapping(path="/PtPersonalInfo")
//    public ModelAndView updatept(@ModelAttribute PersonalTrainer personalTrainer){
//
//        ModelAndView mav = new ModelAndView();
//
//        mav.addObject(personaltRepo.updatePtInfoById(personalTrainer));
//        mav.setViewName("Thanks");
//        return mav;
//     }

    @GetMapping("/PtPersonalInfo")
    public String submitDetails(PersonalTrainer personalTrainer,Model model){

        model.addAttribute("PersonalTrainer",personalTrainer);

       personaltRepo.updatePtInfo(personalTrainer);
return "YourAccountPage";
    }





//    @RequestMapping(value = "/PtPersonalInfo",method = RequestMethod.POST)
//    public String changeInfo(Model model){
//
//        model.addAttribute("personalTrainer",new PersonalTrainer());
//
//
//
//
//        return "Thanks";
//
//    }






}
