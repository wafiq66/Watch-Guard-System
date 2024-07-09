/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rimba.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.bean.Booking;
import model.bean.Resident;

import com.rimba.dao.BookingDAO;
import com.rimba.dao.BookingDAOImpl;
import java.text.SimpleDateFormat;

/**
 *
 * @author user
 */
public class bookingController extends HttpServlet {
    final BookingDAO bookingDAO = new BookingDAOImpl();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String action = request.getParameter("action");
            if(action.equals("bookFacility")){
                bookingDO(request,response);
            }
            else if(action.equals("passSession")){
                passSession(request,response);
            }
            else if(action.equals("deleteBooking")){
                deleteBooking(request,response);
            }
        }
    }
    
    protected void bookingDO(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            String facilityID1 = request.getParameter("facility");
            int facilityID = Integer.parseInt(facilityID1);
            System.out.println(facilityID);
            
            String message = "";
            
            Booking booking = new Booking();
            Resident resident = (Resident) session.getAttribute("account");
            String date = request.getParameter("Date");
            String startTime = request.getParameter("StartTime"); // Fix: changed from "scheduleDate" to "startShift"
            String endTime = request.getParameter("EndTime");
            
            String insertStartTime = (startTime + ":00").substring(0, 8); // append ":00" and truncate to 8 characters
            String insertEndTime = (endTime + ":00").substring(0, 8);
            
          
            
            booking.setResidentICNumber(resident.getResidentICNumber());
            booking.setFacilityID(facilityID);
            booking.setBookingDate(date);
            booking.setStartTime(insertStartTime);
            booking.setEndTime(insertEndTime);
            
            if(bookingDAO.BookingNotDuplicate(booking)){
                bookingDAO.insertBooking(booking);
                message = "Successfully Booked";
                request.setAttribute("message1",message);
                request.setAttribute("message2","");
                request.setAttribute("facilityID",facilityID);
                request.getRequestDispatcher("upcomingBooking.jsp").forward(request, response);
            }else{
                message = "Your Booking Is Overlap With Others'";
                request.setAttribute("message1","");
                request.setAttribute("message2",message);
                request.setAttribute("facilityID",facilityID);
                request.getRequestDispatcher("bookSpecificFacilities.jsp").forward(request, response);
            }
        }
    }
    
    protected void passSession(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            int facilityID = Integer.parseInt(request.getParameter("facilityID"));
            
            session.setAttribute("facilityID",facilityID);
            request.getRequestDispatcher("bookSpecificFacilities.jsp").forward(request, response);
        }
    }
    
    protected void deleteBooking(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            int bookingID = Integer.parseInt(request.getParameter("bookingID"));
            bookingDAO.deleteBooking(bookingID);
            request.getRequestDispatcher("upcomingBooking.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
