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
public class ConfigurationDAOTest {

    static Connection con = ConnectionManager.getConnection();
    static ResultSet rs = null;

    public ConfigurationDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of SetInterestrate method, of class ConfigurationDAO.
     */
    @org.junit.Test
    public void testSetInterestrate() throws Exception {
        try {
            con.setAutoCommit(false);
            String id = "inter08";
            String typeOfMoney = "vnd";
            float interestrate = 0.4F;
            float expResult = interestrate;
            float result = ConfigurationDAO.SetInterestrate(id, typeOfMoney, interestrate);

            // Javabean Checks: Check the javabean contains the expected values:
            assertEquals(expResult, result, 0);

            // Check the InterestRate table updated one row with the expected values:
            String sql = "SELECT * FROM interestrate WHERE id='" + id + "'";
            PreparedStatement ps = con.prepareCall(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                assertEquals(expResult, rs.getFloat("vndinterestrate"), 0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            con.rollback();
        }
    }

    @org.junit.Test
    public void testSetInterestrate2() throws Exception {
        try {
            con.setAutoCommit(false);
            String id = "inter08";
            String typeOfMoney = "vnd";
            float interestrate = -0.4F;
            float expResult = interestrate;
            float result = ConfigurationDAO.SetInterestrate(id, typeOfMoney, interestrate);

            // Javabean Checks: Check the javabean contains the expected values:
            assertEquals(expResult, result, 0);

            // Check the InterestRate table NOT updated one row with the expected values:
            String sql = "SELECT * FROM interestrate WHERE id='" + id + "'";
            PreparedStatement ps = con.prepareCall(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                assertNotEquals(expResult, rs.getFloat("vndinterestrate"), 0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            con.rollback();
        }

    }

}
