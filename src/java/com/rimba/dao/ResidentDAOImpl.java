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
import model.bean.Resident;

/**
 *
 * @author user
 */
public class ResidentDAOImpl implements ResidentDAO {
    private Connection conn;

    public ResidentDAOImpl(){
        this.conn = Connect.getConnection();
    }
    
    @Override
    public Resident getResident(String username) {
        this.conn = Connect.getConnection();
        Resident resident = null;
        String sql = "SELECT * " +
                     "FROM RESIDENT " +
                     "WHERE RESIDENTUSERNAME =?";

        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, username);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    // Retrieve values from ResultSet, handling null cases
                    String residentICNumber = resultSet.getString("RESIDENTICNUMBER");
                    String residentUsername = resultSet.getString("RESIDENTUSERNAME");
                    String residentPassword = resultSet.getString("RESIDENTPASSWORD");
                    String residentName = resultSet.getString("RESIDENTNAME");
                    String residentPhoneNumber = resultSet.getString("RESIDENTPHONENUMBER");
                    String residentEmail = resultSet.getString("RESIDENTEMAIL");
                    String residentFamilyMemberName = resultSet.getString("RESIDENTFAMILYMEMBERNAME");
                    String residentFamilyMemberPhoneNumber = resultSet.getString("RESIDENTFAMILYMEMBERPHONENUMBER");

                    // Handle null values
                    residentICNumber = (residentICNumber == null) ? "" : residentICNumber;
                    residentUsername = (residentUsername == null) ? "" : residentUsername;
                    residentPassword = (residentPassword == null) ? "" : residentPassword;
                    residentName = (residentName == null) ? "" : residentName;
                    residentPhoneNumber = (residentPhoneNumber == null) ? "" : residentPhoneNumber;
                    residentEmail = (residentEmail == null) ? "" : residentEmail;
                    residentFamilyMemberName = (residentFamilyMemberName == null) ? "" : residentFamilyMemberName;
                    residentFamilyMemberPhoneNumber = (residentFamilyMemberPhoneNumber == null) ? "" : residentFamilyMemberPhoneNumber;

                    // Create Resident object with sanitized values
                    resident = new Resident(
                        residentICNumber,
                        residentUsername,
                        residentPassword,
                        residentName,
                        residentPhoneNumber,
                        residentEmail,
                        residentFamilyMemberName,
                        residentFamilyMemberPhoneNumber
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error fetching resident: " + e.getMessage(), e);
        }

        return resident;
    }

    @Override
    public void updateResident(Resident resident) {
        this.conn = Connect.getConnection();
        String sql = "UPDATE RESIDENT " +
                     "SET RESIDENTUSERNAME = ?, " +
                     "RESIDENTPASSWORD = ?, " +
                     "RESIDENTNAME = ?, " +
                     "RESIDENTPHONENUMBER = ?, " +
                     "RESIDENTEMAIL = ?, " +
                     "RESIDENTFAMILYMEMBERNAME = ?, " +
                     "RESIDENTFAMILYMEMBERPHONENUMBER = ? " +
                     "WHERE RESIDENTICNUMBER = ?";

        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, resident.getResidentUsername());
            statement.setString(2, resident.getResidentPassword());
            statement.setString(3, resident.getResidentName());
            statement.setString(4, resident.getResidentPhoneNumber());
            statement.setString(5, resident.getResidentEmail());
            statement.setString(6, resident.getResidentFamilyMemberName());
            statement.setString(7, resident.getResidentFamilyMemberPhoneNumber());
            statement.setString(8, resident.getResidentICNumber()); // IC number is used to identify the resident to update

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error updating resident: " + e.getMessage(), e);
        }
    }
    
    @Override
    public void deleteResident(String residentIC) {
        this.conn = Connect.getConnection();
        String deleteSql = "DELETE FROM RESIDENT WHERE RESIDENTICNUMBER = ?";

        try (PreparedStatement deleteStatement = conn.prepareStatement(deleteSql)) {
            deleteStatement.setString(1, residentIC);
            deleteStatement.executeUpdate();
            System.out.println("Resident record deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error deleting resident record: " + e.getMessage(), e);
        }
    }
    
    @Override
    public boolean isUsernameAvailable(Resident resident) {
        String sql = "SELECT COUNT(*) " +
                     "FROM RESIDENT " +
                     "WHERE RESIDENTUSERNAME =? " +
                     "AND RESIDENTICNUMBER!=?";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, resident.getResidentUsername());
            statement.setString(2, resident.getResidentICNumber());
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next() && resultSet.getInt(1) > 0) {
                    return false; // username already exists
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error checking username: " + e.getMessage(), e);
        }
        return true; // username is available
    }
    
    @Override
    public void registerResident(Resident resident, String ownerICNumber) {
        this.conn = Connect.getConnection();
        String sql = "INSERT INTO RESIDENT " +
                     "(RESIDENTICNUMBER, RESIDENTUSERNAME, RESIDENTPASSWORD, RESIDENTNAME, RESIDENTPHONENUMBER, RESIDENTEMAIL, RESIDENTFAMILYMEMBERNAME, RESIDENTFAMILYMEMBERPHONENUMBER, OWNERICNUMBER) " +
                     "VALUES (?,?,?,?,?,?,?,?,?)";

        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, resident.getResidentICNumber());
            statement.setString(2, resident.getResidentUsername());
            statement.setString(3, resident.getResidentPassword());
            statement.setString(4, resident.getResidentName());
            statement.setString(5, resident.getResidentPhoneNumber());
            statement.setString(6, resident.getResidentEmail());
            statement.setString(7, resident.getResidentFamilyMemberName());
            statement.setString(8, resident.getResidentFamilyMemberPhoneNumber());
            statement.setString(9, ownerICNumber);

            statement.executeUpdate();
            System.out.println("Resident inserted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error inserting resident: " + e.getMessage(), e);
        }
    }
    
    @Override
    public boolean isICNumberAvailable(String icNumber) {
        String sql = "SELECT COUNT(*) " +
                     "FROM RESIDENT " +
                     "WHERE RESIDENTICNUMBER =?";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, icNumber);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next() && resultSet.getInt(1) > 0) {
                    return false; // IC number already exists
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error checking IC number: " + e.getMessage(), e);
        }
        return true; // IC number is available
    }
}
