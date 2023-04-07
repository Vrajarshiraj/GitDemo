package LoginPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public  class Locators2
{
    public String getPassword(WebDriver driver) throws InterruptedException
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        String passwordText= driver.findElement(By.xpath("//form/p")).getText();
        //Please use temporary password 'rahulshettyacademy' to Login.
        String[] PasswordArray= passwordText.split("'");
        //String[] PasswordArray2=PasswordArray[1].split("'");
        String password=PasswordArray[1].split("'")[0];
        return password;

        //0th Index- Please use temporary password
        //1st Index- rahulshettyacademy' Login

        //0th Index- rahulshettyacademy
        //1st Index- to Login
    }

    public static void main(String[] args) throws InterruptedException
    {
        System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        Locators2 obj=new Locators2();

        String password=obj.getPassword(driver);

        Thread.sleep(5000);

        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        String username="rahul";

        driver.findElement(By.id("inputUsername")).sendKeys(username);

        driver.findElement(By.name("inputPassword")).sendKeys(password);

        driver.findElement(By.className("signInBtn")).click();

        Thread.sleep(2500);

        System.out.println(driver.findElement(By.tagName("p")).getText());

        Assert.assertEquals(driver.findElement(By.tagName("p")).getText(),"You are successfully logged in.");

        System.out.println(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText());

        Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),"Hello "+username+",");
        // Generating XPath based on the button Text on the page
        driver.findElement(By.xpath("//button[text()='Log Out']")).click();
    }
}
