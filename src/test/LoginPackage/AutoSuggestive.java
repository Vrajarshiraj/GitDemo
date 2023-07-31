package test.LoginPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class AutoSuggestive
{
    public static void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.id("autosuggest")).sendKeys("Ind");

        // Extracting the AutoSuggestive XPath
        // driver.findElement(By.xpath("//li[@class='ui-menu-item'] //a[text()='India']")).click();

        List<WebElement> SuggestionList =driver.findElements(By.xpath("//li[@class='ui-menu-item'] //a"));
        for(WebElement Option:SuggestionList)
        {
            if(Option.getText()=="India")
            {
               Option.click();
               break;
            }
        }

        Assert.assertFalse(driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).isSelected());
        driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();
        System.out.println(driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).isSelected());
        System.out.print(driver.findElements(By.cssSelector("input[type='checkbox']")).size());

        Assert.assertTrue(driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).isSelected());

        Assert.assertEquals(driver.findElement(By.cssSelector("label[for='ctl00_mainContent_rbtnl_Trip_2']")).getText(),"Multicity");
    }
}
