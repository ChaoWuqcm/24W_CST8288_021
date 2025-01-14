/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataaccesslayer;

import model.ProductTypes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author Dunxing Yu
 */
public class ProductTypesDaoImpl {

    public ProductTypesDaoImpl() {
    }
    
    public ArrayList<ProductTypes> getAllProductTypes() throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<ProductTypes> types = null;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "SELECT * from ProductTypes");
  
            rs = pstmt.executeQuery();
            types = new ArrayList<ProductTypes>();
            while (rs.next()) {
                ProductTypes type = new ProductTypes();
                
                type.setType(rs.getString("productType")); 
                types.add(type);
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
        return types;
    }
}