/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rimba.dao;

import model.bean.Renting;

/**
 *
 * @author user
 */
public interface RentingDAO {
    
    void deleteRenting(String houseNumber, String tenantICNumber);
    void registerRenting(String houseNumber, String tenantICNumber);
}
