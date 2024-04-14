/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package UnitTest;

import businesslayer.UserBusinessLogic;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author yehui
 */
public class UserUnitTest {
    
    public UserUnitTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
        
    }
    @Test
    public void testAddUser(){
        UserBusinessLogic userDao = new UserBusinessLogic();
        try {
            
            User testUser = new User("testUser", "testUser@gmail.com", "1111111111", "Qwertyuiop123", "ottawa", "consumer");
            userDao.addUser(testUser);
            List<User> users = userDao.getAllUsers();
            String actual = users.get(users.size()).getUserEmail();
            String expected = "testUser@gmail.com";
            assertEquals(expected,actual);
        } catch (SQLException ex) {
            Logger.getLogger(UserUnitTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
