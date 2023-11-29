package test.POJO;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class SerializeTest
{
    public static void main(String[] args)
    {
        RestAssured.baseURI="https://rahulshettyacademy.com";

        AddPlace p=new AddPlace();
        p.setAccuracy("50");
        p.setAddress("29, Devfali, Sinor");
        p.setName("Devfali");

        Location l=new Location();
        l.setLat(-38.383494);
        l.setLng(33.427362);
        p.setLocation(l);

        List<String> myList=new ArrayList<String>();
        myList.add("shoe park");
        myList.add("shop");

        p.setTypes(myList);
        p.setWebsite("http://google.com");
        p.setPhone_number("(+91) 983 893 3937");
        p.setLanguage("English");

        String response=given().queryParam("key","qaclick123").urlEncodingEnabled(false)
                .body(p)
                .when().log().all()
                .post("/maps/api/place/add/json")
                .then().assertThat().statusCode(200).extract().response().asString();


         System.out.println(response);
         System.out.println(given().queryParam("key","qaclick123").urlEncodingEnabled(false)
                 .body(p).toString());
    }
}
