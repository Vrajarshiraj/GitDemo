package test.RestAPIAutomation;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import test.POJO.Api;
import test.POJO.GetCourse;
import test.POJO.WebAutomation;

import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

public class OauthDemo
{
    public static void main(String[] args) throws InterruptedException {

        String URL="https://rahulshettyacademy.com/getCourse.php?state=Gujarat&code=4%2F0AfJohXlCJ85equR-Yc6C4qQciNT6nM84yM7kGd1v3ahWdJCkOsH_8N15PSbUqQprlDSyXA&scope=email+openid+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email&authuser=1&prompt=none";
        String[] courseTitles= {"Selenium Webdriver Java","Cypress","Protractor"};
        String partialcode=URL.split("code=")[1];
        String code=partialcode.split("&scope")[0];

        System.out.println(code);



        //for get Access Token
        String accessTokenResponse;
        accessTokenResponse = given().queryParams("code",code).urlEncodingEnabled(false).
                queryParams("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com").
                queryParams("client_secret","erZOWM9g3UtwNRj340YYaK_W").
                queryParams("redirect_uri","https://rahulshettyacademy.com/getCourse.php").
                queryParams("grant_type","authorization_code")
                .when().log().all().
                post("https://www.googleapis.com/oauth2/v4/token").asString();

        JsonPath js=new JsonPath(accessTokenResponse);
        String accessToken=js.getString("access_token");

        GetCourse gc=given().queryParam("access_token",accessToken)
                .expect().defaultParser(Parser.JSON)
                .when().get("https://rahulshettyacademy.com/getCourse.php").as(GetCourse.class);

        System.out.println(gc.getLinkedIn());
        System.out.println(gc.getInstructor());
        System.out.println(gc.getCourses().getMobile().get(0).getCourseTitle());

        List<Api> apiCourses=gc.getCourses().getApi();

        for (int i=0;i<apiCourses.size();i++)
        {
            if(apiCourses.get(i).getCourseTitle().equalsIgnoreCase("Rest Assured Automation using Java"))
            {
                System.out.println(apiCourses.get(i).getPrice());
            }
        }

        // Get the course name of web automation
        ArrayList<String> a=new ArrayList<String>();
        List<WebAutomation> actualList=gc.getCourses().getWebAutomation();
        for(int i=0;i<actualList.size();i++)
        {
            a.add(actualList.get(i).getCourseTitle());
        }

        List<String> expectedList= Arrays.asList(courseTitles);

        System.out.println(expectedList);
        System.out.println(a);

        Assert.assertTrue(a.equals(expectedList));
    }
}
