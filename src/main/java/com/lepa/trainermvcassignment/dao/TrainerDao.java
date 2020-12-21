/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lepa.trainermvcassignment.dao;

import com.lepa.trainermvcassignment.entities.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author User
 */
public interface TrainerDao extends JpaRepository<Trainer,Long>{


}
