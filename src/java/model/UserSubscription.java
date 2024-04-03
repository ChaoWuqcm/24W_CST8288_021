/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Qi Cheng
 */
public class UserSubscription {
    private int subscriptionID;
    private int userID;
    private String productType;
    private String communicationMethod;
    private String userEmail;
    private String userPhoneNumber;
    private String userCity;
    private String surplusFlag;
    
    public UserSubscription(){
        
    }
    
    public UserSubscription(int userID, String productType, String communicationMethod, String userEmail, String userPhoneNumber, String userCity, String surplusFlag) {
        this.userID = userID;
        this.productType = productType;
        this.communicationMethod = communicationMethod;
        this.userEmail = userEmail;
        this.userPhoneNumber = userPhoneNumber;
        this.userCity = userCity;
        this.surplusFlag = surplusFlag;
    }

    public int getSubscriptionID() {
        return subscriptionID;
    }

    public void setSubscriptionID(int subscriptionID) {
        this.subscriptionID = subscriptionID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

     public String getCommunicationMethod() {
        return communicationMethod;
    }

    public void setCommunicationMethod(String communicationMethod) {
        this.communicationMethod = communicationMethod;
    }
    
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public String getUserCity() {
        return userCity;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity;
    }

    public String getSurplusFlag() {
        return surplusFlag;
    }

    public void setSurplusFlag(String surplusFlag) {
        this.surplusFlag = surplusFlag;
    }
    
   
}
