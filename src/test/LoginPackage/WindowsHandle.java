package test.LoginPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class WindowsHandle
{
    public void MultipleWindows(WebDriver driver)
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/windows");
        driver.findElement(By.xpath("//a[text()='Click Here']")).click();

        Set<String> Windows=driver.getWindowHandles();
        Iterator<String> it=Windows.iterator();
        String ParentWindow= it.next();
        String ChildWindow=it.next();

        driver.switchTo().window(ChildWindow);
        System.out.println(driver.findElement(By.xpath("//h3[contains(text(),'New Window')]")).getText());

        driver.switchTo().window(ParentWindow);
        System.out.println(driver.findElement(By.xpath("//h3[contains(text(),'Opening a new window')]")).getText());

    }
    public static void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WindowsHandle wh=new WindowsHandle();
        wh.MultipleWindows(driver);

        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.findElement(By.xpath("//a[@class='blinkingText']")).click();

        Set<String> Windows= driver.getWindowHandles();
        Iterator<String> it=Windows.iterator();
        String ParentWindow=it.next();
        String ChildWindow= it.next();

        driver.switchTo().window(ChildWindow);

        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Documents request']")));

        String EmailId=driver.findElement(By.xpath("//*[@id=\"interview-material-container\"]/div/div[2]/p[2]")).getText().split("at")[1].trim().split(" with")[0];

        driver.switchTo().window(ParentWindow);
        driver.findElement(By.id("username")).sendKeys(EmailId);


    }
}
