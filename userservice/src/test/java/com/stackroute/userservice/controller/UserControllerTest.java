package com.stackroute.userservice.controller;

import org.junit.runner.RunWith;


import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.testng.Assert;
import org.testng.annotations.*;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import java.util.HashMap;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {
	
	
	@Test(priority=1)
	public void test_registerUser() {
		
		HashMap data = new HashMap();
		data.put("userId", "500");
		data.put("firstName", "aishu");
		data.put("lastName", "aishu");
		data.put("password", "aishu@123");
		
		
		Response res=
		given().contentType("application/json").body(data).when().post("http://localhost:8086/api/user/register")
		.then().statusCode(201).log().body().extract().response();
		
		String jsonString=res.asString();
		Assert.assertEquals(jsonString.contains("User registered successfully"),true);
		
		
		
		
		
	}
	
	@Test(priority=6)
		public void test_registerUser1() {
			
			HashMap data = new HashMap();
			data.put("userId", "111");
			data.put("firstName", "maya");
			data.put("lastName", "mukesh");
			data.put("password", "maya@123");
			
			
			Response res=
			given().contentType("application/json").body(data).when().post("http://localhost:8086/api/user/register")
			.then().statusCode(409).log().body().extract().response();
			
			String jsonString=res.asString();
			Assert.assertEquals(jsonString.contains("User with Id already exists"),true);
			
			
			
			
			
		}

	
	@Test(priority=2)
	public void test_loginUser() {
		
		HashMap data = new HashMap();
		data.put("userId", "111");
		data.put("password", "maya@123");
		
		
		Response resp=
		given().contentType("application/json").body(data).when().post("http://localhost:8086/api/user/login")
		.then().statusCode(200).log().body().extract().response();
		
		String jString=resp.asString();
		Assert.assertEquals(jString.contains("User successfully logged in"),true);
		
		
		//given().auth().preemptive().basic(username, password).when().get("{yourApiURL}").then().statusCode(200);

		
		
	}
	
	@Test(priority=3)
	public void test_loginUser1() {
		
		HashMap data = new HashMap();
		data.put("userId", "111");
		data.put("password", "meena@123");
		
		
		Response resp=
		given().contentType("application/json").body(data).when().post("http://localhost:8086/api/user/login")
		.then().statusCode(401).log().body().extract().response();
		
		String jString=resp.asString();
		Assert.assertEquals(jString.contains("UserId and Password mismatch"),true);
		
		
		//given().auth().preemptive().basic(username, password).when().get("{yourApiURL}").then().statusCode(200);

		
		
	}
	@Test(priority=4)
	public void test_loginUser2() {
		
		HashMap data = new HashMap();
		data.put("userId", "");
		data.put("password", "meena@123");
		
		
		Response resp=
		given().contentType("application/json").body(data).when().post("http://localhost:8086/api/user/login")
		.then().statusCode(401).log().body().extract().response();
		
		String jString=resp.asString();
		Assert.assertEquals(jString.contains("UserId and Password mismatch"),true);
		
		
		//given().auth().preemptive().basic(username, password).when().get("{yourApiURL}").then().statusCode(200);

		
		
	}
	@Test(priority=5)
	public void test_loginUser3() {
		
		HashMap data = new HashMap();
		data.put("userId", "");
		data.put("password", "");
		
		
		Response resp=
		given().contentType("application/json").body(data).when().post("http://localhost:8086/api/user/login")
		.then().statusCode(401).log().body().extract().response();
		
		String jString=resp.asString();
		Assert.assertEquals(jString.contains("UserId and Password mismatch"),true);
		
		
		//given().auth().preemptive().basic(username, password).when().get("{yourApiURL}").then().statusCode(200);

		
		
	}
	
	

}
