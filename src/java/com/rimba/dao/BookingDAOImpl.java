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
import model.bean.Booking;
/**
 *
 * @author user
 */
public class BookingDAOImpl implements BookingDAO{
     private Connection conn;
    
    public BookingDAOImpl(){
        this.conn = Connect.getConnection();
    }
    
    @Override
    public boolean BookingNotDuplicate(Booking booking) {
        this.conn = Connect.getConnection();
        boolean isNotDuplicate = true;
        String sql = "SELECT * " +
                     "FROM BOOKING " +
                     "WHERE FACILITYID =? AND BOOKINGDATE =? AND " +
                     "(STARTTIME < ? AND ENDTIME > ?)";

        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, booking.getFacilityID());
            statement.setString(2, booking.getBookingDate());
            statement.setString(3, booking.getEndTime()); // Check if any booking ends after the new start time
            statement.setString(4, booking.getStartTime()); // Check if any booking starts before the new end time

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    isNotDuplicate = false;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error checking for duplicate booking: " + e.getMessage(), e);
        }

        return isNotDuplicate;
    }

    
    @Override
    public void insertBooking(Booking booking) {
        this.conn = Connect.getConnection();
        String sql = "INSERT INTO BOOKING (RESIDENTICNUMBER, FACILITYID, BOOKINGDATE, STARTTIME, ENDTIME) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, booking.getResidentICNumber());
            statement.setInt(2, booking.getFacilityID());
            statement.setString(3, booking.getBookingDate());
            statement.setString(4, booking.getStartTime());
            statement.setString(5, booking.getEndTime());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error inserting booking: " + e.getMessage(), e);
        }
    }
    
    @Override
    public void deleteBooking(int bookingID) {
        this.conn = Connect.getConnection();
        String sql = "DELETE FROM BOOKING " +
                     "WHERE BOOKINGID =?";

        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, bookingID);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error deleting booking: " + e.getMessage(), e);
        }
    }
    
    @Override
    public void deleteBookingsByResidentICNumber(String residentICNumber) {
        this.conn = Connect.getConnection();
        String sql = "DELETE FROM BOOKING " +
                     "WHERE RESIDENTICNUMBER =?";

        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, residentICNumber);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error deleting bookings: " + e.getMessage(), e);
        }
    }
}
