package LoginPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.function.Function;

public class fluentWaitClass
{
    public static void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.xpath("//button[text()='Start']")).click();

        Wait<WebDriver> wait=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);

        WebElement foo=wait.until(new Function<WebDriver, WebElement>()
        {
            public WebElement apply(WebDriver driver) {
               if(driver.findElement(By.xpath("//h4[text()='Hello World!']")).isDisplayed())
                {
                    return driver.findElement(By.xpath("//h4[text()='Hello World!']"));
                }
               else
                   return null;
            }

        });
        System.out.println(driver.findElement(By.xpath("//h4[text()='Hello World!']")).isDisplayed());
    }
}
