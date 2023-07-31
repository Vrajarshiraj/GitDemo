package test.LoginPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class CalendarUI
{
    public static void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver2.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/#");
        driver.findElement(By.cssSelector("input[name='ctl00$mainContent$view_date1']")).click();
        driver.findElement(By.cssSelector(".ui-datepicker-days-cell-over.ui-datepicker-today")).click();
        driver.findElement(By.cssSelector("input[name='ctl00$mainContent$view_date2']")).click();
        driver.findElement(By.xpath("//body[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[1]/a[1]")).click();

    }
}
