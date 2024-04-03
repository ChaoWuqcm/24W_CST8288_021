/* File: AuthorsDataAccessObjectImplementation.java
 * AuthorDTO: Stanley Pieda
 * Date: 2015
 * Description: Demonstration of DAO Design Pattern with Servlet website
 * References:
 * Ram N. (2013).  Data Access Object Design Pattern or DAO Pattern [blog] Retrieved from
 * http://ramj2ee.blogspot.in/2013/08/data-access-object-design-pattern-or.html
 */
package dataaccesslayer;

import java.util.List;

import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.User;
import model.UserSubscription;

public class UserSubscriptionDaoImpl {

    public UserSubscriptionDaoImpl() {
    }
    
      public List<UserSubscription> getAllUserSubscription() throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<UserSubscription> userSubscriptions = null;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "SELECT * FROM UserSubscription ORDER BY subscriptionID");
            rs = pstmt.executeQuery();
            userSubscriptions = new ArrayList<UserSubscription>();
            while (rs.next()) {
                UserSubscription userSubscription = new UserSubscription();
                userSubscription.setSubscriptionID(rs.getInt("usersubscriptionID"));
                userSubscription.setUserID(rs.getInt("userID")); 
                userSubscription.setProductType(rs.getString("productType"));
                userSubscription.setCommunicationMethod(rs.getString("communicationMethod"));
                userSubscription.setUserEmail(rs.getString("userEmail"));
                userSubscription.setUserPhoneNumber(rs.getString("userPhoneNumber"));
                userSubscription.setUserCity(rs.getString("userCity"));
                userSubscription.setSurplusFlag(rs.getString("surplusFlag"));
                userSubscriptions.add(userSubscription);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;

        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return userSubscriptions;
    }
      
    public List<UserSubscription> getAllUserSubscriptionByPTCity(String productType, String userCity) throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<UserSubscription> userSubscriptions = null;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "SELECT * FROM UserSubscription where productType = ? and userCity = ? and ORDER BY subscriptionID");
            pstmt.setString(1, productType);
            pstmt.setString(2, userCity);
            rs = pstmt.executeQuery();
            userSubscriptions = new ArrayList<UserSubscription>();
            while (rs.next()) {
                UserSubscription userSubscription = new UserSubscription();
                userSubscription.setSubscriptionID(rs.getInt("usersubscriptionID"));
                userSubscription.setUserID(rs.getInt("userID")); 
                userSubscription.setProductType(rs.getString("productType"));
                userSubscription.setCommunicationMethod(rs.getString("communicationMethod"));
                userSubscription.setUserEmail(rs.getString("userEmail"));
                userSubscription.setUserPhoneNumber(rs.getString("userPhoneNumber"));
                userSubscription.setUserCity(rs.getString("userCity"));
                userSubscription.setSurplusFlag(rs.getString("surplusFlag"));
                userSubscriptions.add(userSubscription);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;

        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return userSubscriptions;
    }
    
     public List<UserSubscription> getAllUserSubscriptionByEmail(String productType, String userCity) throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<UserSubscription> userSubscriptions = null;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "SELECT * FROM UserSubscription where productType = ? and userCity = ? and userEmail IS NOT NULL ORDER BY subscriptionID");
            pstmt.setString(1, productType);
            pstmt.setString(2, userCity);
            rs = pstmt.executeQuery();
            userSubscriptions = new ArrayList<UserSubscription>();
            while (rs.next()) {
                UserSubscription userSubscription = new UserSubscription();
                userSubscription.setSubscriptionID(rs.getInt("usersubscriptionID"));
                userSubscription.setUserID(rs.getInt("userID")); 
                userSubscription.setProductType(rs.getString("productType"));
                userSubscription.setCommunicationMethod(rs.getString("communicationMethod"));
                userSubscription.setUserEmail(rs.getString("userEmail"));
                userSubscription.setUserPhoneNumber(rs.getString("userPhoneNumber"));
                userSubscription.setUserCity(rs.getString("userCity"));
                userSubscription.setSurplusFlag(rs.getString("surplusFlag"));
                userSubscriptions.add(userSubscription);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;

        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return userSubscriptions;
    }
    
     public List<UserSubscription> getAllUserSubscriptionByPhone(String productType, String userCity) throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<UserSubscription> userSubscriptions = null;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "SELECT * FROM UserSubscription where productType = ? and userCity = ? and userPhoneNumber IS NOT NULL ORDER BY subscriptionID");
            pstmt.setString(1, productType);
            pstmt.setString(2, userCity);
            rs = pstmt.executeQuery();
            userSubscriptions = new ArrayList<UserSubscription>();
            while (rs.next()) {
                UserSubscription userSubscription = new UserSubscription();
                userSubscription.setSubscriptionID(rs.getInt("usersubscriptionID"));
                userSubscription.setUserID(rs.getInt("userID")); 
                userSubscription.setProductType(rs.getString("productType"));
                userSubscription.setCommunicationMethod(rs.getString("communicationMethod"));
                userSubscription.setUserEmail(rs.getString("userEmail"));
                userSubscription.setUserPhoneNumber(rs.getString("userPhoneNumber"));
                userSubscription.setUserCity(rs.getString("userCity"));
                userSubscription.setSurplusFlag(rs.getString("surplusFlag"));
                userSubscriptions.add(userSubscription);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;

        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return userSubscriptions;
    }
     
    public UserSubscription getUserSubscription(int userID) throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        UserSubscription userSubscription = new UserSubscription();
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "SELECT * FROM UserSubscription where userID = ?");
            pstmt.setInt(1, userID);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                 userSubscription.setSubscriptionID(rs.getInt("usersubscriptionID"));
                userSubscription.setUserID(rs.getInt("userID")); 
                userSubscription.setProductType(rs.getString("productType"));
                userSubscription.setCommunicationMethod(rs.getString("communicationMethod"));
                userSubscription.setUserEmail(rs.getString("userEmail"));
                userSubscription.setUserPhoneNumber(rs.getString("userPhoneNumber"));
                userSubscription.setUserCity(rs.getString("userCity"));
                userSubscription.setSurplusFlag(rs.getString("surplusFlag"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;

        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return userSubscription;
    } 
    
    public void addUserSubscription(UserSubscription userSubscription) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            // do not insert userID, it is generated by Database
            pstmt = con.prepareStatement("INSERT INTO UserSubscription (userID, productType, communicationMethod, userEmail, userPhoneNumber, userCity, surplusFlag) "
                    + "VALUES(?, ?, ?, ?, ?, ?, ?)");
            pstmt.setInt(1, userSubscription.getUserID());
            pstmt.setString(2, userSubscription.getProductType());
            pstmt.setString(3, userSubscription.getCommunicationMethod());
            pstmt.setString(4, userSubscription.getUserEmail());
            pstmt.setString(5, userSubscription.getUserPhoneNumber());
            pstmt.setString(6, userSubscription.getUserCity());
            pstmt.setString(7, userSubscription.getSurplusFlag());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    
    public void updateUserSubscription(UserSubscription userSubscription) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();        
            pstmt = con.prepareStatement("Update UserSubscription set productType = ?, communicationMethod=?, userEmail = ?, userPhoneNumber = ?, "
                    + "userCity = ? surplusFlag = ? where userID = ?");
            pstmt.setString(1, userSubscription.getProductType());
            pstmt.setString(2, userSubscription.getCommunicationMethod());
            pstmt.setString(3, userSubscription.getUserEmail());
            pstmt.setString(4, userSubscription.getUserPhoneNumber());
            pstmt.setString(5, userSubscription.getUserCity());
            pstmt.setString(6, userSubscription.getSurplusFlag());
            pstmt.setInt(7, userSubscription.getUserID());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    
    public void deleteUserSubscription(UserSubscription userSubscription) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement("Delete form UserSubscription where userID = ?" );             
            pstmt.setInt(1, userSubscription.getUserID());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

}
