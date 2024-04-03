/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import businesslayer.ProductsBusinessLogic;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Products;

/**
 *
 * @author ydx22
 */
public class test {
   
    public static void main(String[] args) {
        
        ProductsBusinessLogic t = new ProductsBusinessLogic();
        ArrayList<Products> products = new ArrayList<>();
        try {
            products = (ArrayList<Products>) t.getAllProducts(3);
        } catch (SQLException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
