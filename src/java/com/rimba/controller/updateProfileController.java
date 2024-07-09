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

import model.bean.Resident;
import com.rimba.dao.ResidentDAO;
import com.rimba.dao.ResidentDAOImpl;

/**
 *
 * @author user
 */
public class updateProfileController extends HttpServlet {
    final ResidentDAO residentDAO = new ResidentDAOImpl();
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
            if(action.equals("updateProfile")){
                updateProfile(request,response);
            }
        }
    }
    protected void updateProfile(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            Resident residentLog = (Resident) session.getAttribute("account");
            
            String message1,message2;
            String residentICNumber = request.getParameter("residentICNumber");
            String residentName = request.getParameter("residentName");
            String residentEmail = request.getParameter("residentEmail");
            String residentPhoneNumber = request.getParameter("residentPhoneNumber");
            String residentUsername = request.getParameter("residentUsername");
            String residentNewPassword = request.getParameter("residentNewPassword");
            String familyName = request.getParameter("familyName");
            String familyPhoneNumber = request.getParameter("familyPhoneNumber");
            
            Resident resident = new Resident(
                                    residentICNumber,
                                    residentUsername,
                                    residentNewPassword,
                                    residentName,
                                    residentPhoneNumber,
                                    residentEmail,
                                    familyName,
                                    familyPhoneNumber
                                    );
            
            String validatePassword = request.getParameter("validatePassword");
            
            
            if(residentLog.getResidentPassword().equals(validatePassword)){
                if(!residentDAO.isUsernameAvailable(resident)){
                    message2 = "Username Already Exist";
                    request.setAttribute("message2", message2);
                    request.getRequestDispatcher("updateProfile.jsp").forward(request, response);
                }
                else{
                    message1 = "Successfully Registered";
                    residentDAO.updateResident(resident);
                    session.setAttribute("account",resident);
                    request.setAttribute("message1", message1);
                    request.getRequestDispatcher("updateProfile.jsp").forward(request, response);
                }
            }
            else{
                message2 = "Wrong Password";
                request.setAttribute("message2", message2);
                request.getRequestDispatcher("updateProfile.jsp").forward(request, response);
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
