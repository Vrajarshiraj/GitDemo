package test.LoginPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class FirstTestNGCase
{
    static WebDriver driver;

    String browser="Chrome";

    @BeforeMethod
    public void Setup()
    {
        System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");

        browser=System.getProperty("browser")!=null?System.getProperty("browser") : browser;

        if(browser.contains("chrome")) {
            ChromeOptions options=new ChromeOptions();

            if(browser.contains("headless"))
            {
                options.addArguments("headless");
            }

            driver = new ChromeDriver(options);
            driver.manage().window().setSize(new Dimension(1440,900));
        } else if (browser.contains("Firefox")) {
            FirefoxOptions options=new FirefoxOptions();

            if(browser.contains("headless"))
            {
                options.addArguments("headless");
            }
            driver=new FirefoxDriver(options);
        }


        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        Reporter.log("=====Browser Session Started=====",true);

        Reporter.log("=====Application Started=====",true);

        driver.get("https://vcs.aecordigitalqa.com/login");
    }


    @Test
    public void Login() throws InterruptedException
    {
        //Make PageObjectModel of Login Page
        //Execute Using POM

        driver.manage().window().maximize();
        driver.findElement(By.name("identity")).sendKeys("administrator");
        driver.findElement(By.id("password")).sendKeys("secret");
        driver.findElement(By.id("pin")).sendKeys("123456");
        driver.findElement(By.xpath("//*[@id=\"main-container\"]/div/div/div[1]/div/div[2]/div/form/div[2]/button")).click();

    }

    @AfterClass
    public void BrowserClose()
    {
        Reporter.log("=====Application End=====",true);
        driver.close();
        Reporter.log("=====Browser Session End=====",true);
    }

}
