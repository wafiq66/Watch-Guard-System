/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rimba.dao;

import model.bean.Visitor;

/**
 *
 * @author user
 */
public interface VisitorDAO {
    
    Visitor getVisitor(String visitorICNumber);
    public void registerVisitor(Visitor visitor);
}
