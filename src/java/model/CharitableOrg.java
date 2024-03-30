/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ydx22
 */
public class CharitableOrg implements UserInterface{
    private String userName;
    private String userEmail;
    private String userPassword;
    private String userType;

    public CharitableOrg(String userName, String userEmail, String userPassword, String userType) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userType = userType;
    }
    @Override
    public void performAction() {
        
    }
    @Override
    public String getUserName() {
        return userName;
    }

   
    @Override
    public String getUserEmail() {
        return userEmail;
    }

    @Override
    public String getUserPassword() {
        return userPassword;
    }

    @Override
    public String getUserType() {
        int a=0;
        return userType;
    }
}
