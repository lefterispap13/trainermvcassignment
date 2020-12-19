/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lepa.trainermvcassignment.services;

import com.lepa.trainermvcassignment.entities.Trainer;
import com.lepa.trainermvcassignment.requests.NewTrainerRequest;
import java.util.List;

/**
 *
 * @author User
 */
public interface ITrainerService {
    
    List<Trainer> getAllTrainers();
    
    Trainer getTrainerById(long id);
    
    Trainer newTrainer(NewTrainerRequest request);
    
    boolean deleteTrainer(long id);
            

}
