package apiTest;

import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import io.restassured.response.Response;

public class ApiTest{
	private final String HomeUrl = "https://reqres.in";
	@Test
	public void testOne() {
		String employeeEmail = "janet.weaver@reqres.in";
		String request = "/api/users/2";
		Response response = given().get(HomeUrl + request);
		String responseEmail = response.jsonPath().get("data.email");
		//System.out.println(responseEmail);
		
		assertTrue(employeeEmail.equals(responseEmail));
	}
	
	@Test
	public void testTwo() {
		String request = "/api/login";
		String email = "eve.holt@reqres.in";
		String password = "cityslicka";
		String token = "QpwL5tke4Pnpja7X4";
		
		String tokenReturn = given().params("password", password, "email", email).when().post(HomeUrl + request).then().extract().jsonPath().getString("token");
		assertTrue(token.equals(tokenReturn));
	}
	
	
	@Test
	public void testThree() {
		/*
		 * a. Write a test that verifies the response code of 204. 
b. Lookup response code 204 and add it to your test as a comment.
		 */
		String request = "/api/users/2";
		
		int returnStatusCode = when().delete(HomeUrl + request).then().extract().statusCode();
		
		assertEquals(204, returnStatusCode);
	}
	
	@Test
	public void testFour() {
		String request = "/api/users/2";
		
		given().param("name", "Morpheus2").when().patch(HomeUrl + request).then().statusCode(200);
	}
	
	@Test
	public void testFive() {
		String request = "/api/users/2";
		
		given().param("name", "Morpheus2").when().put(HomeUrl + request).then().statusCode(200).log().all();
	}
	
	public JSONObject deserializeSingleTest() {
		String request = "/api/users/2";
		Response response = given().get(HomeUrl + request);
		String responseEmail = response.jsonPath().get("data.email");
		int responseId = response.jsonPath().get("data.id");
		String responseFirstName = response.jsonPath().get("data.first_name");
		String responseLastName = response.jsonPath().get("data.last_name");
		String responseAvatar = response.jsonPath().get("data.avatar");
		
		JSONObject result = deserializeSingle(responseEmail, responseId, responseFirstName, responseLastName, responseAvatar);
		return result;
	}
	
	public JSONObject deserializeSingle(String responseEmail, int responseId, String responseFirstName, String responseLastName, String responseAvatar) {
		JSONObject result = new JSONObject();
		result.put("avatar", responseAvatar);
		result.put("last_name", responseLastName);
		result.put("firat_name", responseFirstName);
		result.put("email", responseEmail);
		result.put("id", responseId);
		return result;
		
	}
	
	public List<JSONObject> deserializeMultipleTest() {
		String request = "/api/users?page=2";
		Response response = given().get(HomeUrl + request);
		List<String> responseEmail = response.jsonPath().getList("data.email");
		List<Integer> responseId = response.jsonPath().getList("data.id");
		List<String> responseFirstName = response.jsonPath().getList("data.first_name");
		List<String> responseLastName = response.jsonPath().getList("data.last_name");
		List<String> responseAvatar = response.jsonPath().getList("data.avatar");
		
		List<JSONObject> result = new ArrayList<JSONObject>();
		for(int i = 0; i < responseEmail.size(); i++) {
			String tempEmail = responseEmail.get(i);
			int tempId = responseId.get(i);
			String tempFirstName = responseFirstName.get(i);
			String tempLastName = responseLastName.get(i);
			String tempAvatar = responseAvatar.get(i);
			JSONObject element = deserializeSingle(tempEmail, tempId, tempFirstName, tempLastName, tempAvatar);
			result.add(element);
		}
		return result;
	}
}
