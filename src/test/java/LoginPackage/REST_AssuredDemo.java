package LoginPackage;
import io.restassured.RestAssured;
import io.restassured.response.Response;



public class REST_AssuredDemo
{
    public void DemoTest()
    {
          Response response=RestAssured.get("https://reqres.in/api/users?page=2");

          System.out.println("Response:"+response.asString());
          System.out.println("Status Code:"+response.getStatusCode());
          System.out.println("Response Body:"+response.getBody().asString());
          System.out.println("Response Time:"+response.time());
    }

    public static void main(String[] args)
    {
        REST_AssuredDemo obj = new REST_AssuredDemo();
        obj.DemoTest();
    }


}
