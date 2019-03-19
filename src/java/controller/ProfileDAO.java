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
import model.Profile;

/**
 *
 * @author ADMIN
 */
public class ProfileDAO {

    static Connection con = ConnectionManager.getConnection();
    static ResultSet rs = null;

    public static Profile GetProfile(String id) throws SQLException {
        String sql = "SELECT * FROM profile WHERE id='"+ id +"'";
        PreparedStatement ps = con.prepareCall(sql);
        rs = ps.executeQuery();
        Profile p = new Profile();
        while(rs.next())  {
        p.setAddress(rs.getString("address"));
        p.setDateofbirth(rs.getDate("dateofbirth"));
        p.setId(rs.getString("id"));
        p.setName(rs.getString("name"));
        p.setTel(rs.getString("tel"));
        }
        return p;
    }

    public static void main(String[] args) throws SQLException {
        ProfileDAO pdao = new ProfileDAO();
        Profile p = pdao.GetProfile("pro01");
        System.out.println(p.getName());
        System.out.println(p.getId());
    }
}
