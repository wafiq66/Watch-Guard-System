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
public class Facility {
    
    
    private int facilityID;
    private String facilityType;

    public Facility() {
    }

    public Facility(int facilityID, String facilityType) {
        this.facilityID = facilityID;
        this.facilityType = facilityType;
    }

    public int getFacilityID() {
        return facilityID;
    }

    public String getFacilityType() {
        return facilityType;
    }

    public void setFacilityID(int facilityID) {
        this.facilityID = facilityID;
    }

    public void setFacilityType(String facilityType) {
        this.facilityType = facilityType;
    }
    
    
}
