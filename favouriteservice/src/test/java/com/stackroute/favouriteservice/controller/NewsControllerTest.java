package com.stackroute.favouriteservice.controller;

import org.junit.runner.RunWith;




import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.testng.Assert;
import org.testng.annotations.*;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import java.util.HashMap;


@RunWith(SpringRunner.class)
@WebMvcTest(NewsController.class)
public class NewsControllerTest {
	
	@Test(priority=1)
	public void test_saveNews() {
		
		String token ="eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxMTAiLCJpYXQiOjE2MTM4MTI1Nzh9.u9I0vQ0UorIt1y4nBlUqzWIe0USnnk5C_pZpVXBuyw4";
		
		HashMap data = new HashMap();
		data.put("id", 27);
		data.put("title", " corona");
		data.put("publishedAt", "uuu ");
		data.put("content", "uuuu ");
		data.put("urlToImage", "iiiii ");
		data.put("url", " jjjj");
		data.put("userId", " anjali01");
		
		
		Response res=
				
				given().header("Authorization", "Bearer " + token).contentType("application/json").with().body(data).when().post("http://localhost:8085/api/newsservice/news")
				.then().statusCode(201).log().body().extract().response();
				
					
				
	
		
		}
	
	@Test(priority=2)	
public void test_saveNews1() {
		
		String token ="eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxMTAiLCJpYXQiOjE2MTM4MTI1Nzh9.u9I0vQ0UorIt1y4nBlUqzWIe0USnnk5C_pZpVXBuyw4";
		
		HashMap data = new HashMap();
		data.put("id", 27);
		data.put("title", " corona");
		data.put("publishedAt", "uuu ");
		data.put("content", "uuuu ");
		data.put("urlToImage", "iiiii ");
		data.put("url", " jjjj");
		data.put("userId", " anjali01");
		
		
		Response res=
				
				given().header("Authorization", "Bearer " + token).contentType("application/json").with().body(data).when().post("http://localhost:8085/api/newsservice/news")
				.then().statusCode(409).log().body().extract().response();
				
					
				
	
		
		}
	
	
	
	@Test(priority=3)
	public void test_deleteNewsById() {
		
		String token ="eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxMTAiLCJpYXQiOjE2MTM4MTI1Nzh9.u9I0vQ0UorIt1y4nBlUqzWIe0USnnk5C_pZpVXBuyw4";

		
		Response res=given().header("Authorization", "Bearer " + token).contentType("application/json").when().delete("http://localhost:8085/api/newsservice/news/32")
				.then().statusCode(200).log().body().extract().response();
		
		String jString=res.asString();
		Assert.assertEquals(jString.contains("news deleted successfully"),true);
				
				
				//given().when().delete("http://localhost:8085/api/newsservice/news/11")
				//.then().statusCode(200).log().body().extract().response();
		
		
	}
	
	
	@Test(priority=4)
		public void test_deleteNewsById1() {
			
			String token ="eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxMTAiLCJpYXQiOjE2MTM4MTI1Nzh9.u9I0vQ0UorIt1y4nBlUqzWIe0USnnk5C_pZpVXBuyw4";

			
			Response res=given().header("Authorization", "Bearer " + token).contentType("application/json").when().delete("http://localhost:8085/api/newsservice/news/32")
					.then().statusCode(404).log().body().extract().response();
			
			String jString=res.asString();
			Assert.assertEquals(jString.contains("Could Not delete, News not found!"),true);
					
			
			
			
					
					//given().when().delete("http://localhost:8085/api/newsservice/news/11")
					//.then().statusCode(200).log().body().extract().response();
			
			
		}
		
	
	
	@Test(priority=3)
	public void test_getMyNews() {
		
		String token ="eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxMTAiLCJpYXQiOjE2MTM4MTI1Nzh9.u9I0vQ0UorIt1y4nBlUqzWIe0USnnk5C_pZpVXBuyw4";

		ValidatableResponse res= given().header("Authorization", "Bearer " + token).contentType("application/json").when().get("http://localhost:8085/api/newsservice/news")
		.then().statusCode(200);
		
		//given().when().get("http://localhost:8085/api/newsservice/news")
		//.then().statusCode(200);
		
		
	}

	
	@Test(priority=4)
	public void test_getMyNews1() {
		
		String token ="eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxMTAiLCJpYXQiOjE2MTM4MTI1Nzh9.u9I0vQ0UorIt1y4nBlUqzWIe0USnnk5C_pZpVXBuyw4";

		ValidatableResponse res= given().header("Authorization", "Bearer " + token).contentType("application/json").when().get("http://localhost:8085/api/newsservice/news")
		.then().statusCode(404);
		
		String jString=res.toString();
		Assert.assertEquals(jString.contains("No news existed!"),true);
		
		
	
	}
	
}
