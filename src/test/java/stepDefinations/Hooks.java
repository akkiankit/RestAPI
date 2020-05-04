package stepDefinations;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	
	
	@Before("@Delete")
	public void beforeScenario() throws IOException {
		
		//write a code the will give the place id
		//execute this code only when place id is null
		
		stepDefination step= new stepDefination();
		
		if(stepDefination.placeid ==null) {
			step.add_Place_Payload_with("ankit", "French", "Asia");
			step.user_calls_with_post_http_request("AddPlaceAPI", "POST");
			step.verify_place_Id_created_maps_to_using("place_id", "ankit", "getPlaceAPI");
		}
	}
	

}
