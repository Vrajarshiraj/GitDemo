package LoginPackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.sql.Driver;

public class AutoITTutorial {

    public void checkAutoIT(WebDriver driver) throws InterruptedException, IOException {
        driver.get("https://smallpdf.com/pdf-to-jpg");
        driver.findElement(By.xpath("//button[@class='l3tlg0-0 ggoliT']")).click();
        Thread.sleep(3000);
        Runtime.getRuntime().exec("C:\\Users\\vrajarshiraj.shah\\Documents\\fileupload.exe");
    }
    public static void main(String[] args) throws IOException, InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://admin:admin@the-internet.herokuapp.com/");
        driver.findElement(By.xpath("//a[text()='Basic Auth']")).click();

        AutoITTutorial obj=new AutoITTutorial();
        obj.checkAutoIT(driver);

    }
}
