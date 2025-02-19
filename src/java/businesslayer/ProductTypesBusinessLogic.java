/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package businesslayer;

import dataaccesslayer.ProductTypesDaoImpl;
import java.sql.SQLException;
import java.util.ArrayList;
import model.ProductTypes;

/**

The ProductTypesBusinessLogic class provides business logic operations for managing product types.

It interacts with the ProductTypesDaoImpl class to perform CRUD (Create, Read,Delete) operations on product types.

@author Dunxing Yu
*/
public class ProductTypesBusinessLogic {
    private ProductTypesDaoImpl productTypesDao = null;

    /**

    Constructs a new ProductTypesBusinessLogic instance and initializes the associated DAO.
    */
    public ProductTypesBusinessLogic() {
    productTypesDao = new ProductTypesDaoImpl();
    }
    /**

    Retrieves all product types from the database.
    @return An ArrayList containing all product types retrieved from the database.
    @throws SQLException If an SQL exception occurs while accessing the database.
    */
    public ArrayList<ProductTypes> getAllProductTypes() throws SQLException {
    return productTypesDao.getAllProductTypes();
    }
   

    
}