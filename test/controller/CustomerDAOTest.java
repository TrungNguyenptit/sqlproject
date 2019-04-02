/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static controller.ProfileDAOTest.con;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import model.Customer;
import model.Profile;
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
public class CustomerDAOTest {
    
    public CustomerDAOTest() {
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
     * Test of GetCustomer method, of class CustomerDAO.
     */
    @org.junit.Test
    public void testGetCustomer() throws Exception {
        System.out.println("GetCustomer");
        String id = "cus01";
        String job = "bac sy";
        String passportNo = "AK0123654564";
        String idprofile = "pro01";
        String idaccount = "acc01";
        Customer expResult = new Customer(id, job, passportNo, idprofile, idaccount);
        Customer result = CustomerDAO.GetCustomer(id);

        // Javabean Checks: Check the javabean contains the expected values:
        assertEquals(expResult.getId(), result.getId());
        assertEquals(expResult.getJob(), result.getJob());
        assertEquals(expResult.getPassportNo(), result.getPassportNo());
        assertEquals(expResult.getIdprofile(), result.getIdprofile());
        assertEquals(expResult.getIdaccount(), result.getIdaccount());

        // Check the Customer table contains one row with the expected values:
        Statement stCheck = con.createStatement();
        try (ResultSet rs = stCheck.executeQuery("SELECT * FROM customer WHERE id='" + id + "'")) {
            while(rs.next())
            {
            assertEquals(id, rs.getString("id"));
            assertEquals(job, rs.getString("job"));
            assertEquals(passportNo, rs.getString("passportNo"));
            assertEquals(idprofile, rs.getString("idprofile"));
            assertEquals(idaccount, rs.getString("idaccount"));
            }
            assertFalse(rs.next());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
}
