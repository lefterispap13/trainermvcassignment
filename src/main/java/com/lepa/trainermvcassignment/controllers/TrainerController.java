/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lepa.trainermvcassignment.controllers;

import com.lepa.trainermvcassignment.entities.Trainer;
import com.lepa.trainermvcassignment.requests.NewTrainerRequest;
import com.lepa.trainermvcassignment.services.ITrainerService;
import com.lepa.trainermvcassignment.services.TrainerService;
import java.util.List;
import static java.util.Objects.isNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author User
 */

@Controller
@RequestMapping("/trainer")
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
    
    // get trainer by id
    @RequestMapping(value="/{id}")
    public String getTrainerById(ModelMap view ,@PathVariable@RequestBody long id){
        view.addAttribute("projectName", "Trainer MVC Assignment");
        Trainer trainer=trainerService.getTrainerById(id);
        view.addAttribute("trainer", trainer);

        return "trainer";
    }
    
    // update trainer by id
    
    
    // new trainer
    @RequestMapping(value="/new")
    public String newTrainer(@RequestBody NewTrainerRequest request){
        Trainer trainer=trainerService.newTrainer(request);
        if(isNull(trainer)){
            return "fail";
        }
        return"true";
    }
    
    // delete trainer by id
    @PostMapping(value="/delete")
    public String deleteTrainer(long id){
        boolean status=trainerService.deleteTrainer(id);
        return "Is the request succesfull???"+ status;
        
    }
    

}
