package test.RestAPIAutomation;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Basic {

    public static void main(String[] args) throws IOException
    {
        String payload=new String(Files.readAllBytes(Paths.get("V:\\APIV4 Portal\\REST Assured\\AddPlace.txt")));
        RestAssured.baseURI= "https://rahulshettyacademy.com";
        String response =given().log().all().queryParam("key","qaclick123")
                .header("Content-type","application/json")
                .body(payload).when().post("/maps/api/place/add/json")
                .then().log().all().assertThat().statusCode(200).body("scope",equalTo("APP"))
                .extract().response().asString();

         System.out.println(response);
        JsonPath js=new JsonPath(response);
        String placeId=js.getString("place_id");


        //Update Place
        String newAddress="Summer Walk, Africa";

        given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
                .body("{\n" +
                        "\"place_id\":\""+placeId+"\",\n" +
                        "\"address\":\""+newAddress+"\",\n" +
                        "\"key\":\"qaclick123\"\n" +
                        "}\n").
                when().put("/maps/api/place/update/json").
                then().assertThat().statusCode(200).body("msg",equalTo("Address successfully updated"));


        //Get Place API

        String getplaceResponse=given().log().all().queryParam("key","qaclick123").queryParam("key","qaclick123")
                .queryParam("place_id",placeId)
                .when().get("/maps/api/place/get/json").then()
                .assertThat().statusCode(200).body("address",equalTo(newAddress)).extract().asString();

        JsonPath jsonPath=ReUsableMethods.rawToJson(getplaceResponse);
        String actualAddress=jsonPath.getString("address");

        Assert.assertEquals(actualAddress,newAddress);
    }
}
