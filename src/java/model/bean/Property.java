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
public class Property {
    
    private String houseNumber;
    private String parkingNumber;

    public Property() {
    }

    public Property(String houseNumber, String parkingNumber) {
        this.houseNumber = houseNumber;
        this.parkingNumber = parkingNumber;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getParkingNumber() {
        return parkingNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public void setParkingNumber(String parkingNumber) {
        this.parkingNumber = parkingNumber;
    }
    
    
    
}
