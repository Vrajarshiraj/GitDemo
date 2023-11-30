package test.RestAPIAutomation;
import static io.restassured.RestAssured.given;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.Assert;
import test.POJO.LoginRequest;
import test.POJO.LoginResponse;
import test.POJO.OrderDetail;
import test.POJO.Orders;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class EcommerceTest
{
    public static void main(String[] args)
    {
       RequestSpecification req=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").setContentType(ContentType.JSON).build();

        LoginRequest loginRequest=new LoginRequest();
        loginRequest.setUserEmail("testsikka@gmail.com");
        loginRequest.setUserPassword("txYsz@F28efAZyG");

       RequestSpecification reqLogin= given().spec(req).body(loginRequest);

       LoginResponse loginResponse=reqLogin.when().post("/api/ecom/auth/login").then().extract().response().as(LoginResponse.class);

       System.out.println(loginResponse.getToken());
       System.out.println(loginResponse.getUserId());
       System.out.println(loginResponse.getMessage());


       //Add Product
        String productName="M S Dhoni";

        RequestSpecification addProductBaseRequest = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
                .addHeader("Authorization", loginResponse.getToken()).build();

        RequestSpecification reqAddProduct = given().spec(addProductBaseRequest).param("productName", productName)
                .param("productAddedBy", loginResponse.getUserId())
                .param("productCategory", "fashion")
                .param("productSubCategory", "shirts")
                .param("productPrice", "1800")
                .param("productDescription", "Adidas Original")
                .param("productFor", "Men")
                .multiPart("productImage", new File("V:\\APIV4 Portal\\POSTMAN API\\POSTMAN E2E Login Cred\\MSDhoni.jpg"));


           String addProductResponse= reqAddProduct.when().post("/api/ecom/product/add-product/").then().log().all().extract().response().asString();

           JsonPath js=new JsonPath(addProductResponse);
           String productId=js.getString("productId");

           //Create Order
           RequestSpecification createOrderBaseRequest=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
                   .addHeader("Authorization", loginResponse.getToken()).build();

        OrderDetail orderDetail=new OrderDetail();
        orderDetail.setProductOrderId(productId);
        orderDetail.setCountry("India");

        List<OrderDetail> orderDetailList=new ArrayList<>();
        orderDetailList.add(orderDetail);

           Orders orders=new Orders();
           orders.setOrders(orderDetailList);


        RequestSpecification createOrderRequest = given().spec(createOrderBaseRequest).body(orders);


        String createOrderResponse=createOrderRequest.when().post("/api/ecom/order/create-order").then().log().all().extract().response().asString();

        //View Order Details

        RequestSpecification viewOrderBaseRequest=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
                .addHeader("Authorization", loginResponse.getToken()).build();

        RequestSpecification viewOrderRequest=given().spec(viewOrderBaseRequest).queryParam("id",productId);

        String viewOrderResponse=viewOrderRequest.when().get("/api/ecom/order/get-orders-details").then().extract().response().asString();


        //DeleteProductBaseReq

        RequestSpecification deleteProductBaseRequest=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
                .addHeader("Authorization", loginResponse.getToken()).build();

        RequestSpecification deleteProductRequest=given().spec(deleteProductBaseRequest).pathParam("productID",productId);

        String deleteProduct=deleteProductRequest.when().delete("/api/ecom/product/delete-product/{productID}").then().log().all().extract().response().asString();

        JsonPath js1=new JsonPath(deleteProduct);
        String actualMessage=js1.getString("message");

        Assert.assertEquals(actualMessage,"Product Deleted Successfully");

    }
}
