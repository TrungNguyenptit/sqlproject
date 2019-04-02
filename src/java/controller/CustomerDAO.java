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
import java.util.ArrayList;
import model.Customer;
import model.Saving;

/**
 *
 * @author ADMIN
 */
public class CustomerDAO {

    static Connection con = ConnectionManager.getConnection();
    static ResultSet rs = null;

    public static Customer GetCustomer(String id) throws SQLException {
        String sql = "SELECT * FROM customer WHERE id='"+ id +"'";
        PreparedStatement ps = con.prepareCall(sql);
        rs = ps.executeQuery();
        Customer cus = new Customer();
        while(rs.next())  {
        cus.setIdaccount(rs.getString("idaccount"));
        cus.setId(rs.getString("id"));
        cus.setIdprofile(rs.getString("idprofile"));
        cus.setJob(rs.getString("job"));
        cus.setPassportNo(rs.getString("passportNo")); }
             //   con.close();
        return cus;
    }

    public static void main(String[] args) throws SQLException {
        CustomerDAO cDAO = new CustomerDAO();
        Customer c = cDAO.GetCustomer("cus02");
        System.out.println(c.getIdprofile());
    }
}
