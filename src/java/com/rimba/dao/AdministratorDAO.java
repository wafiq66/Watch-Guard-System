/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rimba.dao;

import model.bean.Administrator;
/**
 *
 * @author user
 */
public interface AdministratorDAO {
    
    
    Administrator getAdministrator(int administratorID);
}
