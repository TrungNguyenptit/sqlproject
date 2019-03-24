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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import model.Saving;

/**
 *
 * @author ADMIN
 */
public class SavingDAO {

    static Connection con = ConnectionManager.getConnection();
    static ResultSet rs = null;

    public static ArrayList<Saving> GetSaving(String loaistk, String loaitien, String tinhtrang) throws SQLException {
        ArrayList<Saving> savingList = null;
        try {
            String sql = "SELECT * FROM saving";
            boolean where = false;
            if (!loaistk.equalsIgnoreCase("all")) {
                sql += " WHERE idhusbandry='" + loaistk + "'";
                where = true;
            }
            if (!loaitien.equalsIgnoreCase("all")) {
                if (where) {
                    sql += " AND typeofmoney='" + loaitien + "'";
                    where = true;
                } else {
                    sql += " WHERE typeofmoney='" + loaitien + "'";
                    where = true;
                }
            }
            if (tinhtrang.equalsIgnoreCase("open")) {
                if (where) {
                    sql += " AND mo IS NOT NULL";
                } else {
                    sql += " WHERE mo IS NOT NULL";
                }
            } else if (tinhtrang.equalsIgnoreCase("close")) {
                if (where) {
                    sql += " AND mo IS NULL";
                } else {
                    sql += " WHERE mo IS NULL";
                }
            }
            PreparedStatement ps = con.prepareCall(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
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
                if (rs.getString("mo") == null) {
                    s.setMo(false);
                } else {
                    s.setMo(true);
                }
                savingList.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return savingList;
    }

    public static Saving addSaving(Saving s) throws SQLException {
        String mo = null;
        if (s.isMo()) {
            mo = "";
        }
        try {
            String sql = "INSERT INTO saving VALUE('" + s.getId() + "','" + s.getIdcustomer() + "','" + s.getIdhusbandry() + "','" + s.getIdemployee() + "','" + new java.sql.Date(s.getProvisionDate().getTime()) + "','" + new java.sql.Date(s.getExpirationDate().getTime()) + "','" + s.getInterestTotal() + "','" + s.getDepositTotal() + "','" + s.getTerm() + "','" + s.getTypeofmoney() + "','" + mo + "')";
            PreparedStatement ps = con.prepareCall(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return s;
    }

    public static void main(String[] args) throws SQLException, ParseException {
        String sql = "DELETE FROM saving WHERE id='sav301'";
            PreparedStatement ps = con.prepareCall(sql);
            ps.executeUpdate();

    }
}
