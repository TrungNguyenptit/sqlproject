/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.EmployeeAccount;
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
public class EmployeeAccountDAOTest {

    Connection con = ConnectionManager.getConnection();

    public EmployeeAccountDAOTest() {
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
     * Test of LogIn method, of class EmployeeAccountDAO.
     */
    @Test
    public void testLogIn() throws Exception {
        String username = "employee1";
        String password = "123456";
        EmployeeAccount acc = new EmployeeAccount(username, password);

        EmployeeAccount expResult = acc;
        EmployeeAccount result = EmployeeAccountDAO.LogIn(acc);

        // Javabean Checks: Check the javabean contains the expected values:
        assertEquals(expResult, result);
        assertTrue(result.isValid());
        // Check the Person table contains one row with the expected values:
        Statement stCheck = con.createStatement();
        try (ResultSet rs = stCheck.executeQuery("SELECT * FROM employeeaccount WHERE username='" + username + "'")) {
            while (rs.next()) {
                assertEquals(username, rs.getString("username"));
                assertEquals(password, rs.getString("password"));
            }
            assertFalse(rs.next());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testLogIn2() throws Exception {
        String username = "employee1";
        String password = "1234567";
        EmployeeAccount acc = new EmployeeAccount(username, password);

        EmployeeAccount expResult = acc;
        EmployeeAccount result = EmployeeAccountDAO.LogIn(acc);

        // Javabean Checks: Check the javabean contains the expected values:
        assertEquals(expResult, result);
        assertFalse(result.isValid());
        // Check the Person table contains one row with the expected values:
        Statement stCheck = con.createStatement();
        try (ResultSet rs = stCheck.executeQuery("SELECT * FROM employeeaccount WHERE username='" + username + "'")) {
            while (rs.next()) {
                assertNotEquals(password, rs.getString("password"));
            }
            assertFalse(rs.next());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
