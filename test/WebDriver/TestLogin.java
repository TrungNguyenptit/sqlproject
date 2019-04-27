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
public class TestLogin {
     public void LaunchChrome_Method1() {
        System.setProperty("webdriver.chrome.driver", "D:\\HK8\\SQA\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/Bank/index.jsp");
         driver.findElement(By.name("username")).sendKeys("0.3");
          driver.findElement(By.name("password")).sendKeys("0.3");
          driver.findElement(By.id("dn")).click();
     }
}
