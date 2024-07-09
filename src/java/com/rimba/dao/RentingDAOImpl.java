/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rimba.dao;
import com.ems.connection.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.bean.Renting;
/**
 *
 * @author user
 */
public class RentingDAOImpl implements RentingDAO{
    private Connection conn;

    public RentingDAOImpl(){
        this.conn = Connect.getConnection();
    }
    
    @Override
    public void deleteRenting(String houseNumber, String tenantICNumber) {
        this.conn = Connect.getConnection();
        String deleteSql = "DELETE FROM RENTING WHERE HOUSENUMBER = ? AND TENANTICNUMBER = ?";

        try (PreparedStatement deleteStatement = conn.prepareStatement(deleteSql)) {
            deleteStatement.setString(1, houseNumber);
            deleteStatement.setString(2, tenantICNumber);
            deleteStatement.executeUpdate();
            System.out.println("Renting record deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error deleting renting record: " + e.getMessage(), e);
        }
    }
    
    @Override
    public void registerRenting(String houseNumber, String tenantICNumber) {
        this.conn = Connect.getConnection();
        String insertSql = "INSERT INTO RENTING VALUES (?,?,?)";

        try (PreparedStatement insertStatement = conn.prepareStatement(insertSql)) {
            insertStatement.setString(1, houseNumber);
            insertStatement.setString(2, tenantICNumber);
            insertStatement.setBoolean(3, true);

            insertStatement.executeUpdate();
            System.out.println("Renting record inserted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error inserting renting record: " + e.getMessage(), e);
        }
    }
}
