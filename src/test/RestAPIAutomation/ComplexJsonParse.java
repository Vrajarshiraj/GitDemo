package test.RestAPIAutomation;

import io.restassured.path.json.JsonPath;
import org.testng.Assert;

public class ComplexJsonParse
{
    public static void main(String[] args)
    {
        JsonPath js=new JsonPath(Payload.CoursePrice());

        //print number of courses returned by API
        int count=js.getInt("courses.size()");
        System.out.println(count);

        //print purchase amount by API
        int purchaseAmount=js.getInt("dashboard.purchaseAmount");
        System.out.println(purchaseAmount);

        //print title of the first course
        String titleOfFirstCourse=js.getString("courses[0].title");
        System.out.println(titleOfFirstCourse);

        // print no of copies sold by RPA course
        for(int i=0;i<count;i++)
        {
            String titleOfcourse=js.getString("courses["+i+"].title");

            if(titleOfcourse.equals("RPA"))
            {
                String copiesOfRPA=js.getString("courses["+i+"].copies");
                System.out.println("RPA Copies:"+copiesOfRPA);
                break;
            }
        }

        //print all course titles and respective price
        for(int i=0;i<count;i++)
        {
            String titleOfcourse=js.getString("courses["+i+"].title");
            int Amount=js.getInt("courses["+i+"].price");

            System.out.println("Title: "+titleOfcourse);
            System.out.println("Amount: "+Amount);
        }


        //Verify if sum of all courses price matches with Purchase Amount
        int[] price = new int[3];
        int[] copies = new int[3];
        int calcTotalAmount=0;
        for(int i=0;i<count;i++)
        {
            price[i]=js.getInt("courses["+i+"].price");
            copies[i]=js.getInt("courses["+i+"].copies");

            calcTotalAmount=calcTotalAmount+price[i]*copies[i];
        }
        System.out.println("Total"+calcTotalAmount);
        Assert.assertEquals(calcTotalAmount,purchaseAmount);
    }
}

