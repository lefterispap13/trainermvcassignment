/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lepa.trainermvcassignment.services;

import com.lepa.trainermvcassignment.dao.TrainerDao;
import com.lepa.trainermvcassignment.entities.Trainer;
import com.lepa.trainermvcassignment.requests.NewTrainerRequest;
import java.util.List;
import static java.util.Objects.isNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 *
 * @author User
 */

@Service("trainerService")
@Transactional
public class TrainerService implements ITrainerService{
    
    @Autowired
    private TrainerDao trainerDao;

    @Override
    public List<Trainer> getAllTrainers() {
        List<Trainer> trainers=(List<Trainer>) trainerDao.findAll();
        return trainers;
    }

    @Override
    public Trainer getTrainerById(long id) {
        Trainer trainer=(Trainer)trainerDao.findById(id).orElse(null);
        return trainer;
    }

    @Override
    public Trainer newTrainer(NewTrainerRequest request) {
        Trainer trainer=new Trainer(request.getFirstName(),request.getLastName(),request.getSubject());
        return trainerDao.save(trainer);
    }

    //??
    public boolean update(Trainer trainer){
        Trainer tempTrainer=trainerDao.findById(trainer.getId()).orElse(null);
        if (tempTrainer != null) {
            tempTrainer.setFirstName(trainer.getFirstName());
            tempTrainer.setLastName(trainer.getLastName());
            tempTrainer.setSubject(trainer.getSubject());
            trainerDao.save(tempTrainer);
            return true;
        }else
        return false;
    }

    @Override
    public boolean deleteTrainer(long id) {
        Trainer trainer = trainerDao.findById(id).orElse(null);
        if(isNull(trainer)){
            return false;
        }
        trainerDao.delete(trainer);
        return true;
    }


    
    
    

}
