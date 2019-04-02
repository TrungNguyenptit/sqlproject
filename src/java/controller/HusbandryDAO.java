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

/**
 *
 * @author ADMIN
 */
public class HusbandryDAO {

    static Connection con = ConnectionManager.getConnection();
    static ResultSet rs = null;

    public static Husbandry GetHusbandry(String id) throws SQLException {
        String sql = "SELECT * FROM husbandry WHERE id='"+ id +"'";
        PreparedStatement ps = con.prepareCall(sql);
        rs = ps.executeQuery();
        Husbandry h = new Husbandry();
        while(rs.next())  {
        h.setId(rs.getString("id"));
        h.setInterestPaymentCycle(rs.getString("interestPaymentCycle"));
        h.setSourcesofinterestPayment(rs.getString("sourcesofinterestPayment"));
        h.setDespositCycle(rs.getString("despositCycle"));
        h.setMinimumamountdespositcycle(rs.getFloat("minimumamountdespositcycle"));
        h.setName(rs.getString("name"));
        h.setTerm(rs.getString("term"));
        h.setTypeofmoney(rs.getString("typeofmoney"));
        h.setNote(rs.getString("note"));
        }
          //      con.close();
        return h;
    }

    public static void main(String[] args) throws SQLException {
    }
}
