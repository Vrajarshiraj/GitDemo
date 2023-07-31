package test.LoginPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class ECommerceExample
{
    public static void addItems(WebDriver driver,String[] itemsNeeded ) throws InterruptedException
    {
        Thread.sleep(3000);
        List<WebElement> Products = driver.findElements(By.xpath("//h4[@class='product-name']"));
        int j=0;

        for (int i = 0; i < Products.size(); i++)
        {
            String[] name = Products.get(i).getText().split("-");
            String FormattedName=name[0].trim();

            List itemsNeededList = Arrays.asList(itemsNeeded);


            if (itemsNeededList.contains(FormattedName))
            {
                j++;
                System.out.println(FormattedName + " "+i);
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

                if(j==itemsNeeded.length)
                {
                    break;
                }

            }

        }
    }



    public static void main(String[] args) throws InterruptedException
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

        String[] itemsNeeded={"Brocolli","Cucumber","Beetroot"};
        addItems(driver,itemsNeeded);
    }
}
