package test_case_package;

import static io.restassured.RestAssured.given;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import request_repository_package.post_request_repository;

public class post_tc {

public static void executer1() {
		
		//Define the base URI
		RestAssured.baseURI="https://reqres.in";
		
		//Step:3 Triggering the API and extracting the status code and validation
		int Status_code=given().header("Content-Type", "application/json").body(post_request_repository.post_req_tc1()).
						when().post("/api/users").then().extract().statusCode();
		System.out.println(Status_code);
		Assert.assertEquals(Status_code, 201);
		
		//Extracting the response body
		String responseBody=given().header("Content-Type", "application/json").body(post_request_repository.post_req_tc1()).
							when().post("/api/users").then().extract().response().asString();
		//System.out.println(responseBody);
		
		//Step:4 Parsing and extracting the request body params
		JsonPath jsp_request=new JsonPath(post_request_repository.post_req_tc1());
		String req_name=jsp_request.getString("name");
		System.out.println(req_name);
		String req_job=jsp_request.getString("job");
		//System.out.println(req_job);
		
		//Step:5 Parsing and extracting the response body params
		JsonPath jsp_response=new JsonPath(responseBody);
		String res_name=jsp_response.getString("name");
		System.out.println(res_name);
		String res_job=jsp_response.getString("job");
		System.out.println(res_job);
		String res_id=jsp_response.getString("id");
		System.out.println(res_id);
		String res_createdAt=jsp_response.getString("createdAt");
		System.out.println(res_createdAt);
		String res_createdAt_substring=res_createdAt.substring(0, 10);
		System.out.println(res_createdAt_substring);
		
		//Extracting the current date
		Date current_date=new Date();
		
		//Formatting the date
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sdf);
		
		//Converting the date to string
		String cur_date=sdf.format(current_date);
		System.out.println(cur_date);
		
		//Step:6 Validating the response body params
		Assert.assertEquals(res_name, req_name);
		Assert.assertEquals(res_job, req_job);
		Assert.assertEquals(res_createdAt_substring, cur_date);
		Assert.assertNotNull(res_id);
	}
	
}
