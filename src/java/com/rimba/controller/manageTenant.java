/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rimba.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.rimba.dao.RentingDAO;
import com.rimba.dao.RentingDAOImpl;
import com.rimba.dao.ResidentDAO;
import com.rimba.dao.ResidentDAOImpl;
import model.bean.Resident;
import com.rimba.dao.BookingDAO;
import com.rimba.dao.BookingDAOImpl;
/**
 *
 * @author user
 */
public class manageTenant extends HttpServlet {
    final RentingDAO rentingDAO = new RentingDAOImpl();
    final ResidentDAO residentDAO = new ResidentDAOImpl();
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
            if(action.equals("removeTenant")){
                deleteRecord(request,response);
            }
            else if(action.equals("registerTenant")){
                registerTenant(request,response);
            }
        }
    }

    protected void deleteRecord(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String houseNumber = request.getParameter("houseNumber");
            String tenantIC = request.getParameter("tenantIC");
            bookingDAO.deleteBookingsByResidentICNumber(tenantIC);
            rentingDAO.deleteRenting(houseNumber, tenantIC);
            residentDAO.deleteResident(tenantIC);
            request.getRequestDispatcher("manageProperty.jsp").forward(request,response);
        }
    }
    protected void registerTenant(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            Resident residentLog = (Resident) session.getAttribute("account");
            String message;
            
            String icNum = request.getParameter("icNum");
            String fullName = request.getParameter("fullName");
            String tenantUsername = request.getParameter("tenantUsername");
            String tenantPassword = request.getParameter("residentNewPassword");
            String yourPassword = request.getParameter("yourPassword");
            String houseNumber = request.getParameter("houseNumber");
            
             Resident resident = new Resident(
                                    icNum,
                                    tenantUsername,
                                    tenantPassword,
                                    fullName,
                                    null,
                                    null,
                                    null,
                                    null
                                    );
            if(residentLog.getResidentPassword().equals(yourPassword)){
                if(!residentDAO.isUsernameAvailable(resident)){
                    message = "Username Already Exist";
                    request.setAttribute("houseNumber",houseNumber);
                    request.setAttribute("message", message);
                    request.getRequestDispatcher("registerSpecificProperty.jsp").forward(request, response);
                }
                else if(!residentDAO.isICNumberAvailable(icNum)){
                    message = "IC Number Already Exist";
                    request.setAttribute("houseNumber",houseNumber);
                    request.setAttribute("message", message);
                    request.getRequestDispatcher("registerSpecificProperty.jsp").forward(request, response);
                }
                else{
                    residentDAO.registerResident(resident, residentLog.getResidentICNumber());
                    rentingDAO.registerRenting(houseNumber, icNum);
                    request.getRequestDispatcher("manageProperty.jsp").forward(request, response);
                }
            }
            else{
                message = "Wrong Password";
                request.setAttribute("houseNumber",houseNumber);
                request.setAttribute("message", message);
                request.getRequestDispatcher("registerSpecificProperty.jsp").forward(request, response);
            }
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
