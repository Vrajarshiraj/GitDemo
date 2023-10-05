package test.LoginPackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.util.List;

public class ConsoleLogsCapture
{
    public static void main(String[] args)
    {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver=new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/angularAppdemo/");

        driver.findElement(By.xpath("//a[normalize-space()='Browse Products']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Selenium']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Add to Cart']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Continue Shopping']")).click();

        LogEntries logEntries=driver.manage().logs().get(LogType.BROWSER);
        List<LogEntry> logs= logEntries.getAll();

        for(LogEntry e:logs)
        {
            System.out.println(e.getMessage());
        }
    }
}
