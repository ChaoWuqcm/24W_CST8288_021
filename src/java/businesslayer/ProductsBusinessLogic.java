/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package businesslayer;

import dataaccesslayer.AuthorsDaoImpl;
import dataaccesslayer.ProductsDaoImpl;
import java.sql.SQLException;
import java.util.List;
import model.Author;
import model.Products;

/**
 *
 * @author Dunxing Yu
 */
public class ProductsBusinessLogic {
    private ProductsDaoImpl productsDao = null;

    public ProductsBusinessLogic() {
        productsDao = new ProductsDaoImpl();
    }

    
     public List<Products> getAllProducts(int userID)throws SQLException {
        return productsDao.getAllProducts(userID);
    }

    public void addProduct(Products product) {
        productsDao.addProduct(product);
    }
    public void updateProduct(Products product) {
        productsDao.updateProduct(product);
    }
    public void deleteProduct(Products product) {
         productsDao.deleteProduct(product);
    }
}
