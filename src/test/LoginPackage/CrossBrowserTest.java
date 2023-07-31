package test.LoginPackage;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class CrossBrowserTest
{
    @Test
    public void HomePageCheck() throws MalformedURLException {

        MutableCapabilities caps=new MutableCapabilities();


        WebDriver driver=new RemoteWebDriver(new URL("https://hub.browserstack.com/wd/hub"),caps);
        driver.get("https://qaapiv4.sikkasoft.com/v4/portal/authentication/login");
        System.out.println(driver.getTitle());
    }
}
