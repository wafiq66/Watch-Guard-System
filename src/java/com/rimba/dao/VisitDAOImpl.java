/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rimba.dao;

import com.ems.connection.Connect;
import java.sql.Connection;

/**
 *
 * @author user
 */
public class VisitDAOImpl implements VisitDAO {
    private Connection conn;

    public VisitDAOImpl(){
        this.conn = Connect.getConnection();
    }
    
    
}
