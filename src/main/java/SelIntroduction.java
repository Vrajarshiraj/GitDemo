import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelIntroduction
{
    public static void main(String[] args)
    {
        //System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
        //WebDriver driver=new ChromeDriver();

        //System.setProperty("webdriver.gecko.driver","C:\\Selenium\\geckodriver.exe");
        //WebDriver driver=new FirefoxDriver();

        System.setProperty("webdriver.edge.driver","C:\\Selenium\\msedgedriver.exe");
        WebDriver driver=new EdgeDriver();

        driver.get("https://courses.rahulshettyacademy.com/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.quit();
    }
}
