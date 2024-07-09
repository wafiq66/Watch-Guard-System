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
public class Visit {
    
    private String houseNumber;
    private String visitorICNumber;
    private String visitPurpose;
    private String visitTimeStamp;
    private String visitorVechileNumber;

    public Visit() {
    }

    public Visit(String houseNumber, String visitorICNumber, String visitPurpose, String visitTimeStamp, String visitorVechileNumber) {
        this.houseNumber = houseNumber;
        this.visitorICNumber = visitorICNumber;
        this.visitPurpose = visitPurpose;
        this.visitTimeStamp = visitTimeStamp;
        this.visitorVechileNumber = visitorVechileNumber;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getVisitorICNumber() {
        return visitorICNumber;
    }

    public String getVisitPurpose() {
        return visitPurpose;
    }

    public String getVisitTimeStamp() {
        return visitTimeStamp;
    }

    public String getVisitorVechileNumber() {
        return visitorVechileNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public void setVisitorICNumber(String visitorICNumber) {
        this.visitorICNumber = visitorICNumber;
    }

    public void setVisitPurpose(String visitPurpose) {
        this.visitPurpose = visitPurpose;
    }

    public void setVisitTimeStamp(String visitTimeStamp) {
        this.visitTimeStamp = visitTimeStamp;
    }

    public void setVisitorVechileNumber(String visitorVechileNumber) {
        this.visitorVechileNumber = visitorVechileNumber;
    }
    
    
    
}
