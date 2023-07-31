package test.LoginPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DynamicDropDown
{
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("http://demo.automationtesting.in/Register.html");
        driver.findElement(By.cssSelector("span[role='combobox']")).click();
        driver.findElement(By.xpath("//li[text()='India']")).click();

        //XPath : Dropdown Parent to Child Selection Without Click twice
        driver.findElement(By.xpath("//select[@id='Skills'] //option[@value='Adobe Photoshop']")).click();


    }
}
