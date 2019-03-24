/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static controller.SavingDAOTest.con;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
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
public class ProfileDAOTest {

    static Connection con = ConnectionManager.getConnection();

    public ProfileDAOTest() {
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
     * Test of GetProfile method, of class ProfileDAO.
     */
    @Test
    public void testGetProfile() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("GetProfile");
        String id = "pro011";
        String dateofbirth = "1995-03-07";
        String address = "Chợ lớn, Hà Nội";
        String tel = "09654455778";
        String name = "Nguyễn Thị Thúy";
        Profile expResult = new Profile(id, sdf.parse(dateofbirth), address, tel, name);
        Profile result = ProfileDAO.GetProfile(id);

        // Javabean Checks: Check the javabean contains the expected values:
        assertEquals(expResult.getId(), result.getId());
        assertEquals(sdf.format(expResult.getDateofbirth()), sdf.format(result.getDateofbirth()));
        assertEquals(expResult.getAddress(), result.getAddress());
        assertEquals(expResult.getTel(), result.getTel());
        assertEquals(expResult.getName(), result.getName());

        // Check the Person table contains one row with the expected values:
        Statement stCheck = con.createStatement();
        try (ResultSet rs = stCheck.executeQuery("SELECT * FROM profile WHERE id='" + id + "'")) {
            while(rs.next())
            {
            assertEquals(id, rs.getString("id"));
            assertEquals(dateofbirth, rs.getDate("dateofbirth").toString());
            assertEquals(address, rs.getString("address"));
            assertEquals(tel, rs.getString("tel"));
            assertEquals(name, rs.getString("name"));
            }
            assertFalse(rs.next());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
