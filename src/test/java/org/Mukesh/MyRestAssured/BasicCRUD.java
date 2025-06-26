package org.Mukesh.MyRestAssured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class BasicCRUD {
    @Test
    public void createUser() {
        String payload = "{\"name\":\"Mukesh\",\"job\":\"tester\"}";

        given()
            .baseUri("https://reqres.in")
            .header("x-api-key", "reqres-free-v1")
            .contentType(ContentType.JSON)
            .body(payload)
            .log().all()
        .when()
            .post("/api/users")
        .then()
            .statusCode(201)
            .log().all();
    }
    
    @Test
    public void getUser() {
    	given()
    	.header("x-api-key", "reqres-free-v1")
    	.baseUri("https://reqres.in")
    	.get("/api/users/2")
    	.then()
    	.statusCode(200)
    	.log().all();
    }
    
    @Test
    public void updateUser() {
    	String payload = "{\"name\":\"Mukesh\",\"job\":\"Senior tester\"}";
    		given()
	    	.baseUri("https://reqres.in")
	    	.header("x-api-key", "reqres-free-v1")
	    	.contentType(ContentType.JSON)
	    	.body(payload)
	    .when()
	    	.put("/api/users/2")
	    .then()
	    	.statusCode(200)
	    	.log().all();
    }
    @Test
    public void deleteUser() {
        given()
            .baseUri("https://reqres.in")
            .header("x-api-key", "reqres-free-v1")
        .when()
            .delete("/api/users/2")
        .then()
            .statusCode(204)  // No Content
            .log().all();
    }

    @Test
    public void extractResponse() {
    	String payload = "{\"name\":\"Mukesh\",\"job\":\"Senior tester\"}";

    Response response = 
    	    given()
    	        .baseUri("https://reqres.in")
    	        .header("x-api-key", "reqres-free-v1")
    	        .contentType(ContentType.JSON)
    	        .body(payload)
    	    .when()
    	        .post("/api/users");

    	String job = response.jsonPath().getString("job");
    	System.out.println("Job : " + job);
    }
}
