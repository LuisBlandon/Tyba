package runner;



import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

// @RunWith(CukeSpace.class)
@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "json:target/cucumber.json" }, features = {
		"src/test/resources/features/" }, glue = { "classpath:" }, tags = { "@Service" })
public class RunTest {

}