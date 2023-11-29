package test.POJO;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class SpecBuilderTest
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


        RequestSpecification req=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key","qaclick123").setContentType(ContentType.JSON).build();

        ResponseSpecification resspec=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

        RequestSpecification request=given().spec(req).body(p);


        Response response= request.when().post("/maps/api/place/add/json")
                .then().spec(resspec).extract().response();

        System.out.println(response);
         System.out.println(given().queryParam("key","qaclick123").urlEncodingEnabled(false)
                 .body(p).toString());
    }
}
