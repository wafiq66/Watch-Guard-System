/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author user
 */
public class Administrator {
    
    private int administratorID;
    private String administratorPassword;
    private String administratorName;
    private String administratorPhoneNumber;
    private String administratorEmail;

    public Administrator() {
    }

    public Administrator(int administratorID, String administratorPassword, String administratorName, String administratorPhoneNumber, String administratorEmail) {
        this.administratorID = administratorID;
        this.administratorPassword = administratorPassword;
        this.administratorName = administratorName;
        this.administratorPhoneNumber = administratorPhoneNumber;
        this.administratorEmail = administratorEmail;
    }

    public int getAdministratorID() {
        return administratorID;
    }

    public String getAdministratorPassword() {
        return administratorPassword;
    }

    public String getAdministratorName() {
        return administratorName;
    }

    public String getAdministratorPhoneNumber() {
        return administratorPhoneNumber;
    }

    public String getAdministratorEmail() {
        return administratorEmail;
    }

    public void setAdministratorID(int administratorID) {
        this.administratorID = administratorID;
    }

    public void setAdministratorPassword(String administratorPassword) {
        this.administratorPassword = administratorPassword;
    }

    public void setAdministratorName(String administratorName) {
        this.administratorName = administratorName;
    }

    public void setAdministratorPhoneNumber(String administratorPhoneNumber) {
        this.administratorPhoneNumber = administratorPhoneNumber;
    }

    public void setAdministratorEmail(String administratorEmail) {
        this.administratorEmail = administratorEmail;
    }
    
    public boolean verifyAdministratorLogin(String password){
        if(this.administratorPassword.equals(password)){
            return true;
        }
        else{
            return false;
        }
    }
    
}
