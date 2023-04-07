package RESTAssuredPractice;
import Files.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import java.util.logging.Logger;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class BasicAddPlaceAPI
{
    public static String getPlaceID;
    public static String getNewAddress;
    public static void main(String[] args)
    {

        //Add Place >> Update Place With New Address -> Get place to Validate if new Response is Present in address

        //Validate if AddPlace API is Working as per Expected

        //given all input details
        //when - submit the API
        //Then - validate the response

        RestAssured.baseURI="https://rahulshettyacademy.com";
        String givenResponse= given().queryParam("key","qaclick123").header("Content-Type","application/json")
                .body(Payload.AddPlace()).when().post("maps/api/place/add/json")

                .then().log().all().assertThat().statusCode(200).body("scope",equalTo("APP"))
                .header("Server","Apache/2.4.41 (Ubuntu)").extract().response().asString();

        System.out.println(givenResponse);

        JsonPath jp=ReUsableMethods.RawtoJson(givenResponse); //For Parsing Json
        BasicAddPlaceAPI.getPlaceID=jp.getString("place_id");
        System.out.println(BasicAddPlaceAPI.getPlaceID);


        BasicAddPlaceAPI.getNewAddress="Manjalpur,Vadodara";
        //Update the Place
        given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
                .body(Payload.UpdatePlace()).when().put("/maps/api/place/update/json")
                .then().assertThat().statusCode(200).body("msg",equalTo("Address successfully updated"));


        //Get Place API
        String getPlaceResponse= given().log().all().queryParam("key","qaclick123")
                .queryParam("place_id",getPlaceID)
                .when().get("maps/api/place/get/json")
                .then().assertThat().log().all().statusCode(200).extract().response().asString();

        JsonPath js1=ReUsableMethods.RawtoJson(getPlaceResponse);
        String actualAddress= js1.getString("address");
        System.out.println(actualAddress);
        Assert.assertEquals(actualAddress,getNewAddress);

    }
}
