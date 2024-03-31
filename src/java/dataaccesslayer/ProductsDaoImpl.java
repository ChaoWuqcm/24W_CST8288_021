/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataaccesslayer;
import java.util.List;

import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Author;
import model.Products;

/**
 *
 * @author Dunxing Yu
 */
public class ProductsDaoImpl {

    public ProductsDaoImpl() {
    }
    public List<Products> getAllProducts(int userID) throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<Products> products = null;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "SELECT * form products where userID = ? ORDER BY productID");
             pstmt.setInt(6, userID);
            rs = pstmt.executeQuery();
            products = new ArrayList<Products>();
            while (rs.next()) {
                Products product = new Products();
                product.setProductID(rs.getInt("productID"));
                product.setProductName(rs.getNString("productName"));
                product.setSalePrice(rs.getDouble("salePrice"));
                product.setDiscountPrice(rs.getDouble("discountPrice"));
                product.setInventoryAmount(rs.getDouble("inventoryAmount"));
                product.setDiscountAmount(rs.getDouble("discountAmount"));
                product.setDiscountPrice(rs.getDouble("discountPrice"));
                product.setDonationAmount(rs.getDouble("donationAmount"));
                product.setProductType(rs.getString("productType"));
                product.setSurplusFlage(rs.getString("surplusFlage"));
                product.setUserID(rs.getInt("userID"));
                product.setExpiryDate(rs.getDate("expiryData"));
                products.add(product);
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
        return products;
    }

    public void addProduct(Products product) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            // do not insert productID, it is generated by Database
            String query = "INSERT INTO products "
                           +"(productName, salePrice, inventoryAmount, productType,"
                           +" surplusFlage, userID, expiryDate,"
                           +"discountAmount,discountPrice,donationAmount) "
                           +" VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?))" ;
                           
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, product.getProductName());
            pstmt.setDouble(2, product.getSalePrice());
            pstmt.setDouble(3, product.getInventoryAmount());
            pstmt.setString(4, product.getProductType());
            pstmt.setString(5, product.getSurplusFlage());
            pstmt.setInt(6, product.getUserID());
            pstmt.setDate(7,new java.sql.Date(product.getExpiryDate().getDate()));
            pstmt.setDouble(8, product.getDiscountAmount());
            pstmt.setDouble(9, product.getDiscountPrice());
            pstmt.setDouble(10, product.getDonationAmount());           
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
 public void updateProduct(Products product) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            String query = " delete from products where productID = ?" ;             
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, product.getProductName());
            pstmt.setDouble(2, product.getSalePrice());
            pstmt.setDouble(3, product.getInventoryAmount());
            pstmt.setString(4, product.getProductType());
            pstmt.setString(5, product.getSurplusFlage());
            pstmt.setDate(6,new java.sql.Date(product.getExpiryDate().getDate()));
            pstmt.setDouble(7, product.getDiscountAmount());
            pstmt.setDouble(8, product.getDiscountPrice());
            pstmt.setDouble(9, product.getDonationAmount());
            pstmt.setInt(10, product.getProductID());
            
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
 public void deleteProduct(Products product) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            String query = "delete form products where productID = ?" ;             
            pstmt = con.prepareStatement(query);
             pstmt.setInt(1, product.getProductID());
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
