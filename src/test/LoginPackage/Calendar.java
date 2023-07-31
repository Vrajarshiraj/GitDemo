package test.LoginPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Calendar
{
    public static void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        driver.get("https://testautomationpractice.blogspot.com/");
        driver.findElement(By.className("hasDatepicker")).click();

        while(!driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText().contains("April"))
        {
            driver.findElement(By.xpath("//a[@class='ui-datepicker-next ui-corner-all']")).click();
        }

        List<WebElement> Dates=driver.findElements(By.xpath("//a[@class='ui-state-default']"));
        int count=driver.findElements(By.xpath("//a[@class='ui-state-default']")).size();

        System.out.println(driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText());



        //1) Grab Common Attribute 2) put it into the list
        for(int i=0;i<count;i++)
        {
           String text=driver.findElements(By.xpath("//a[@class='ui-state-default']")).get(i).getText();

           if(text.equalsIgnoreCase("23"))
           {
               driver.findElements(By.xpath("//a[@class='ui-state-default']")).get(i).click();
               break;
           }
        }
    }
}
