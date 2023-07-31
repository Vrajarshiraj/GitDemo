package test.LoginPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class FilterTable
{
    public static  void main(String[] args)
    {
        System.setProperty("webdriver.edge.driver","C:\\Selenium\\msedgedriver.exe");
        WebDriver driver=new EdgeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//input[@id='search-field']")).sendKeys("Rice");
        List<WebElement> veggies =driver.findElements(By.xpath("//tr/td[1]"));

        List<WebElement> FilterElement=veggies.stream().filter(veggie->veggie.getText().contains("Rice")).collect(Collectors.toList());

        Assert.assertEquals(veggies.size(),FilterElement.size());
    }
}
