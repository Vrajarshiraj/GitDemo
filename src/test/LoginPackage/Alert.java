package test.LoginPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class Alert
{
    public static void main(String[] args) throws InterruptedException
    {
        String text = "Rahul";
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

        driver.findElement(By.id("name")).sendKeys(text);
        driver.findElement(By.id("alertbtn")).click();
        Thread.sleep(3000);

        //Accessing Alerts
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        //Accessing Confirm Alert
        driver.findElement(By.id("confirmbtn")).click();
        driver.switchTo().alert().dismiss();

    }
}
