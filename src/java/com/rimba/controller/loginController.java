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
import java.sql.*;

import model.bean.Resident;
import model.bean.Administrator;

import com.rimba.dao.ResidentDAO;
import com.rimba.dao.ResidentDAOImpl;
import com.rimba.dao.AdministratorDAO;
import com.rimba.dao.AdministratorDAOImpl;

/**
 *
 * @author user
 */
public class loginController extends HttpServlet {
    final ResidentDAO residentDAO = new ResidentDAOImpl();
    final AdministratorDAO administratorDAO = new AdministratorDAOImpl();
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
        String action = request.getParameter("action");
        if(action.equals("loginResident")){
            loginResident(request,response);
        }
        else if(action.equals("loginAdmin")){
            loginAdmin(request,response);
        }
    }
    
    protected void loginResident(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String inputUsername = request.getParameter("username");
        String inputPassword = request.getParameter("password");
        String message = null;
        Resident resident = residentDAO.getResident(inputUsername);
        if(resident == null){
            message = "Account does not exist";
            request.setAttribute("message", message);
            request.getRequestDispatcher("residentlog.jsp").forward(request, response);
        }
        else if(resident.verifyResidentLogin(inputPassword)){
            session.setAttribute("account",resident);
            request.getRequestDispatcher("residentMainPage.jsp").forward(request, response);
        }
        else{
            message = "Invalid Password";
            request.setAttribute("message", message);
            request.getRequestDispatcher("residentlog.jsp").forward(request, response);
        }
        
    }
    
    protected void loginAdmin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        int inputUsername = Integer.parseInt(request.getParameter("adminID"));
        String inputPassword = request.getParameter("adminPassword");
        String message = null;
        Administrator administrator = administratorDAO.getAdministrator(inputUsername);
        if(administrator == null){
            message = "Account does not exist";
            request.setAttribute("message", message);
            request.getRequestDispatcher("adminlog.jsp").forward(request, response);
        }
        else if(administrator.verifyAdministratorLogin(inputPassword)){
            session.setAttribute("account",administrator);
            request.getRequestDispatcher("administratorMainPage.jsp").forward(request, response);
        }
        else{
            message = "Invalid Password";
            request.setAttribute("message", message);
            request.getRequestDispatcher("adminlog.jsp").forward(request, response);
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
