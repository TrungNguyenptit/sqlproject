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
import java.sql.Statement;
import model.EmployeeAccount;

/**
 *
 * @author ADMIN
 */
public class EmployeeAccountDAO {
   static Connection con = ConnectionManager.getConnection();
    static ResultSet rs = null;

    public static EmployeeAccount LogIn(EmployeeAccount  acc) throws SQLException {
        String username = acc.getUsername();
        String password = acc.getPassword();
        String sql = "SELECT * FROM employeeaccount WHERE username='" + username + "' AND password='" + password + "'";
        PreparedStatement ps = con.prepareCall(sql);
        rs = ps.executeQuery();
        boolean more = rs.next();
        if (!more) {
            System.out.println("Sorry, you are not a registered user! Please sign up first");
            acc.setValid(false);
        } //if user exists set the isValid variable to true
        else if (more) {
            System.out.println("Yes");
            acc.setValid(true);
        }
        return acc;
    }

    public static void main(String[] args) throws SQLException {
        EmployeeAccountDAO dao = new EmployeeAccountDAO();
    }
}
