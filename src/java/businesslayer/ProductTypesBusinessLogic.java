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
    /**

    Adds a new product type to the database.
    @param type The ProductTypes object representing the new product type to be added.
    */
    public void addProductType(ProductTypes type) {
    productTypesDao.addProductType(type);
    }
    /**

    Deletes a product type from the database based on its ID.
    @param id The ID of the product type to be deleted.
    */
    public void deleteProductTypes(int id) {
    productTypesDao.deleteProductTypes(id);
    }
}
