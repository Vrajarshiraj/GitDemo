package test.LoginPackage;

import com.google.common.collect.ImmutableList;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v114.fetch.Fetch;
import org.openqa.selenium.devtools.v114.fetch.model.RequestPattern;
import org.openqa.selenium.devtools.v114.network.Network;
import org.openqa.selenium.devtools.v114.network.model.ConnectionType;
import org.openqa.selenium.devtools.v114.network.model.ErrorReason;

import java.sql.DriverManager;
import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class NetworkFailedRequest
{
    public void BlockNetworkRequest(ChromeDriver driver)
    {
        DevTools devTools=driver.getDevTools();
        devTools.createSession();

        devTools.send(Network.enable(Optional.empty(),Optional.empty(),Optional.empty()));
        devTools.send(Network.setBlockedURLs(Collections.singletonList("https://qaapiv4.sikkasoft.com/v4/portal/static/media/API_Status.6008080a.png")));

        driver.get("https://qaapiv4.sikkasoft.com/v4/portal/authentication/login");

    }

    public void EmulateNetwork(ChromeDriver driver)
    {
        DevTools devTools=driver.getDevTools();
        devTools.createSession();

            devTools.send(Network.enable(Optional.empty(),Optional.empty(),Optional.empty()));
            devTools.send(Network.emulateNetworkConditions(false,10000,10000,10000,Optional.of(ConnectionType.ETHERNET)));

            devTools.addListener(Network.loadingFailed(),loadingFailed ->
            {
                System.out.println(loadingFailed.getErrorText());
                System.out.println(loadingFailed.getTimestamp());
            });

          long startTime=System.currentTimeMillis();
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");

        driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
        long endTime=System.currentTimeMillis();
        System.out.println(endTime-startTime);
    }

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver=new ChromeDriver();

        DevTools tools=driver.getDevTools();
        tools.createSession();

        Optional<List<RequestPattern>> pattern=Optional.of(Arrays.asList(new RequestPattern(Optional.of("*GetBook*"),Optional.empty(),Optional.empty())));
        tools.send(Fetch.enable(pattern,Optional.empty()));

        tools.addListener(Fetch.requestPaused(),requestPaused ->
        {
            tools.send(Fetch.failRequest(requestPaused.getRequestId(), ErrorReason.FAILED));

        });

        driver.get("https://rahulshettyacademy.com/angularAppdemo");

        driver.manage().window().maximize();

        driver.findElement(By.cssSelector("button[routerlink*='library']")).click();

        Thread.sleep(3000);

        NetworkFailedRequest obj=new NetworkFailedRequest();
        obj.EmulateNetwork(driver);
    }
}
