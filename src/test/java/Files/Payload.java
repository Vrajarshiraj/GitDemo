package Files;
import RESTAssuredPractice.BasicAddPlaceAPI;

public class Payload
{
    public static String AddPlace()
    {
        return "{\n" +
                "  \"location\": {\n" +
                "    \"lat\": -38.383494,\n" +
                "    \"lng\": 33.427362\n" +
                "  },\n" +
                "  \"accuracy\": 50,\n" +
                "  \"name\": \"Devfali\",\n" +
                "  \"phone_number\": \"(+91) 983 893 3937\",\n" +
                "  \"address\": \"29, Devfali, Sinor\",\n" +
                "  \"types\": [\n" +
                "    \"shoe park\",\n" +
                "    \"shop\"\n" +
                "  ],\n" +
                "  \"website\": \"http://google.com\",\n" +
                "  \"language\": \"RandomNumbers\"\n" +
                "}";
    }
    public static String UpdatePlace()
    {
         return "{\n" +
                 "    \"place_id\": \""+BasicAddPlaceAPI.getPlaceID+"\",\n" +
                 "    \"address\": \""+BasicAddPlaceAPI.getNewAddress+"\",\n" +
                 "    \"name\":\"Rohit\",\n" +
                 "    \"key\": \"qaclick123\"\n" +
                 "}";
    }
}
