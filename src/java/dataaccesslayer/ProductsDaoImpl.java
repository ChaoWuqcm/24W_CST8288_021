package dataaccesslayer;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

import model.Products;

public class ProductsDaoImpl {

    public ProductsDaoImpl() {
    }

    public Products getProductsById(int productId) throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<Products> products = null;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "SELECT * from products where productId = ?");
            pstmt.setInt(1, productId);
            rs = pstmt.executeQuery();
            products = new ArrayList<>();
            while (rs.next()) {
                Products product = new Products();
                product.setProductID(rs.getInt("productID"));
                product.setProductName(rs.getString("productName"));
                product.setSalePrice(rs.getDouble("salePrice"));
                product.setDiscountPrice(rs.getDouble("discountPrice"));
                product.setInventoryAmount(rs.getDouble("inventoryAmount"));
                product.setDiscountAmount(rs.getDouble("discountAmount"));
                product.setDonationAmount(rs.getDouble("donationAmount"));
                product.setProductType(rs.getString("productType"));
                product.setSurplusFlage(rs.getString("surplusFlage"));
                product.setUserID(rs.getInt("userID"));
                product.setExpiryDate(rs.getDate("expiryDate"));
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
                if (pstmt != null) {
                    pstmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return products.get(0);
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
                    "SELECT * from products where userID = ? ORDER BY productID");
            pstmt.setInt(1, userID);
            rs = pstmt.executeQuery();
            products = new ArrayList<>();
            while (rs.next()) {
                Products product = new Products();
                product.setProductID(rs.getInt("productID"));
                product.setProductName(rs.getString("productName"));
                product.setSalePrice(rs.getDouble("salePrice"));
                product.setDiscountPrice(rs.getDouble("discountPrice"));
                product.setInventoryAmount(rs.getDouble("inventoryAmount"));
                product.setDiscountAmount(rs.getDouble("discountAmount"));
                product.setDonationAmount(rs.getDouble("donationAmount"));
                product.setProductType(rs.getString("productType"));
                product.setSurplusFlage(rs.getString("surplusFlage"));
                product.setUserID(rs.getInt("userID"));
                product.setExpiryDate(rs.getDate("expiryDate"));
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
                if (pstmt != null) {
                    pstmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return products;
    }

    public List<Products> getAllProductsByCondition(List<String> type, String location) throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<Products> products = null;
        StringJoiner joiner = new StringJoiner(",");
        for (String str : type) {
            joiner.add(str);
        }
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement("SELECT * from products p where p.discountAmount is not null and FIND_IN_SET(productType,?)  ORDER BY productID");
            pstmt.setString(1, joiner.toString());
            rs = pstmt.executeQuery();
            products = new ArrayList<>();
            while (rs.next()) {
                Products product = new Products();
                product.setProductID(rs.getInt("productID"));
                product.setProductName(rs.getString("productName"));
                product.setSalePrice(rs.getDouble("salePrice"));
                product.setDiscountPrice(rs.getDouble("discountPrice"));
                product.setInventoryAmount(rs.getDouble("inventoryAmount"));
                product.setDiscountAmount(rs.getDouble("discountAmount"));
                product.setDonationAmount(rs.getDouble("donationAmount"));
                product.setProductType(rs.getString("productType"));
                product.setSurplusFlage(rs.getString("surplusFlage"));
                product.setUserID(rs.getInt("userID"));
                product.setExpiryDate(rs.getDate("expiryDate"));
                product.setUserCity(rs.getString("userCity"));
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
                if (pstmt != null) {
                    pstmt.close();
                }
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
            String query = "INSERT INTO products "
                    + "(productName, salePrice, inventoryAmount, productType,"
                    + " surplusFlage, userID, expiryDate,"
                    + "discountAmount, discountPrice, donationAmount, userCity) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, product.getProductName());
            pstmt.setDouble(2, product.getSalePrice());
            pstmt.setDouble(3, product.getInventoryAmount());
            pstmt.setString(4, product.getProductType());
            pstmt.setString(5, product.getSurplusFlag());
            pstmt.setInt(6, product.getUserID());
            pstmt.setDate(7, product.getExpiryDate());
            pstmt.setDouble(8, product.getDiscountAmount());
            pstmt.setDouble(9, product.getDiscountPrice());
            pstmt.setDouble(10, product.getDonationAmount());
            pstmt.setString(11, product.getUserCity());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
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
            String query = "UPDATE products SET "
                    + "productName=?, "
                    + "salePrice=?, "
                    + "inventoryAmount=?, "
                    + "productType=?, "
                    + "surplusFlage=?, "
                    + "expiryDate=?, "
                    + "discountAmount=?, "
                    + "discountPrice=?, "
                    + "donationAmount=? "
                    + "WHERE productID=?";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, product.getProductName());
            pstmt.setDouble(2, product.getSalePrice());
            pstmt.setDouble(3, product.getInventoryAmount());
            pstmt.setString(4, product.getProductType());
            pstmt.setString(5, product.getSurplusFlag());
            pstmt.setDate(6, product.getExpiryDate());
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
            String query = "DELETE FROM products WHERE productID=?";
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
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public void updateDonation(int id, double amount) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            String query = "UPDATE products SET donationAmount=? WHERE productID=?";
            pstmt = con.prepareStatement(query);
            pstmt.setDouble(1, amount);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public void updateDiscount(int id, double amount) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            String query = "UPDATE products SET discountAmount=? WHERE productID=?";
            pstmt = con.prepareStatement(query);
            pstmt.setDouble(1, amount);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public void updateSurplusProducts() {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            String selectSurplusQuery = "SELECT * FROM products WHERE expiryDate <= DATE_ADD(CURDATE(), INTERVAL 7 DAY) AND inventoryAmount > 200";
            pstmt = con.prepareStatement(selectSurplusQuery);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int productId = rs.getInt("productID");
                double newSalePrice = rs.getDouble("salePrice") * 0.9; // Example: applying a 10% discount
                updateSalePrice(productId, newSalePrice); // Assuming a method to update the sale price
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void updateSalePrice(int productId, double newSalePrice) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            String updateSalePriceQuery = "UPDATE products SET salePrice = ? WHERE productID = ?";
            pstmt = con.prepareStatement(updateSalePriceQuery);
            pstmt.setDouble(1, newSalePrice);
            pstmt.setInt(2, productId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
