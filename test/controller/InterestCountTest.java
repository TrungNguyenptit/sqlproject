/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.text.SimpleDateFormat;
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
    public void testSavingInterestCount1() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("SavingInterestCount");
        ArrayList<Saving> savingList = new ArrayList<>();
        Saving s1 = new Saving("sav321", "cus22", "hus12", "em03", sdf.parse("2018-02-10"), sdf.parse("2019-02-10"), 500000000f, 3000000000f, "12 thang", "vnd", false);
        savingList.add(s1);
        int term = 3;
        String finishDate = "2019-03-15";
        InterestCount instance = new InterestCount();
        float expResult = 500000000F;
        float result = instance.SavingInterestCount(savingList, term, finishDate);
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testSavingInterestCount2() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        ArrayList<Saving> savingList = new ArrayList<>();
        Saving s1 = new Saving("sav321", "cus22", "hus12", "em03", sdf.parse("2018-02-10"), sdf.parse("2019-02-10"), 500000000f, 3000000000f, "12 thang", "vnd", true);
        savingList.add(s1);
        int term = 3;
        String finishDate = "2019-03-15";
        InterestCount instance = new InterestCount();
        float expResult = 0F;
        float result = instance.SavingInterestCount(savingList, term, finishDate);
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testSavingInterestCount3() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        ArrayList<Saving> savingList = new ArrayList<>();
        Saving s1 = new Saving("sav321", "cus22", "hus12", "em03", sdf.parse("2018-02-10"), sdf.parse("2019-02-10"), 500000000f, 3000000000f, "12 thang", "vnd", false);
        savingList.add(s1);
        int term = 3;
        String finishDate = "2019-01-15";
        InterestCount instance = new InterestCount();
        float expResult = 0F;
        float result = instance.SavingInterestCount(savingList, term, finishDate);
        assertEquals(expResult, result, 0.0);
    }

}
