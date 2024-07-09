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
import model.bean.Facility;

/**
 *
 * @author user
 */
public class FacilityDAOImpl implements FacilityDAO{
    private Connection conn;

    public FacilityDAOImpl(){
        this.conn = Connect.getConnection();
    }
    
    @Override
    public Facility getFacilityByID(int facilityID) {
        this.conn = Connect.getConnection();
        Facility facility = null;
        String sql = "SELECT * " +
                     "FROM FACILITY " +
                     "WHERE FACILITYID =?";

        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, facilityID);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    // Retrieve values from ResultSet, handling null cases
                    int id = resultSet.getInt("FACILITYID");
                    String type = resultSet.getString("FACILITYTYPE");

                    // Handle null values
                    type = (type == null) ? "" : type;

                    // Create Facility object with sanitized values
                    facility = new Facility(id, type);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error fetching facility: " + e.getMessage(), e);
        }

        return facility;
    }
}
