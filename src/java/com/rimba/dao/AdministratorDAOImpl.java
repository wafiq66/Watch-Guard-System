/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rimba.dao;

import com.ems.connection.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.bean.Administrator;


/**
 *
 * @author user
 */
public class AdministratorDAOImpl implements AdministratorDAO{
    private Connection conn;
    
    public AdministratorDAOImpl(){
        this.conn = Connect.getConnection();
    }
    
    @Override
    public Administrator getAdministrator(int administratorID) {
        this.conn = Connect.getConnection();
        Administrator administrator = null;
        String sql = "SELECT * " +
                     "FROM ADMINISTRATOR " +
                     "WHERE ADMINISTRATORID =?";

        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, administratorID);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    administrator = new Administrator(
                        resultSet.getInt("ADMINISTRATORID"),
                        resultSet.getString("ADMINISTRATORPASSWORD"),
                        resultSet.getString("ADMINISTRATORNAME"),
                        resultSet.getString("ADMINISTRATORPHONENUMBER"),
                        resultSet.getString("ADMINISTRATOREMAIL")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error fetching administrator: " + e.getMessage(), e);
        }

        return administrator;
    }
}
