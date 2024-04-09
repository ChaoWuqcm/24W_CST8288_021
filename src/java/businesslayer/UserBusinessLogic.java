/* File: AuthorsBusinessLogic.java
 * AuthorDTO: Stanley Pieda
 * Date: 2015
 * Description: Demonstration of DAO Design Pattern with Servlet website
 */
package businesslayer;

import dataaccesslayer.AuthorsDaoImpl;
import dataaccesslayer.UserDaoImpl;
import java.util.List;
import java.sql.SQLException;
import model.Author;
import model.User;

public class UserBusinessLogic {

    private UserDaoImpl userDao = null;

    public UserBusinessLogic() {
        userDao = new UserDaoImpl();
    }

    public List<User> getAllUsers() throws SQLException {
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
    
    public void deleteUser(String email){
        userDao.deleteUser(email);
    }
}