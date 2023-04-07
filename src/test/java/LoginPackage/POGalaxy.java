package LoginPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class POGalaxy
{
    public static void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        // Implicit Wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        driver.get("https://pogalaxy.sikkasoft.com/");

        //Login Credentials
        String Username="BMdemo";
        String Password="BoringAI@1";

        //Login Info
        driver.findElement(By.cssSelector("input[placeholder='Username']")).sendKeys(Username);
        driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys(Password);
        driver.findElement(By.xpath("//button[text()='continue']")).click();

        driver.findElement(By.cssSelector("input[name*='0']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[text()='log in']")).click();

        WebDriverWait explicitwait=new WebDriverWait(driver,Duration.ofSeconds(20));
        explicitwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='fas fa-bars']"))).click();

    }

}
