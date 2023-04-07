package RESTAssuredPractice;

import io.restassured.path.json.JsonPath;

public class ReUsableMethods {

    public static JsonPath RawtoJson(String response)
    {
        JsonPath json=new JsonPath(response);
        return json;
    }

}
