package test.LoginPackage;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class learn_Screenshots
{
    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.edge.driver","C:\\Selenium\\msedgedriver.exe");
        WebDriver driver=new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://api.sikkasoft.com/v4/portal/authentication/login");

        File scr=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scr,new File("C:\\Users\\vrajarshiraj.shah\\Desktop\\APIV4 Portal\\LoginPageScreenshot.png"));
    }
}
