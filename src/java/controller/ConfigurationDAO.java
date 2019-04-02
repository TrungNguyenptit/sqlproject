/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Interestrate;

/**
 *
 * @author Admin
 */
public class ConfigurationDAO {

    static Connection con = ConnectionManager.getConnection();
    static ResultSet rs = null;
    
    public static float SetInterestrate(String id, String typeOfMoney, float interestrate) throws SQLException {
        String sql = " ";
        if(interestrate>=0)
        {
        if ("VND".equalsIgnoreCase(typeOfMoney)) {
            sql = "UPDATE interestrate SET vndinterestrate = '" + interestrate + "' WHERE id='" + id + "'";
        } else if ("USD".equalsIgnoreCase(typeOfMoney)) {
            sql = "UPDATE interestrate SET usdinterestrate = '" + interestrate + "' WHERE id='" + id + "'";
        } else if ("EUR".equalsIgnoreCase(typeOfMoney)) {
            sql = "UPDATE interestrate SET eurinterestrate = '" + interestrate + "' WHERE id='" + id + "'";
        } else if ("AUD".equalsIgnoreCase(typeOfMoney)) {
            sql = "UPDATE interestrate SET audinterestrate = '" + interestrate + "' WHERE id='" + id + "'";
        }

        PreparedStatement ps = con.prepareCall(sql);
        ps.executeUpdate();
    //    con.close();
        }
        return interestrate;
    }
}
