/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Chao
 */
public class UserFactory {
    public static UserInterface createUser(String name, String email, String password,String userType) {
        switch (userType.toLowerCase()) {
            case "retailer":
                return new Retailer(name, email, password,userType);
            case "charitable organization":
                return new CharitableOrganization(name, email, password,userType);
            case "consumer":
                return new Consumer(name, email, password,userType);
            default:
                throw new IllegalArgumentException("Invalid user type: " + userType);
        }
    }
}
