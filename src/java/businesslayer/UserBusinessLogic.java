/* File: UserBusinessLogic.java
 * Date: 2024
 * Description: Demonstration of DAO Design Pattern with Servlet website
 */
package businesslayer;

import dataaccesslayer.UserDaoImpl;
import java.util.List;
import java.sql.SQLException;
import java.util.ArrayList;
import model.User;

public class UserBusinessLogic {

    private UserDaoImpl userDao = null;

    public UserBusinessLogic() {
        userDao = new UserDaoImpl();
    }

    public ArrayList<User> getAllUsers() throws SQLException {
        return userDao.getAllUesrs();
    }

    public List<User> getAllUsersByUT(String userType) throws SQLException {
        return userDao.getAllUesrsByUT(userType);
    }
    
    public int getUesrID(String userEmail) throws SQLException {
        return userDao.getUesrID(userEmail);
    } 
     
    public User getUesrByEmail(String userEmail) throws SQLException {
        return userDao.getUesrByEmail(userEmail);
    } 
    
    public void addUser(User user) throws SQLException {
        if(getUesrByEmail(user.getUserEmail())==null){
            userDao.addUser(user);
        }    
    }
    
    public void updateUser(User user){
        userDao.updateUser(user);
    }
    
    public void updateUserPass(User user) {
        userDao.updateUserPass(user);
    }
    
    public void deleteUser(User user){
        userDao.deleteUser(user);
    }
}
