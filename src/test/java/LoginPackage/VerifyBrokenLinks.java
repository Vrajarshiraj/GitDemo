package LoginPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.*;
import java.sql.Connection;
import java.util.List;

public class VerifyBrokenLinks
{
    public void findAllBrokenlinks(WebDriver driver) throws IOException {
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        List<WebElement> allLinks=driver.findElements(By.xpath("//li[@class='gf-li'] //a"));

        SoftAssert sa=new SoftAssert();

        for(WebElement link: allLinks)
        {
            String url=link.getAttribute("href");

            HttpURLConnection Conn=(HttpURLConnection)new URL(url).openConnection();
            Conn.setRequestMethod("HEAD");
            Conn.connect();
            int respCode=Conn.getResponseCode();
            System.out.println(link.getText());

            sa.assertTrue(respCode<400,"Link is "+link.getText()+" With response Code "+respCode);
//            if(respCode>400)
//            {
//                System.out.println("Link is "+link.getText()+" With response Code "+respCode);
//                Assert.assertTrue(false);
//            }

        }
            sa.assertAll();
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        System.setProperty("webdriver.edge.driver","C:\\Selenium\\msedgedriver.exe");
        WebDriver driver=new EdgeDriver();
        driver.manage().window().maximize();

        //Broken Links Verification
        // Java Method Calls the URLs and will get us status code
        // If status code is greater then 400 then that URL is not Working
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        Thread.sleep(1000);
        String url=driver.findElement(By.cssSelector("a[href*='soapui']")).getAttribute("href");
        HttpURLConnection Conn= (HttpURLConnection)new URL(url).openConnection();
        Conn.setRequestMethod("HEAD");
        Conn.connect();
        int responseCode=Conn.getResponseCode();
        System.out.println(responseCode);
        // For Broken link  a[href*='brokenlink']

        VerifyBrokenLinks obj=new VerifyBrokenLinks();
        obj.findAllBrokenlinks(driver);
    }

}
