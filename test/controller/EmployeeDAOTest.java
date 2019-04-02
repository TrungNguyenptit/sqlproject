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
import model.Customer;
import model.Employee;
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
public class EmployeeDAOTest {
    
    public EmployeeDAOTest() {
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
     * Test of GetEmployee method, of class EmployeeDAO.
     */
    @Test
    public void testGetEmployee() throws Exception {
        String id = "em05";
        String idProfile = "pro022";
        String idemployeeAccount = "ema05";
        String role = "nv";
        Employee expResult = new Employee(id, idProfile, idemployeeAccount, role);
        Employee result = EmployeeDAO.GetEmployee(id);

        // Javabean Checks: Check the javabean contains the expected values:
        assertEquals(expResult.getId(), result.getId());
        assertEquals(expResult.getIdProfile(), result.getIdProfile());
        assertEquals(expResult.getIdemployeeAccount(), result.getIdemployeeAccount());
        assertEquals(expResult.getDuty(), result.getDuty());

        // Check the Person table contains one row with the expected values:
        Statement stCheck = con.createStatement();
        try (ResultSet rs = stCheck.executeQuery("SELECT * FROM employee WHERE id='" + id + "'")) {
            while(rs.next())
            {
            assertEquals(id, rs.getString("id"));
            assertEquals(idProfile, rs.getString("idProfile"));
            assertEquals(idemployeeAccount, rs.getString("idemployeeAccount"));
            assertEquals(role, rs.getString("role"));
            }
            assertFalse(rs.next());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
