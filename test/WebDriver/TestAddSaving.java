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


public class TestAddSaving {
    
     @Test
    public void LaunchChrome_Test1() {
        System.setProperty("webdriver.chrome.driver", "D:\\HK8\\SQA\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/Bank/main.jsp#ch");
        driver.findElement(By.id("moSTK")).click();
        driver.findElement(By.id("btnthemstk")).click();
        driver.findElement(By.name("id")).sendKeys("0.3");
        driver.findElement(By.name("idcustomer")).sendKeys("0.3");
        driver.findElement(By.name("idemployee")).sendKeys("0.3");
        driver.findElement(By.name("idhusbandry")).sendKeys("0.3");
        driver.findElement(By.name("provisionDate")).sendKeys("0.3");
        driver.findElement(By.name("term")).sendKeys("0.3");
        driver.findElement(By.name("type")).sendKeys("0.3");
        driver.findElement(By.name("depositTotal")).sendKeys("0.3");
         driver.findElement(By.name("interestTotal")).sendKeys("0.3");
        driver.findElement(By.id("thaydoi")).click();
               String s = driver.findElement(By.id("thongbao")).getText();
            assertEquals("Cau hinh thanh cong", s);
//            String sql ="SELECT * from interestrate where id ='"+
    }
}
