package test.RestAPIAutomation;

import io.restassured.path.json.JsonPath;

public class ComplexJsonParse
{
    public static void main(String[] args)
    {
        JsonPath js=new JsonPath(Payload.CoursePrice());

        //print number of courses returned by API
    }
}
