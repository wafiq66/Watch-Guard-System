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
public class Visitor {
    
    private String visitorICNumber;
    private String visitorName;

    public Visitor() {
    }

    public Visitor(String visitorICNumber, String visitorName) {
        this.visitorICNumber = visitorICNumber;
        this.visitorName = visitorName;
    }

    public String getVisitorICNumber() {
        return visitorICNumber;
    }

    public String getVisitorName() {
        return visitorName;
    }

    public void setVisitorICNumber(String visitorICNumber) {
        this.visitorICNumber = visitorICNumber;
    }

    public void setVisitorName(String visitorName) {
        this.visitorName = visitorName;
    }
    
    
    
}
