/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lepa.trainermvcassignment.controllers;

import com.lepa.trainermvcassignment.entities.Trainer;
import com.lepa.trainermvcassignment.requests.NewTrainerRequest;
import com.lepa.trainermvcassignment.services.TrainerService;
import java.util.List;
import static java.util.Objects.isNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author User
 */

@RestController
@RequestMapping("/trainer")
public class TrainerController {
    
    @Autowired
    private TrainerService trainerService;
    
    // get all trainers
    @RequestMapping(value="/getall")
    public List<Trainer> getAllTrainers(){
        List<Trainer> trainers=trainerService.getAllTrainers();
        return trainers;
    }
    
    // get trainer by id
    @RequestMapping(value="/getbyid")
    public Trainer getTrainerById(@RequestBody long id){
        Trainer trainer=trainerService.getTrainerById(id);
        return trainer;
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
