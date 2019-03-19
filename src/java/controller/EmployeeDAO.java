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
import model.Employee;
import model.Saving;

/**
 *
 * @author ADMIN
 */
public class EmployeeDAO {

    static Connection con = ConnectionManager.getConnection();
    static ResultSet rs = null;

    public static Employee GetEmployee(String id) throws SQLException {
        String sql = "SELECT * FROM employee WHERE id='"+ id +"'";
        PreparedStatement ps = con.prepareCall(sql);
        rs = ps.executeQuery();
        Employee e = new Employee();
        while(rs.next())  {
        e.setIdemployeeAccount(rs.getString("idemployeeAccount"));
        e.setId(rs.getString("id"));
        e.setDuty(rs.getString("role"));
        e.setIdProfile(rs.getString("idprofile"));
        }
        return e;
    }

    public static void main(String[] args) throws SQLException {
    }
}
