package apiPackage;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class Requests {
	@Test
	void getUsers() {
		given()
		
		.when()
		.get("https://reqres.in/api/users?page=2")
		
		.then()
		.statusCode(200)
		.body("page",equalTo(2))
		.log().all();
		}
	
	@Test
	void createUsers() {
		HashMap data = new HashMap();
		data.put("name","Hemanth");
		data.put("job","Designer");
		
		Response res=
		given()
		.contentType("application/json")
		.body(data)
		
		.when()
		.post("https://reqres.in/api/users?page=2")
		
		.then()
		.statusCode(201)
		.log().all()
		.extract().response();
		String jsonString = res.asString();
		System.out.println(jsonString);
	}
	@Test
	void updateUser()
	{	
		HashMap data = new HashMap();
        data.put("id", "7");
		data.put("email","michael.lawson@reqres.in");
		data.put("first_name","Michael");
		data.put("last_name","Lawson");
		data.put("avatar","https://reqres.in/img/faces/7-image.jpg");
		 

		given()
		.contentType("application/json")
		.body(data)
		
		.when()
		.put("https://reqres.in/api/users?page=2")
		
		.then()
		.statusCode(201)
		.log().all()
		.extract().response();
	
	given()
	.contentType("application/json")
	.body(data)
	
	.when()
	.get("https://reqres.in/api/users?page=2")
	
	.then()
	.statusCode(201)
	.log().all()
	.body("email", equalTo("Michael"))
	.extract().response();

}
}


