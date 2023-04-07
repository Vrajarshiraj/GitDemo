package LoginPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class FeeScheduleAnalysis
{
    public static void main(String[] args) throws InterruptedException
    {
        System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        driver.get("https://pogalaxy.sikkasoft.com/login");

        driver.findElement(By.cssSelector("#root > div > div > div > div > div > div.col-lg-7 > div > form > div:nth-child(1) > div > input")).sendKeys("BMdemo");
        driver.findElement(By.cssSelector("#root > div > div > div > div > div > div.col-lg-7 > div > form > div:nth-child(2) > div > div > input")).sendKeys("BoringAI@1");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        Thread.sleep(30000);

    }

}
