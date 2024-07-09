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
public class Renting {
    
    private String houseNumber;
    private String tenantICNumber;
    private boolean rentingStatus;

    public Renting() {
    }

    public Renting(String houseNumber, String tenantICNumber, boolean rentingStatus) {
        this.houseNumber = houseNumber;
        this.tenantICNumber = tenantICNumber;
        this.rentingStatus = rentingStatus;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getTenantICNumber() {
        return tenantICNumber;
    }

    public boolean isRentingStatus() {
        return rentingStatus;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public void setTenantICNumber(String tenantICNumber) {
        this.tenantICNumber = tenantICNumber;
    }

    public void setRentingStatus(boolean rentingStatus) {
        this.rentingStatus = rentingStatus;
    }
    
    
    
}
