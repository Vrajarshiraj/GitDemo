package LoginPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class Scope
{
    public static void Assignment(WebDriver driver)
    {
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

        String CheckBox_Text=driver.findElement(By.xpath("//label[@for='benz']")).getText();
        System.out.println(CheckBox_Text);
        driver.findElement(By.xpath("//input[@id='checkBoxOption2']")).click();

        WebElement dropdown=driver.findElement(By.xpath("//select[@id='dropdown-class-example']"));
        Select dropdownOption=new Select(dropdown);
        dropdownOption.selectByVisibleText(CheckBox_Text);

        driver.findElement(By.id("name")).sendKeys(CheckBox_Text);
        driver.findElement(By.id("alertbtn")).click();

        String AlertText=driver.switchTo().alert().getText();

        if(AlertText.contains(CheckBox_Text))
        {
           System.out.println("Alert Success");
        }
        else
        {
            System.out.println("Alert Failed");
        }



    }

    public static void Learn_SeperateLinks(WebDriver driver) throws InterruptedException {
        // Give me Count of the Link in the Page.
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        int linksize =driver.findElements(By.tagName("a")).size();
        System.out.println("Total Links Available: "+linksize);

        // Count of Links in the Footer in the Page.
        WebElement footerLinksize=driver.findElement(By.xpath("//div[@id='gf-BIG']")); //limiting Webdriver scope
        System.out.println(footerLinksize.findElements(By.tagName("a")).size());

        // Print Count of Links for 1st Column in link
        WebElement Columndriver=footerLinksize.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        System.out.println(Columndriver.findElements(By.tagName("a")).size());

        // Click on each link in the column and check if the pages are opening
        for(int i=1;i<Columndriver.findElements(By.tagName("a")).size();i++)
        {
            String clickOnLinkTab=Keys.chord(Keys.CONTROL,Keys.ENTER);
            Columndriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTab);



        }
        Set<String> windowHandle=driver.getWindowHandles();
        Iterator<String> it= windowHandle.iterator();

        while(it.hasNext())
        {
            driver.switchTo().window(it.next());
            System.out.println(driver.getTitle());
        }
    }





    public static void main(String[] args) throws InterruptedException
    {
        //Print Links Count of the Page

        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        Assignment(driver);

        //Learn_SeperateLinks(driver);

    }



}
