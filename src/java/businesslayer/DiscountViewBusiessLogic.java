/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package businesslayer;

import dataaccesslayer.DiscountViewDaoImpl;
import java.sql.SQLException;
import java.util.ArrayList;
import model.DiscountView;

/**
 *
 * @author Dunxing Yu
 */
public class DiscountViewBusiessLogic {
    
    private DiscountViewDaoImpl discountViewDao = null;

    public DiscountViewBusiessLogic() {
        discountViewDao = new DiscountViewDaoImpl();
    }
    public ArrayList<DiscountView> getAllDiscountProducts() throws SQLException {
        return discountViewDao.getAllDiscountProducts();
    }
    
    
}
