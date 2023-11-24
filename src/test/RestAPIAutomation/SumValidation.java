package test.RestAPIAutomation;

import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SumValidation
{
    @Test
    public void sumOfCourses()
    {
        JsonPath js=new JsonPath(Payload.CoursePrice());
        int count=js.getInt("courses.size()");

        int purchaseAmount=js.getInt("dashboard.purchaseAmount");

        int[] price = new int[3];
        int[] copies = new int[3];
        int calcTotalAmount=0;
        for(int i=0;i<count;i++)
        {
            price[i]=js.getInt("courses["+i+"].price");
            copies[i]=js.getInt("courses["+i+"].copies");

            calcTotalAmount=calcTotalAmount+price[i]*copies[i];
        }
        System.out.println("Total:"+calcTotalAmount);
        Assert.assertEquals(calcTotalAmount,purchaseAmount);
    }
}
