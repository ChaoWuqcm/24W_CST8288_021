/* File: AuthorsBusinessLogic.java
 * AuthorDTO: Stanley Pieda
 * Date: 2015
 * Description: Demonstration of DAO Design Pattern with Servlet website
 */
package businesslayer;

import dataaccesslayer.AuthorsDaoImpl;
import dataaccesslayer.UserDaoImpl;
import dataaccesslayer.UserSubscriptionDaoImpl;
import java.util.List;
import java.sql.SQLException;
import model.User;
import model.UserSubscription;

public class UserSubscriptionBusinessLogic {

    private UserSubscriptionDaoImpl userSubscriptionDao = null;

    public UserSubscriptionBusinessLogic() {
        userSubscriptionDao = new UserSubscriptionDaoImpl();
    }

    public List<UserSubscription> getAllUserSubscription() throws SQLException {
        return userSubscriptionDao.getAllUserSubscription();
    }

    public List<UserSubscription> getAllUserSubscriptionByPTCity(String productType, String userCity) throws SQLException {
        return userSubscriptionDao.getAllUserSubscriptionByPTCity(productType, userCity);
    }
    
    public List<UserSubscription> getAllUserSubscriptionByEmail(String productType, String userCity) throws SQLException{
        return userSubscriptionDao.getAllUserSubscriptionByEmail(productType, userCity);
    }
    
     public List<UserSubscription> getAllUserSubscriptionByPhone(String productType, String userCity) throws SQLException{
        return userSubscriptionDao.getAllUserSubscriptionByPhone(productType, userCity);
    }
    
    public List<UserSubscription> getUserSubscription(int userID) throws SQLException {
        return userSubscriptionDao.getUserSubscription(userID);
    } 
    
    public void addUserSubscription(UserSubscription userSubscription) {
       userSubscriptionDao.addUserSubscription(userSubscription);
    }
    
    public void updateUserSubscription(UserSubscription userSubscription){
        userSubscriptionDao.updateUserSubscription(userSubscription);
    }
    
    public void deleteUserSubscription(UserSubscription userSubscription){
         userSubscriptionDao.deleteUserSubscription(userSubscription);
    }
    
    public void deleteUserSubscriptionByID(int userSubscriptionID){
        userSubscriptionDao.deleteUserSubscriptionByID(userSubscriptionID);
    }
    
}
