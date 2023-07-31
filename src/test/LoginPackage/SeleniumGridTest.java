package test.LoginPackage;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class SeleniumGridTest {

    @Test
    public void homepagecheck() throws MalformedURLException {

        DesiredCapabilities caps=new DesiredCapabilities();


        caps.setPlatform(Platform.ANY);
        caps.setBrowserName("chrome");
        caps.setCapability(CapabilityType.BROWSER_NAME,"chrome");

        WebDriver driver=new RemoteWebDriver(new URL("http://192.168.214.1:4444"),caps);
        driver.get("https://www.google.com/");
        System.out.println(driver.getTitle());
    }
}
