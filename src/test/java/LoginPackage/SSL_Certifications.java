package LoginPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;

import java.time.Duration;

public class SSL_Certifications
{
    public static void main(String[] args)
    {
        EdgeOptions option=new EdgeOptions();
        option.setAcceptInsecureCerts(true);

        System.setProperty("webdriver.edge.driver","C:\\Selenium\\msedgedriver.exe");
        WebDriver driver=new EdgeDriver(option);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://expired.badssl.com/");
        driver.getTitle();
        Assert.assertEquals(driver.getTitle(),"expired.badssl.com");
    }
}
