package test.RestAPIAutomation;

public class Payload
{
    public static String Addplace()
    {
        return """
                {
                  "location": {
                    "lat": -38.383494,
                    "lng": 33.427362
                  },
                  "accuracy": 50,
                  "name": "Frontline house",
                  "phone_number": "(+91) 983 893 3937",
                  "address": "29, side layout, cohen 09",
                  "types": [
                    "shoe park",
                    "shop"
                  ],
                  "website": "http://google.com",
                  "language": "French-IN"
                }
                """;
    }

    public static String CoursePrice()
    {
        return """
                {

                "dashboard": {

                "purchaseAmount": 910,

                "website": "rahulshettyacademy.com"

                },

                "courses": [

                {

                "title": "Selenium Python",

                "price": 50,

                "copies": 6

                },

                {

                "title": "Cypress",

                "price": 40,

                "copies": 4

                },

                {

                "title": "RPA",

                "price": 45,

                "copies": 10

                }

                ]

                }""";
    }

    public static String addbook(String isbn,String aisle)
    {
        String payload="{\n" +
                "\n" +
                "\"name\":\"Learn Appium Automation with Java\",\n" +
                "\"isbn\":\""+isbn+"\",\n" +
                "\"aisle\":\""+aisle+"\",\n" +
                "\"author\":\"John foe\"\n" +
                "}\n";
        return payload;
    }

    public static String Deletebook(String id)
    {
        String payload="";
        return payload;
    }

}
