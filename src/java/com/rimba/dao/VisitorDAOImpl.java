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
import model.bean.Visitor;

/**
 *
 * @author user
 */
public class VisitorDAOImpl implements VisitorDAO{
    private Connection conn;

    
    public VisitorDAOImpl(){
        this.conn = Connect.getConnection();
    }
    
    @Override
    public Visitor getVisitor(String visitorICNumber) {
        this.conn = Connect.getConnection();
        Visitor visitor = null;
        String sql = "SELECT * " +
                     "FROM VISITOR " +
                     "WHERE VISITORICNUMBER =?";

        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, visitorICNumber);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    visitor = new Visitor(
                        resultSet.getString("VISITORICNUMBER"),
                        resultSet.getString("VISITORNAME")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error fetching visitor: " + e.getMessage(), e);
        }

        return visitor;
    }
    
    
    @Override
    public void registerVisitor(Visitor visitor) {
        this.conn = Connect.getConnection();
        String checkSql = "SELECT * FROM VISITOR WHERE VISITORICNUMBER = ?";
        String insertSql = "INSERT INTO VISITOR (VISITORICNUMBER, VISITORNAME) VALUES (?, ?)";

        try (PreparedStatement checkStatement = conn.prepareStatement(checkSql);
             PreparedStatement insertStatement = conn.prepareStatement(insertSql)) {
            checkStatement.setString(1, visitor.getVisitorICNumber());
            try (ResultSet resultSet = checkStatement.executeQuery()) {
                if (!resultSet.next()) {
                    insertStatement.setString(1, visitor.getVisitorICNumber());
                    insertStatement.setString(2, visitor.getVisitorName());
                    insertStatement.executeUpdate();
                } else {
                    System.out.println("Visitor with IC number " + visitor.getVisitorICNumber() + " already exists.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error registering visitor: " + e.getMessage(), e);
        }
    }
}
