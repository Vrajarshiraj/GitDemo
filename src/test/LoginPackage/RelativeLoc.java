package test.LoginPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeLoc
{
    public static void main(String[] args)
    {
        System.setProperty("webdriver.edge.driver","C:\\Selenium\\msedgedriver.exe");
        WebDriver driver=new EdgeDriver();
        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com/angularpractice/");

        WebElement nameTextBox= driver.findElement(By.cssSelector("[name='name']"));
        String findlabel=driver.findElement(with(By.tagName("label")).above(nameTextBox)).getText();
        System.out.println(findlabel);

        WebElement Dob_label= driver.findElement(By.xpath("//label[@for=\"dateofBirth\"]"));
        driver.findElement(with(By.tagName("input")).below(Dob_label)).click();

        WebElement CheckMe_label=driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
        driver.findElement(with(By.tagName("input")).toLeftOf(CheckMe_label)).click();

        WebElement radioButton=driver.findElement(By.id("inlineRadio1"));

        System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(radioButton)).getText());
    }
}
