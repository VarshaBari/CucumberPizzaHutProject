package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
	@CucumberOptions(
	    features = "src/test/java/features/PizzaHut_PlaceTheOrder.feature", // Path to your feature file
	    glue = {"stepDefs"}, // Path to your step definition package
	    plugin = {"pretty", "html:target/cucumber-reports.html"}, // Plugins for reporting
	    monochrome = true, // Makes the console output more readable
	    tags= {"@placeOrder"}
	    		// tags = {"not @Ignore"} - to ignore a particular tag
	    		// tags = {"@Calculator"} - to run the entire feature use feature level tag
	    		// tags = {"@Simplilearn and not @Ignore"} - will run entire feature file except ignored one
	    		// tags = {"@Regression"} - Scenario can have multiple tags
	    		// @U_1000 and @Regression - this will run scenarios where both the tags are present 
	    		// @Calculator or @Simplilearn - this will run  both calculator or Simplilearn
	)
	
	public class TestRunner {
}
