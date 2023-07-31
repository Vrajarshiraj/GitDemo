package test.LoginPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class UpdateDropdown
{
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("http://demo.automationtesting.in/Register.html");
        Thread.sleep(2000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
        driver.manage().window().maximize();
        int i=1;

        // Using While Loop
        /*while (i<5)
        {
            driver.findElement(By.cssSelector("#Button1[type='button']")).click();
            Thread.sleep(5000);
            System.out.println(driver.findElement(By.cssSelector("#Button1[type='button']")).getText()+" "+i);
            i++;
        }*/

        for(i=1;i<5;i++)
        {
            driver.findElement(By.cssSelector("#Button1[type='button']")).click();
            Thread.sleep(5000);
            System.out.println(driver.findElement(By.cssSelector("#Button1[type='button']")).getText()+" "+i);
        }


    }
}