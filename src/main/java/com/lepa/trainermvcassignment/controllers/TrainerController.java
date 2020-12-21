

package com.lepa.trainermvcassignment.controllers;

import com.lepa.trainermvcassignment.entities.Trainer;
import com.lepa.trainermvcassignment.services.ITrainerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;



@Controller
public class TrainerController {

    private String listurl = "list";
    private String editurl = "edit";
    private String deleteurl = "delete";
    private String updateurl = "update";

    @Autowired
    ITrainerService trainerService;

    @Autowired
    MessageSource messageSource;
    
    // get all trainers
    @RequestMapping(value={"/","/list"},method=RequestMethod.GET)
    public String getAllTrainers(ModelMap view, @RequestParam(required = false) String msg){
        List<Trainer> trainers=trainerService.getAllTrainers();
        view.addAttribute("trainers", trainers);
        view.addAttribute("editurl", editurl);
        view.addAttribute("deleteurl", deleteurl);
        view.addAttribute("msg", msg);
        return "trainerlist";
    }
    
    
    // get method for new trainer
    @RequestMapping("/new")
    public String showNewTrainerPage(ModelMap view){
        Trainer trainer=new Trainer();
        view.addAttribute("trainer",trainer);
        view.addAttribute("listurl",listurl);
        return "new_trainer";
    }
    
    
    
    // get trainer by id
    @RequestMapping(value="/{id}")
    public String getTrainerById(ModelMap view ,@PathVariable@RequestBody long id){
        view.addAttribute("projectName", "Trainer MVC Assignment");
        Trainer trainer=trainerService.getTrainerById(id);
        view.addAttribute("trainer", trainer);

        return "trainer";
    }
    
    // post method for new trainer
    @RequestMapping(value="/new",method=RequestMethod.POST)
    public String saveTrainer(ModelMap view, Trainer trainer){
        view.addAttribute("message",("Your registration was succesful!!"));
        view.addAttribute("listurl",listurl);
        trainerService.save(trainer);
        return "new_trainer";
    }
    
    
    //edit trainer by id 
    @RequestMapping(value="/edit/{id}",method=RequestMethod.GET)
    public String showEditTrainerPage(ModelMap view,@PathVariable int id){
        Trainer trainer=trainerService.getTrainerById(id);
        view.addAttribute("trainer",trainer);
        view.addAttribute("updateurl",updateurl);
        return ("edittrainer");
    }
    
    // store edit/update for an existing trainer  ??(dn paizei to redirect)
    @PostMapping(value="/update")
    public String updateTrainer(ModelMap view,Trainer trainer){
        trainerService.update(trainer);
        view.addAttribute("msg", new String(""));
        return("redirect:/list");
    }
    
    
    
    
//      delete trainer by id  
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteTrainer(ModelMap view,@PathVariable long id){
        if (trainerService.deleteTrainer(id)){
            view.addAttribute("msg","The trainer was successfully deleted!!!");
        } else{
            view.addAttribute("msg","Oops something went wrong... the trainer has not deleted!!!");
        }
        return "redirect:/list";
    }
}
