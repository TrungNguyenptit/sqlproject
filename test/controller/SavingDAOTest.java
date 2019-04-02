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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import model.Saving;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ADMIN
 */
public class SavingDAOTest {

    static Connection con = ConnectionManager.getConnection();

    public SavingDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() throws SQLException {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of GetSaving method, of class SavingDAO.
     */
    @Test
    public void testGetSaving1() throws Exception {
        System.out.println("GetSaving");
        String loaistk = "";
        String loaitien = "";
        String tinhtrang = "";
        ArrayList<Saving> expResult = new ArrayList<>();
        ArrayList<Saving> result = SavingDAO.GetSaving(loaistk, loaitien, tinhtrang);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of addSaving method, of class SavingDAO.
     */
    @Test
    public void testAddSaving() throws Exception {
        try {
            con.setAutoCommit(false);
            //Setting input parameters:
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String id = "sav30";
            String idcustomer = "cus04";
            String idhusbandry = "hus014";
            String idemployee = "em02";
            String provisionDateString = "2018-12-12";
            String expirationDateString = "2019-06-12";
            Date provisionDate = sdf.parse(provisionDateString);
            Date expirationDate = sdf.parse(expirationDateString);
            float interestTotal = 0;
            float depositTotal = 0;
            String term = "6 tháng";
            String typeofmoney = "vnd";
            boolean mo = true;
            Saving s = new Saving(id, idcustomer, idhusbandry, idemployee, provisionDate, expirationDate, interestTotal, depositTotal, term, typeofmoney, mo);

            // Do the call:
            Saving scheck;
            scheck = SavingDAO.addSaving(s);
//
            // Javabean Checks: Check the javabean contains the expected values:
            assertEquals(scheck, s);

            // Database Checks:
            // Check the Person table contains one row with the expected values:
            String sql = "SELECT * FROM profile WHERE id='" + id + "'";
            PreparedStatement ps = con.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                assertEquals(id, rs.getString("id"));
                assertEquals(idcustomer, rs.getString("idcustomer"));
                assertEquals(idemployee, rs.getString("idemployee"));
                assertEquals(idhusbandry, rs.getString("idhusbandry"));
                assertEquals(provisionDate, rs.getDate("provisionDate"));
                assertEquals(expirationDate, rs.getDate("expirationDate"));
                assertEquals(interestTotal, rs.getFloat("interestTotal"), 0.0001);
                assertEquals(depositTotal, rs.getFloat("depositTotal"), 0.0001);
                assertEquals(term, rs.getString("term"));
                assertEquals(typeofmoney, rs.getString("typeofmoney"));
                assertEquals(idemployee, rs.getString("idemployee"));
                assertFalse(rs.next());
            }
            //Delete the test data
//            String sql = "DELETE FROM saving WHERE id='"+id+"'";
//            PreparedStatement ps = con.prepareCall(sql);
//            ps.executeUpdate();
        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            con.rollback();
        }
    }

}
