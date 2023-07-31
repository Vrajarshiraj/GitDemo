package test.LoginPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class FramesTest
{
    public void Assignment_Frames(WebDriver driver)
    {
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        driver.findElement(By.xpath("//frameset")).click();
        driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-top']")));
        driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-middle']")));
        System.out.println(driver.findElement(By.xpath("//div[@id='content']")).getText());
    }

    public static void main(String[] args)
    {

        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://jqueryui.com/droppable/");
        System.out.println(driver.findElements(By.tagName("iframe")).size());
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
        driver.findElement(By.id("draggable")).click();

        Actions actions=new Actions(driver);
        WebElement Source=driver.findElement(By.id("draggable"));
        WebElement Destination=driver.findElement(By.id("droppable"));
        actions.dragAndDrop(Source,Destination).build().perform();
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//a[text()='Accept']")).click();

        FramesTest obj=new FramesTest();
        obj.Assignment_Frames(driver);
    }

}
