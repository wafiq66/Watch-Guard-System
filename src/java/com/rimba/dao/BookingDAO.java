/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rimba.dao;
import model.bean.Booking;
/**
 *
 * @author user
 */
public interface BookingDAO {
    
    boolean BookingNotDuplicate(Booking booking);
    void insertBooking(Booking booking);
    void deleteBooking(int bookingID);
    void deleteBookingsByResidentICNumber(String residentICNumber);
}
