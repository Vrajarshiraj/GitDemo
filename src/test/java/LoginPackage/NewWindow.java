package LoginPackage;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class NewWindow
{
    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.edge.driver","C:\\Selenium\\msedgedriver.exe");
        WebDriver driver=new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        driver.switchTo().newWindow(WindowType.TAB);

        Set<String> handles=driver.getWindowHandles();
        Iterator<String> it=handles.iterator();
        String ParentWindowId=it.next();
        String ChildWindowId=it.next();

        driver.switchTo().window(ChildWindowId);
        driver.get("https://rahulshettyacademy.com/");
        String GrabText=driver.findElement(By.xpath("//a[text()='All-Access Membership-Complete Access to 25+ Courses (and counting!)']")).getText();

        driver.switchTo().window(ParentWindowId);
        driver.findElement(By.xpath("//form//div//input[@name='name']")).sendKeys(GrabText);
         WebElement NametextBox=driver.findElement(By.xpath("//form//div//input[@name='name']"));
        //Screenshot of WebElement
        File file=NametextBox.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("C:\\Users\\vrajarshiraj.shah\\Desktop\\APIV4 Portal\\WebElementScrshot.png"));

        System.out.println(NametextBox.getRect().height);
        System.out.println(NametextBox.getRect().width);

    }
}
