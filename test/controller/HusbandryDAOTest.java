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
import model.Employee;
import model.Husbandry;
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
public class HusbandryDAOTest {
    
    public HusbandryDAOTest() {
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
     * Test of GetHusbandry method, of class HusbandryDAO.
     */
    @Test
    public void testGetHusbandry() throws Exception {
        String id = "hus010";
        String name = "Tich luy cho con";
        String term = "12 thang";
        float minimumamountdespositcycle = 3000000;
        String typeofmoney = "vnd";
        String despositCycle = "3 thang/lan";
        String interestPaymentCycle = "cuoi ky";
        String sourcesofinterestPayment = "";
        String note = "";
        Husbandry expResult = new Husbandry(id, name, term, minimumamountdespositcycle, typeofmoney, despositCycle, interestPaymentCycle, sourcesofinterestPayment, note);
        Husbandry result = HusbandryDAO.GetHusbandry(id);

        // Javabean Checks: Check the javabean contains the expected values:
        assertEquals(expResult.getId(), result.getId());
        assertEquals(expResult.getName(), result.getName());
        assertEquals(expResult.getTerm(), result.getTerm());
        assertEquals(expResult.getMinimumamountdespositcycle(), result.getMinimumamountdespositcycle(),0);
        assertEquals(expResult.getTypeofmoney(), result.getTypeofmoney());
        assertEquals(expResult.getDespositCycle(), result.getDespositCycle());
        assertEquals(expResult.getInterestPaymentCycle(), result.getInterestPaymentCycle());
        assertEquals(expResult.getSourcesofinterestPayment(), result.getSourcesofinterestPayment());
        assertEquals(expResult.getNote(), result.getNote());

        // Check the Person table contains one row with the expected values:
        Statement stCheck = con.createStatement();
        try (ResultSet rs = stCheck.executeQuery("SELECT * FROM husbandry WHERE id='" + id + "'")) {
            while(rs.next())
            {
            assertEquals(id, rs.getString("id"));
            assertEquals(name, rs.getString("name"));
            assertEquals(term, rs.getString("term"));
            assertEquals(minimumamountdespositcycle, rs.getFloat("minimumamountdespositcycle"),0);
            assertEquals(typeofmoney, rs.getString("typeofmoney"));
            assertEquals(despositCycle, rs.getString("despositCycle"));
            assertEquals(interestPaymentCycle, rs.getString("interestPaymentCycle"));
            assertEquals(sourcesofinterestPayment, rs.getString("sourcesofinterestPayment"));
            assertEquals(note, rs.getString("note"));
            }
            assertFalse(rs.next());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
