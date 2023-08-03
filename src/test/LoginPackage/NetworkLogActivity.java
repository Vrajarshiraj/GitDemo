package test.LoginPackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v113.network.Network;
import org.openqa.selenium.devtools.v113.network.model.Request;
import org.openqa.selenium.devtools.v113.network.model.Response;

import java.util.Optional;

public class NetworkLogActivity
{
    public static void main(String[] args)
    {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver=new ChromeDriver();
        //Log File

        DevTools devTools=driver.getDevTools();
        devTools.createSession();
        devTools.send(Network.enable(Optional.empty(),Optional.empty(),Optional.empty()));

        devTools.addListener(Network.requestWillBeSent(),request->
        {
            Request rs=request.getRequest();
            System.out.println("Request: "+rs.getUrl());
        });

        //Event get Fired
        devTools.addListener(Network.responseReceived(), response->
        {
            Response res=response.getResponse();
            if(res.getStatus()>400)
            {
                System.out.println("Response: "+res.getUrl());
                System.out.println("Response: "+res.getStatus());
            }

        });


        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.xpath("//button[normalize-space()='Virtual Library']")).click();
    }
}
