/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package businesslayer;

import dataaccesslayer.DonationViewDaoImpl;
import java.sql.SQLException;
import java.util.ArrayList;
import model.DonationView;

/**
 *
 * @author Dunxing Yu
 */
public class DonationViewBusiessLogic {
    
    private DonationViewDaoImpl donationViewDao = null;

    public DonationViewBusiessLogic() {
        donationViewDao = new DonationViewDaoImpl();
    }
    public ArrayList<DonationView> getAllDonationProducts() throws SQLException {
        return donationViewDao.getAllDonationProducts();
    }  
}
