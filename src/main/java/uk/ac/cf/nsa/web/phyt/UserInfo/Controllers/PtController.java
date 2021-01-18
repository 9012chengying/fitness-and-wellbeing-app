package uk.ac.cf.nsa.web.phyt.UserInfo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uk.ac.cf.nsa.web.phyt.UserInfo.Forms.GeneralinfoPT;
import uk.ac.cf.nsa.web.phyt.UserInfo.Forms.PersonalTrainer;
import uk.ac.cf.nsa.web.phyt.UserInfo.Repository.ptRepo;

@Controller
@RequestMapping(path ="/Loginuser")
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
        model.addAttribute("Generalinfo", new GeneralinfoPT());
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

    @GetMapping(value = {"/PtPersonalInfo"})
    public String submitDetails(PersonalTrainer personalTrainer, GeneralinfoPT generalinfoPT,Model model){
        model.addAttribute("PersonalTrainer",personalTrainer);
        model.addAttribute("Generalinfo", generalinfoPT);

        personaltRepo.updatePtInfo(personalTrainer);

return "PtHomePage";
    }
    @GetMapping("/PtGeneralInfo")
    public String submitDetails2(GeneralinfoPT generalinfoPT, PersonalTrainer personalTrainer, Model model){
        model.addAttribute("Generalinfo", generalinfoPT);
        model.addAttribute("PersonalTrainer",personalTrainer);

        personaltRepo.updatePtGeneral(generalinfoPT);
        return "PtHomePage";

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
