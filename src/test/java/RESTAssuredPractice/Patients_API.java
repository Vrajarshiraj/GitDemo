package RESTAssuredPractice;
import Files.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import java.util.logging.Logger;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

public class Patients_API
{
    public String RequestKey="80cc6b4416c82aeeadb664216f73726c";
    @Test
    public void Get_PatientsAPI()
    {
        RestAssured.baseURI="https://qaapi.sikkasoft.com";

        String givenResponse= given().queryParam("request_key",RequestKey).header("User-Agent","PostmanRuntime/7.29.2")
                .when().get("v2/patients")

                .then().assertThat().statusCode(200).header("Server","Microsoft-IIS/8.5")
                .header("Data-Insert","completed").extract().response().asString();

    }
}
