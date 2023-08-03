package test.LoginPackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v114.fetch.Fetch;

import java.util.Optional;

public class NetworkMocking
{
    public static void main(String[] args)
    {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver=new ChromeDriver();

        DevTools tools=driver.getDevTools();
        tools.createSession();

        tools.send(Fetch.enable(Optional.empty(),Optional.empty()));
        tools.addListener(Fetch.requestPaused(),requestPaused ->
        {
            if(requestPaused.getRequest().getUrl().contains("shetty"))
            {
                String mockedUrl=requestPaused.getRequest().getUrl().replace("=shetty","=BadGuy");

                tools.send(Fetch.continueRequest(requestPaused.getRequestId(),Optional.of(mockedUrl), Optional.of(requestPaused.getRequest().getMethod()),Optional.empty(),requestPaused.getResponseHeaders(),Optional.empty()));
            }
            else
            {
                tools.send(Fetch.continueRequest(requestPaused.getRequestId(),Optional.of(requestPaused.getRequest().getUrl()), Optional.of(requestPaused.getRequest().getMethod()),Optional.empty(),requestPaused.getResponseHeaders(),Optional.empty()));
            }

            driver.get("https://rahulshettyacademy.com/angularAppdemo/");
            driver.findElement(By.xpath("//button[normalize-space()='Virtual Library']")).click();

        });
    }
}
