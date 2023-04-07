package LoginPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginWithMultipleSetofData
{
    @Test(dataProvider = "credentials")
    public void loginCredentials(String userName,String passWord)
    {
        System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        driver.get("https://www.rahulshettyacademy.com/loginpagePractise/");
        driver.findElement(By.id("username")).sendKeys(userName);
        driver.findElement(By.id("password")).sendKeys(passWord);
        driver.findElement(By.id("signInBtn")).click();
        driver.close();
    }

    @DataProvider(name="credentials")
    public Object[][] GetData()
    {
        return new Object[][]{
                {"jemimah","rodriguez"},
                {"rahulshettyacademy","learning"}
        };
    }

}
