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
import model.Loan;

/**
 *
 * @author ADMIN
 */
public class LoanDAO {

    static Connection con = ConnectionManager.getConnection();
    static ResultSet rs = null;

    public static ArrayList<Loan> GetLoan(String loaivl, String tinhtrang) throws SQLException {
        ArrayList<Loan> loanList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM loan";
            boolean where = false;
            if (!loaivl.equalsIgnoreCase("all")) {
                sql += " WHERE idlend='" + loaivl + "'";
                where = true;
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
                Loan l = new Loan();
                l.setId(rs.getString("id"));
                l.setInterestTotal(rs.getFloat("interestTotal"));
                l.setLoanamount(rs.getFloat("loanamount"));
                l.setProvisionDate(rs.getDate("provisionDate"));
                l.setExpirationDate(rs.getDate("expirationDate"));
                l.setInterestPaymentCycle(rs.getString("InterestPaymentCycle"));
                l.setIdcustomer(rs.getString("idcustomer"));
                l.setIdemployee(rs.getString("idemployee"));
                l.setIdlend(rs.getString("idlend"));
                l.setTerm(rs.getString("term"));
                l.setNote(rs.getString("note"));
                if (rs.getString("mo") == null) {
                    l.setMo(false);
                } else {
                    l.setMo(true);
                }
                loanList.add(l);
            }
        } catch (SQLException e) {

        }
               // con.close();
        return loanList;
    }

    public static Loan addLoan(Loan l) throws SQLException {
        String mo = null;
        if (l.isMo()) {
            mo = "";
        }
        try {
            String sql = "INSERT INTO saving VALUE('" + l.getId() + "','" + l.getIdlend() + "','" + l.getIdcustomer() + "','" + l.getIdemployee() + "','" + new java.sql.Date(l.getProvisionDate().getTime()) + "','" + new java.sql.Date(l.getExpirationDate().getTime()) + "','" + l.getLoanamount() + "','" + l.getTerm() + "','" + l.getInterestTotal() + "',,'" + l.getInterestPaymentCycle() + "'," + mo + "')";
            PreparedStatement ps = con.prepareCall(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
     //   con.close();
        return l;
    }

    public static void main(String[] args) throws SQLException {
        ArrayList<Loan> l = new ArrayList<>();
        l = LoanDAO.GetLoan("all", "all");
        System.out.print(l.get(0).getIdcustomer());
    }
}
