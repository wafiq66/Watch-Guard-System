/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author user
 */
public class Booking {
    private String residentICNumber;
    private int facilityID;
    private String bookingDate;
    private String startTime;
    private String endTime;

    public Booking() {
    }

    public Booking(String residentICNumber, int facilityID, String bookingDate, String startTime, String endTime) {
        this.residentICNumber = residentICNumber;
        this.facilityID = facilityID;
        this.bookingDate = bookingDate;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getResidentICNumber() {
        return residentICNumber;
    }

    public int getFacilityID() {
        return facilityID;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setResidentICNumber(String residentICNumber) {
        this.residentICNumber = residentICNumber;
    }

    public void setFacilityID(int facilityID) {
        this.facilityID = facilityID;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
    
    
}
