package stepDefinations;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import static org.junit.Assert.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;


public class stepDefination extends Utils {
	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
	static String placeid;
	
	TestDataBuild data = new TestDataBuild();	
	
		@Given("Add Place Payload")
		public void add_Place_Payload() throws IOException {
			
			 //res = given().spec(requestSpecification()).body(data.addPlacePayLoad()); 
		}
		
		@When("user calls {string} with {string} http request")
		public void user_calls_with_post_http_request(String resources, String method) {
			
			APIResources resoueceAPI= APIResources.valueOf(resources);
			System.out.println(resoueceAPI.getResource());
			
			resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
			
			if(method.equalsIgnoreCase("POST")) {
				response = res.when().post(resoueceAPI.getResource());
			}else if(method.equalsIgnoreCase("GET"))
				response = res.when().get(resoueceAPI.getResource());
			//then().spec(resspec).extract().response();
		}
		
		@Then("the API call is success with status code {int}")
		public void the_API_call_is_success_with_status_code(Integer int1) {
		   
		   assertEquals(response.getStatusCode(),200);
		}	
		
		@Then("{string} in response body is {string}")
		public void in_response_body_is(String key, String value) {
		    assertEquals(getJsonPath(response, key), value);
		    
		}
		
		@Given("Add Place Payload with {string} {string} {string}")
		public void add_Place_Payload_with(String name, String language, String address) throws IOException {
			
			 res = given().spec(requestSpecification()).body(data.addPlacePayLoad(name,language,address)); 
		   
		}
		
		@Then("verify {string} created maps to {string} using {string}")
		public void verify_place_Id_created_maps_to_using(String key, String ExpectedName, String resources) throws IOException {
		   
			//request spec is needed for get place
			placeid = getJsonPath(response,key);
			 res = given().spec(requestSpecification()).queryParam("place_id",placeid);
			 user_calls_with_post_http_request(resources,"GET");
			 String actualName= getJsonPath(response, "name");
			 assertEquals(actualName, ExpectedName);
			
		}
		
		@Given("DeletePlace Payload")
		public void deleteplace_Payload() throws IOException {
		   
			res = given().spec(requestSpecification()).body(data.deletePlacePayload(placeid));
		}




}
