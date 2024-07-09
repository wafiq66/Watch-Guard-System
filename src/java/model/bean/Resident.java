/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.io.Serializable;

/**
 *
 * @author user
 */
public class Resident implements Serializable{
    
    private String residentICNumber;
    private String residentUsername;
    private String residentPassword;
    private String residentName;
    private String residentPhoneNumber;
    private String residentEmail;
    private String residentFamilyMemberName;
    private String residentFamilyMemberPhoneNumber;

    public Resident() {
    }

    public Resident(String residentICNumber, String residentUsername, String residentPassword, String residentName, String residentPhoneNumber, String residentEmail, String residentFamilyMemberName, String residentFamilyMemberPhoneNumber) {
        this.residentICNumber = residentICNumber;
        this.residentUsername = residentUsername;
        this.residentPassword = residentPassword;
        this.residentName = residentName;
        this.residentPhoneNumber = residentPhoneNumber;
        this.residentEmail = residentEmail;
        this.residentFamilyMemberName = residentFamilyMemberName;
        this.residentFamilyMemberPhoneNumber = residentFamilyMemberPhoneNumber;
    }

    public String getResidentICNumber() {
        return residentICNumber;
    }

    public String getResidentUsername() {
        return residentUsername;
    }

    public String getResidentPassword() {
        return residentPassword;
    }

    public String getResidentName() {
        return residentName;
    }

    public String getResidentPhoneNumber() {
        return residentPhoneNumber;
    }

    public String getResidentEmail() {
        return residentEmail;
    }

    public String getResidentFamilyMemberName() {
        return residentFamilyMemberName;
    }

    public String getResidentFamilyMemberPhoneNumber() {
        return residentFamilyMemberPhoneNumber;
    }
    
    public void setResidentICNumber(String residentICNumber) {
        this.residentICNumber = residentICNumber;
    }

    public void setResidentUsername(String residentUsername) {
        this.residentUsername = residentUsername;
    }

    public void setResidentPassword(String residentPassword) {
        this.residentPassword = residentPassword;
    }

    public void setResidentName(String residentName) {
        this.residentName = residentName;
    }

    public void setResidentPhoneNumber(String residentPhoneNumber) {
        this.residentPhoneNumber = residentPhoneNumber;
    }

    public void setResidentEmail(String residentEmail) {
        this.residentEmail = residentEmail;
    }

    public void setResidentFamilyMemberName(String residentFamilyMemberName) {
        this.residentFamilyMemberName = residentFamilyMemberName;
    }

    public void setResidentFamilyMemberPhoneNumber(String residentFamilyMemberPhoneNumber) {
        this.residentFamilyMemberPhoneNumber = residentFamilyMemberPhoneNumber;
    }
    
    public boolean verifyResidentLogin(String password){
        if(this.residentPassword.equals(password)){
            return true;
        }
        else{
            return false;
        }
    }
    
}
