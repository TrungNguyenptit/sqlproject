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
import model.Saving;

/**
 *
 * @author ADMIN
 */
public class SavingDAO {
    static Connection con = ConnectionManager.getConnection();
    static ResultSet rs = null;

       public static ArrayList<Saving> GetSaving() throws SQLException {
        ArrayList<Saving> savingList = new ArrayList<>();
        String sql = "SELECT * FROM saving";
        PreparedStatement ps = con.prepareCall(sql);
        rs = ps.executeQuery();
        while( rs.next())
        {
            Saving s = new Saving();
            s.setInterestTotal(rs.getFloat("interestTotal"));
            s.setDepositTotal(rs.getFloat("depositTotal"));
            s.setProvisionDate(rs.getDate("provisionDate"));
            s.setExpirationDate(rs.getDate("expirationDate"));
            s.setId(rs.getString("id"));
            s.setIdcustomer(rs.getString("idcustomer"));
            s.setIdemployee(rs.getString("idemployee"));
            s.setIdhusbandry(rs.getString("idhusbandry"));
            s.setTerm(rs.getString("term"));
            s.setTypeofmoney(rs.getString("typeofmoney"));
            if(rs.getString("mo")==null)
                s.setMo(false);
            else
                s.setMo(true);
            savingList.add(s);
        }
        return savingList;
    }
       
      public static void main(String[] args) throws SQLException {
        SavingDAO sdao = new SavingDAO();
        ArrayList<Saving> savingList = sdao.GetSaving();
        for(Saving s:savingList)
        {
            System.out.println(s.getInterestTotal());
        }
    }
}
