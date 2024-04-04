/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import businesslayer.DiscountViewBusiessLogic;
import businesslayer.DonationViewBusiessLogic;
import businesslayer.ProductsBusinessLogic;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DiscountView;
import model.DonationView;
import model.Products;
//import model.Products;

/**
 *
 * @author ydx22
 */
public class test {
   
    public static void main(String[] args) {
        
        ProductsBusinessLogic t = new ProductsBusinessLogic();
        ArrayList<Products> products = new ArrayList<>();
        t.deleteProduct(create());
        
        try {
            products = (ArrayList<Products>) t.getAllProducts(3);
            //System.out.println(products.toString());
            System.out.println(products.size());
            for (Products  p : products) {
                System.out.println(p.toString());
            }
        } catch (SQLException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("*******************************************************************************");
        DiscountViewBusiessLogic dc = new DiscountViewBusiessLogic();
        ArrayList<DiscountView> discounts = new ArrayList<>();
        
        try {
        	discounts = (ArrayList<DiscountView>) dc.getAllDiscountProducts();
            //System.out.println(products.toString());
            System.out.println(discounts.size());
            for (DiscountView  d : discounts) {
                System.out.println(d.toString());
            }
        } catch (SQLException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("*******************************************************************************");
        DonationViewBusiessLogic dn = new DonationViewBusiessLogic();
        ArrayList<DonationView> donations = new ArrayList<>();
        
        try {
        	donations = (ArrayList<DonationView>) dn.getAllDonationProducts();
            //System.out.println(products.toString());
            System.out.println(discounts.size());
            for (DonationView  d : donations) {
                System.out.println(d.toString());
            }
        } catch (SQLException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static Products create() {
    	Date date = null;
        String dateString = "2024-04-02";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        try {
            
            date = dateFormat.parse(dateString);
            
        } catch (ParseException e) {

            e.printStackTrace();
        }
    	Products p = new Products();
    	p.setDiscountAmount(20.0);
    	p.setDiscountPrice(25.20);
    	p.setDonationAmount(40.0);
    	//p.setExpiryDate(date.getDate());
    	p.setInventoryAmount(120.00);
    	p.setProductName("apple");
    	p.setProductType("A");
    	p.setSalePrice(50.2);
    	p.setSurplusFlage(null);
    	p.setUserID(3);
    	p.setProductID(12);
    	return p;
    }
    
}