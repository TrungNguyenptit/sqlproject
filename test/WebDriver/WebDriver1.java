/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebDriver;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.*;
/**
 *
 * @author ADMIN
 */
public class WebDriver1 {

    public static void main(String[] args) {

    }

    @Test
    public void LaunchChrome_Method1() {
        System.setProperty("webdriver.chrome.driver", "D:\\HK8\\SQA\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/Bank/main.jsp#ch");
        driver.findElement(By.id("moCH")).click();
        driver.findElement(By.id("mainselect")).click();
        driver.findElement(By.id("chonstk")).click();
        driver.findElement(By.id("chonstk")).click();
        driver.findElement(By.id("tlcc")).click();
        driver.findElement(By.id("CLT")).click();
        driver.findElement(By.id("vnd")).click();
        driver.findElement(By.id("tigia")).sendKeys("0.3");
        driver.findElement(By.id("thaydoi")).click();
               String s = driver.findElement(By.id("thongbao")).getText();
            assertEquals("Cau hinh thanh cong", s);
//            String sql ="SELECT * from interestrate where id ='"+
    }
    
        @Test
    public void LaunchChrome_Method2() {
        System.setProperty("webdriver.chrome.driver", "D:\\HK8\\SQA\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/Bank/main.jsp#ch");
        driver.findElement(By.id("moCH")).click();
        driver.findElement(By.id("mainselect")).click();
        driver.findElement(By.id("chonstk")).click();
        driver.findElement(By.id("chonstk")).click();
        driver.findElement(By.id("tlcc")).click();
        driver.findElement(By.id("CLT")).click();
        driver.findElement(By.id("vnd")).click();
        driver.findElement(By.id("tigia")).sendKeys("-0.3");
        driver.findElement(By.id("thaydoi")).click();
       String s = driver.findElement(By.id("thongbao")).getText();
            assertEquals("Cau hinh khong thanh cong", s);
    }
    }
