package LoginPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;

public class ValidationEnabledOrDisabledClass
{
    public static void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/#");

        driver.findElement(By.xpath("//td //input[@value='RoundTrip']")).click();
        driver.findElement(By.xpath("//div[@id='Div1']")).getAttribute("style").contains("1");
        if(driver.findElement(By.xpath("//div[@id='Div1']")).getAttribute("style").contains("1"))
        {
            System.out.println("It is Enabled");
            Assert.assertTrue(true);
        }
        else
        {
            Assert.assertTrue(false);
        }
        driver.findElement(By.xpath("//input[@id='ctl00_mainContent_rbtnl_Trip_0']")).click();
        if(driver.findElement(By.xpath("//div[@id='Div1']")).getAttribute("style").contains("0.5"))
        {
            System.out.println("Disabled Successfully");
            Assert.assertTrue(true);
        }

    }
}
