package test.LoginPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage
{
    public static void main(String args[]) throws InterruptedException
    {
        System.setProperty("webdriver.edge.driver","C:\\Selenium\\msedgedriver.exe");
        WebDriver driver=new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        driver.get("https://rahulshettyacademy.com/locatorspractice/");

//        driver.findElement(By.id("inputUsername")).sendKeys("BMdemo");
//        driver.findElement(By.cssSelector("input[type='password']")).sendKeys("BoringAI@1");
//        driver.findElement(By.linkText("Forgot your password?")).click();
//        Thread.sleep(1000);
//
//        driver.findElement(By.cssSelector("input[type='text']:nth-child(2)")).sendKeys("Vrajarshi");
//        driver.findElement(By.xpath("//input[@type='text'][2]")).sendKeys("vrajarshi9873@gmail.com");
//        driver.findElement(By.xpath("//form/input[3]")).sendKeys("7984031546");
//        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
//        System.out.println(driver.findElement(By.xpath("//form/p")).getText());

         driver.findElement(By.cssSelector("input[placeholder*='Username']")).sendKeys("rahul");
         driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
         //driver.findElement(By.cssSelector("button[type*='submit']")).click();      //Regular Expression CSS Selector
         //Thread.sleep(5000);                                                    // Used to Stop Thread for defined seconds
        // System.out.println(driver.findElement(By.xpath("//p")).getText());        //Attributeless XPath

         driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
         Thread.sleep(10000);
         //Regular Expression XPath
        //div[@class='forgot-pwd-btn-conainer']/button[1]                             //Parent tag to child tag with attributes
        System.out.println(driver.findElement(By.tagName("p")).getText());
        Assert.assertEquals(driver.findElement(By.tagName("p")).getText(),"You are successfully logged in.");
        System.out.println(driver.findElement(By.cssSelector("div[class='login-container'] h1")).getText());
        Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h1")).getText(),"Welcome to Rahul Shetty Academy");

    }
}
