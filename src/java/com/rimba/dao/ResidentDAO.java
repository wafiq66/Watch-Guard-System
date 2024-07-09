/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rimba.dao;

import model.bean.Resident;
/**
 *
 * @author user
 */
public interface ResidentDAO {
    
    Resident getResident(String username);
    public void updateResident(Resident resident);
    public void deleteResident(String residentIC);
    public boolean isUsernameAvailable(Resident resident);
    public void registerResident(Resident resident, String ownerICNumber);
    boolean isICNumberAvailable(String icNumber);
}
