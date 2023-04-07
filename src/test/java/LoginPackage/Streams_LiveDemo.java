package LoginPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class Streams_LiveDemo
{
    public static void main(String[] args)
    {
        System.setProperty("webdriver.edge.driver","C:\\Selenium\\msedgedriver.exe");
        WebDriver driver=new EdgeDriver();
        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        //click on column
        driver.findElement(By.xpath("//thead/tr/th[1]")).click();
        //Capture all elements into One list
        List<WebElement> elementList=driver.findElements(By.xpath("//tr/td[1]"));
        //Capture Text of all webelements into new list
         List<String> OriginalElementList= elementList.stream().map(s->s.getText()).collect(Collectors.toList());
        // sort in the original list of step 3 --> Sorted list
        List<String> SortedElementList=OriginalElementList.stream().sorted().collect(Collectors.toList());
        //compare original list vs sorted list
        Assert.assertTrue(OriginalElementList.equals(SortedElementList));
        System.out.println(OriginalElementList);
        System.out.println(SortedElementList);

        List<String> price;

        do {
            List<WebElement> rows=driver.findElements(By.xpath("//tr/td[1]"));
            //scan the name column with gettext -> Rice -> Print the Price of Rice
            price=rows.stream().filter(s->s.getText().contains("Rice")).map(s->getPriceveggie(s)).collect(Collectors.toList());
            price.forEach(a->System.out.println(a));

            if(price.size()<1)
            {
                driver.findElement(By.xpath("//a[@aria-label=\"Next\"]")).click();
            }

        }while(price.size()<1);

    }

    private static String getPriceveggie(WebElement s) {
        String PriceValue=s.findElement(By.xpath("following-sibling::td[1]")).getText();
        return PriceValue;
    }
}
