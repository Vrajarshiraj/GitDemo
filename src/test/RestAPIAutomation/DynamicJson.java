package test.RestAPIAutomation;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DynamicJson {

    @Test(dataProvider = "BooksData")
    public void AddBook(String isbn,String aisle)
    {
        RestAssured.baseURI="http://216.10.245.166";
         String response=given().header("Content-Type","application/json").
                body(Payload.addbook(isbn,aisle)).
                when().post("Library/Addbook.php").
                then().log().all().assertThat().statusCode(200).
                extract().response().asString();

        JsonPath js=ReUsableMethods.rawToJson(response);
        String id=js.get("ID");

        System.out.println(id);

        //DeleteBook API
        given().header("Content-Type","application/json").
                body(Payload.Deletebook("")).
                when().post(":/Library/DeleteBook.php").
                then().log().all().assertThat().statusCode(200).
                extract().response().asString();



    }

    @DataProvider(name = "BooksData")
    public Object[][] getdata()
    {
         return new Object[][]{{"Raama","1234"},{"Treats_of_Axar","1234"},{"Rambo","1234"}};
    }
}
