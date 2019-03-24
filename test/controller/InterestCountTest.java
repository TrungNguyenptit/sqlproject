/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
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
public class InterestCountTest {
    
    public InterestCountTest() {
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
     * Test of SavingInterestCount method, of class InterestCount.
     */
    @Test
    public void testSavingInterestCount() throws Exception {
        System.out.println("SavingInterestCount");
        ArrayList<Saving> savingList = null;
        int term = 0;
        String finishDate = "";
        InterestCount instance = new InterestCount();
        float expResult = 0.0F;
        float result = instance.SavingInterestCount(savingList, term, finishDate);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class InterestCount.
     */
    @Test
    public void testMain() throws Exception {
        System.out.println("main");
        String[] args = null;
        InterestCount.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
