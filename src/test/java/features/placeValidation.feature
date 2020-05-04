Feature: Validating Place API's
@addPlace @Reg
Scenario Outline: Verify if place is being Succesfully added using AddPlaceAPI
	Given Add Place Payload with "<name>" "<language>" "<address>"
	When user calls "AddPlaceAPI" with "POST" http request
	Then the API call is success with status code 200
	And "status" in response body is "OK"
	And "scope" in response body is "APP"
	And verify "place_id" created maps to "<name>" using "getPlaceAPI"
	
Examples:
	|name | language | address|
	|A house| English| world cross centre|
#	|B House| Spanish| dream Home|

@Delete @Reg
Scenario: Verify if Delete Place fuctionality is working
	Given DeletePlace Payload
	When user calls "deletePlaceAPI" with "POST" http request
	Then the API call is success with status code 200
	And "status" in response body is "OK"
	
	