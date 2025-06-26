package razorpayApi;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utils.ConfigReaderUtils;
import utils.payloadUtils;

import org.testng.annotations.Test;

import java.util.Base64;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.equalTo;
public class RazorpayTests {
	 ConfigReaderUtils configreader = new ConfigReaderUtils();   
    @Test
    public void createOrder() {
           

       
        String credentials = configreader.keyId() + ":" + configreader.keySecret();
        String encodedCreds = Base64.getEncoder().encodeToString(credentials.getBytes());

        // Order payload
        String payload = payloadUtils.loadPayload("payloads/createOrderPayload.json");

        // Send request
        Response res = given()
                .baseUri("https://api.razorpay.com/v1")
                .header("Authorization", "Basic " + encodedCreds)
                .contentType(ContentType.JSON)
                .body(payload)
                .log().all()
            .when()
                .post("/orders")
            .then()
                .statusCode(200)
                .log().all()
                .extract().response();

        // Extract order ID
        String orderId = res.jsonPath().getString("id");
        System.out.println(" Order Created with ID: " + orderId);
    }
    
    @Test
    public void createPaymentLink() {
       
        String creds = configreader.keyId() + ":" + configreader.keySecret();
        String encodedCreds = Base64.getEncoder().encodeToString(creds.getBytes());

        String payload = payloadUtils.loadPayload("payloads/createPaymentPayload.json");

        given()
            .baseUri("https://api.razorpay.com/v1")
            .header("Authorization", "Basic " + encodedCreds)
            .contentType(ContentType.JSON)
            .body(payload)
        .when()
            .post("/payment_links")
        .then()
            .statusCode(200)
            .log().all();
    }
    
    @Test
    public void getOrderById() {
        String orderId = configreader.getorderId();
        String creds = configreader.keyId() + ":" + configreader.keySecret();
        String encodedCreds = Base64.getEncoder().encodeToString(creds.getBytes());

        RestAssured.baseURI = "https://api.razorpay.com/v1";

        Response response = given()
            .header("Authorization", "Basic " + encodedCreds)
        .when()
            .get("/orders/" + orderId)
        .then()
            .extract().response(); 

      
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response Body:\n" + response.getBody().asPrettyString());
    }

    @Test
    public void getAllOrders() {
    	 String creds = configreader.keyId() + ":" + configreader.keySecret();
    	 String encodedCreds = Base64.getEncoder().encodeToString(creds.getBytes());    	
        RestAssured.baseURI = "https://api.razorpay.com/v1";

        Response response = given()
            .header("Authorization", "Basic " + encodedCreds)
        .when()
            .get("/orders?count=3") 
        .then()
            .statusCode(200)
            .extract().response();

        System.out.println("Order list response:\n" + response.asPrettyString());
    }

    @Test
    public void cancelPaymentLink() {
        String paymentLinkId = configreader.paymentLinkId(); 
        String creds = configreader.keyId() + ":" + configreader.keySecret();
   	 String encodedCreds = Base64.getEncoder().encodeToString(creds.getBytes()); 
        Response response = given()
            .baseUri("https://api.razorpay.com/v1")
            .header("Authorization", "Basic " + encodedCreds)
        .when()
            .post("/payment_links/" + paymentLinkId + "/cancel")
        .then()
            .statusCode(200)
            .body("status", equalTo("cancelled"))
            .extract().response();

        System.out.println("Cancel response:\n" + response.asPrettyString());
    }

}
