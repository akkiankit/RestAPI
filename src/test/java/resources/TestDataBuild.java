package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.location;

public class TestDataBuild {
	
	public  AddPlace addPlacePayLoad(String name, String language, String Address) {
		
		AddPlace loc = new AddPlace();
		loc.setAccuracy(50);
		loc.setAddress(Address);
		loc.setLanguage(language);
		loc.setPhone_number("(+91) 983 893 3937");
		loc.setName(name);
		loc.setWebsite("http://google.com");
		
		List <String> mylist = new ArrayList<String>();
		mylist.add("shoe park");
		mylist.add("shop");
		loc.setTypes(mylist);
		
		//Below steps is for setting location
		location lc = new location();
		lc.setLat(-38.383494);
		lc.setLng(33.427362);
		
		loc.setLocation(lc);
		
		return  loc;
	}
	
	public String deletePlacePayload(String placeid) {
		
		return "{\r\n    \"place_id\":\""+placeid+"\"\r\n}";
		
	}
	

}
