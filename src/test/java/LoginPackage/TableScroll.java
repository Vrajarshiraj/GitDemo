package LoginPackage;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class TableScroll
{

    public void Assignment(WebDriver driver)
    {
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,600)");

        WebElement TableName=driver.findElement(By.xpath("//table[@name='courses']"));

        int TableRows=TableName.findElements(By.xpath("//tbody //tr")).size();
        System.out.println("Rows of Table: "+TableRows);


        int TableColumns=TableName.findElements(By.xpath("//tbody //th")).size();
        System.out.println("Rows of Header:"+TableColumns);

        List<WebElement> SecondRow =TableName.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));

        System.out.println(SecondRow.get(0).getText());
        System.out.println(SecondRow.get(1).getText());
        System.out.println(SecondRow.get(2).getText());




    }

    public void SearchKeydown_Assign(WebDriver driver) throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        driver.findElement(By.id("autocomplete")).sendKeys("Ind");

        driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
        driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);

        Thread.sleep(1000);
        System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value"));

    }

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.edge.driver","C:\\Selenium\\msedgedriver.exe");
        WebDriver driver=new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,600)");
        Thread.sleep(2500);
        js.executeScript("document.querySelector('.tableFixHead').scrollTop=4000");

        List<WebElement> values=driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
        int sum=0;
        for(int i=0;i<values.size();i++)
        {
            sum=sum+ Integer.parseInt(values.get(i).getText());
        }
        System.out.println(sum);

        int UITotal=Integer.parseInt(driver.findElement(By.xpath("//div[@class='totalAmount']")).getText().split(": ")[1].trim());
        Assert.assertEquals(sum,UITotal);

        // Assignment
        TableScroll obj=new TableScroll();
        obj.Assignment(driver);

        TableScroll obj2=new TableScroll();
        obj2.SearchKeydown_Assign(driver);

        //driver.quit();

    }
}
