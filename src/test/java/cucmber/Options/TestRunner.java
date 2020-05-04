package cucmber.Options;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

//since we are running with junit class we need to pass it
@RunWith(Cucumber.class)
@CucumberOptions(
		// we will give the path of our features files
		features="src/test/java/features",
		//below is the integration part line -will generate report injson format
		plugin="json:target/jsonReports/cucumber-report.json",
		//we will give the path of our stepdefination file 
		glue ="stepDefinations"
		//tags =""
		
		)

public class TestRunner {
	
	

}
