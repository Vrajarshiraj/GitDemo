package LoginPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class CalendarWithoutHardcode
{
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.path2usa.com/travel-companion/");
        Thread.sleep(1000);

        JavascriptExecutor js = (JavascriptExecutor)driver;

        js.executeScript("window.scrollBy(0,1100)");
        // click calendar
        driver.findElement(By.id("form-field-travel_comp_date")).click();

        //Choose Month
        WebElement Month=driver.findElement(By.xpath("//div[@class='flatpickr-month']"));

        while(!Month.getText().contains("May"))
        {
            Thread.sleep(2000);
            driver.findElement(By.xpath("//span[@class='flatpickr-next-month']")).click();
        }

        int count= driver.findElements(By.xpath("//span[@class='flatpickr-day ']")).size();
        //click Date
        for(int i=0;i<count;i++)
        {
            String Text=driver.findElements(By.xpath("//span[@class='flatpickr-day ']")).get(i).getText();

            if(Text.equalsIgnoreCase("23"))
            {
                driver.findElements(By.xpath("//span[@class='flatpickr-day ']")).get(i).click();
                break;
            }
        }
    }
}
