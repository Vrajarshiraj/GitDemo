package LoginPackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class verifydownloadfile {
    public static void main(String[] args) throws IOException, InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://qaapiv4.sikkasoft.com/v4/portal/authentication/login");

        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("vrajarshiraj.shah+102@sikka.ai");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Vrajarshi@123");
        driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//div[@class='table-responsive-lg']//div//a[contains(text(),'.CSV')]")).click();
        Thread.sleep(2000);


        File file=new File("C:\\Users\\vrajarshiraj.shah\\Downloads\\Sikka AXAR QA Testing_Team_member(s)_List_7_28_2023.csv");
        if(file.exists())
        {
            System.out.println("file was found.");
        }
    }
}
