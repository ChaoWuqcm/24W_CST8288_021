/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author Dunxing Yu
 */
public class Products {
   private String productName;
   private double salePrice;
   private double discountPrice;
   private double inventoryAmount;
   private double discountAmount;
   private double donationAmount;
   private String productType;
   private char surplusFlage;
   private int userID;
   private Date expiryDate;
   
   public Products(String productName, double salePrice, double discountPrice, 
                    double inventoryAmount, double discountAmount, double donationAmount, 
                    String productType, char surplusFlage, int userID, Date expiryDate) {
        this.productName = productName;
        this.salePrice = salePrice;
        this.discountPrice = discountPrice;
        this.inventoryAmount = inventoryAmount;
        this.discountAmount = discountAmount;
        this.donationAmount = donationAmount;
        this.productType = productType;
        this.surplusFlage = surplusFlage;
        this.userID = userID;
        this.expiryDate = expiryDate;
    }
  
    public String getProductName() {
        return productName;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public double getDiscountPrice() {
        return discountPrice;
    }

    public double getInventoryAmount() {
        return inventoryAmount;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public double getDonationAmount() {
        return donationAmount;
    }

    public String getProductType() {
        return productType;
    }

    public char getSurplusFlage() {
        return surplusFlage;
    }

    public int getUserID() {
        return userID;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }
    
}
