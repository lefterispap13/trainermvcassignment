/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lepa.trainermvcassignment.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author User
 */

@Controller
@RequestMapping
public class Login {
    
    @GetMapping(value={"/","/login"})
    public String login(ModelMap view){
        return "login";
    }

}
