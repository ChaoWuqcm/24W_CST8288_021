/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataaccesslayer;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.DonationView;
/**
 *
 * @author ydx22
 */
public class DonationViewDaoImpl {
    
    public ArrayList<DonationView> getAllDonationProducts() throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<DonationView> donations = null;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "SELECT * form DiscountView ORDER BY productID");
           
            rs = pstmt.executeQuery();
            donations = new ArrayList<DonationView>();
            while (rs.next()) {
                DonationView product = new DonationView();                
                product.setProductID(rs.getInt("productID"));
                product.setProductName(rs.getNString("productName"));
                product.setDonationAmount(rs.getDouble("donationAmount"));
                product.setUserID(rs.getInt("p.userID"));
                product.setDonationCompany("DonationCompany");
                donations.add(product);
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
        return donations;
    }
}
