/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Dunxing Yu
 */
public class UserSubscription {
    private int userID;
    private String productType;
    private String userCity;

    public UserSubscription(int userID, String productType, String userCity) {
        this.userID = userID;
        this.productType = productType;
        this.userCity = userCity;
        
    }

    public int getUserID() {
        return userID;
    }

    public String getProductType() {
        return productType;
    }

    public String getUserCity() {
        return userCity;
    }
    
}
