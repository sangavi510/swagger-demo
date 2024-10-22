package swagger_demo;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;

public class swagger  {
	
	@Test
	public void Get_PetsByStatus() {
		
		given().
		when().
			get("https://petstore.swagger.io/v2/pet/findByStatus?status=sold").
		then().
			statusCode(200);
		
	}
	@Test
	public void Post_PlaceAnOrder() {
		
		JSONObject obj = new JSONObject();
		obj.put("id", 500);
		obj.put("petId", 44);
		obj.put("quantity",500);
		obj.put("shipDate" , "2024-10-16T18:55:56.696Z");
		obj.put("status", "placed");
		 obj.put("complete", "true");
		
		given().
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(obj).
		when().post("https://petstore.swagger.io/v2/store/order").
		then().
		statusCode(200).
		log().
		all();
	}

}
