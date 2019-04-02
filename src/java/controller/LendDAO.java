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
import model.Husbandry;
import model.Lend;

/**
 *
 * @author ADMIN
 */
public class LendDAO {
    
     static Connection con = ConnectionManager.getConnection();
    static ResultSet rs = null;

    public static Lend GetLend(String id) throws SQLException {
        String sql = "SELECT * FROM lend WHERE id='"+ id +"'";
        PreparedStatement ps = con.prepareCall(sql);
        rs = ps.executeQuery();
        Lend h = new Lend();
        while(rs.next())  {
        h.setId(rs.getString("id"));
        h.setInterestRate(rs.getFloat("interestRate"));
        h.setLendingamountmaximum(rs.getFloat("lendingamountmaximum"));
        h.setName(rs.getString("name"));
        h.setTerm(rs.getString("term"));
        }
            //    con.close();
        return h;
    }
    
    public static void main(String[] args) throws SQLException {
        Lend l = LendDAO.GetLend("lo01");
        System.out.print(l.getName());
    }
}
