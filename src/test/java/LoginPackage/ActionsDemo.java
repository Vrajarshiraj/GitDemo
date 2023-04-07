package LoginPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class ActionsDemo
{
    public void login(WebDriver driver)
    {
        driver.get("https://pogalaxy.sikkasoft.com/login");

        //Login Credentials
        String Username="BMdemo";
        String Password="BoringAI@1";
        //Login Info
        driver.findElement(By.cssSelector("input[placeholder='Username']")).sendKeys(Username);
        driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys(Password);
        driver.findElement(By.xpath("//button[text()='continue']")).click();

        driver.findElement(By.cssSelector("input[name*='0']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[text()='log in']")).click();

        WebDriverWait explicitwait=new WebDriverWait(driver,Duration.ofSeconds(15));
        explicitwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='fas fa-bars']"))).click();

    }

    public void typeInCapitalLetters(WebDriver driver)
    {
        driver.get("https://id.heroku.com/login");
        Actions action=new Actions(driver);
        WebElement TypeTextBox=driver.findElement(By.xpath("//input[@id='email']"));
        //Double click and Sending Keyboard Keys
        action.moveToElement(TypeTextBox).click().keyDown(Keys.SHIFT).sendKeys("BMdemo").doubleClick().build().perform();
        //Right Click
        action.moveToElement(TypeTextBox).contextClick().build().perform();
    }

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        ActionsDemo obj=new ActionsDemo();


        obj.typeInCapitalLetters(driver);
        obj.login(driver);
        WebElement moveElement=driver.findElement(By.xpath("//div[text()='Analysis']"));

        Actions action=new Actions(driver);
        action.moveToElement(moveElement).build().perform();



    }
}
