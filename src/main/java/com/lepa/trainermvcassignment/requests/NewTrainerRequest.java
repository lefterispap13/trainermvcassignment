/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lepa.trainermvcassignment.requests;

/**
 *
 * @author User
 */

public class NewTrainerRequest {
    
    private String firstName;
    
    private String lastName;
    
    public String subject;

    public NewTrainerRequest() {
    }

    public NewTrainerRequest(String firstName, String lastName, String subject) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.subject = subject;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("NewTrainerRequest{firstName=").append(firstName);
        sb.append(", lastName=").append(lastName);
        sb.append(", subject=").append(subject);
        sb.append('}');
        return sb.toString();
    }
    
    
}
