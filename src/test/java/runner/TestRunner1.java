package runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/userlogin.feature", 
        glue = "stepDefinitions",
        		plugin = {
        		        "pretty",
        		        "html:target/cucumber-reports/cucumber.html", 
        		        "json:target/cucumber-reports/cucumber.json" 
        		    }
)
public class TestRunner1 extends AbstractTestNGCucumberTests{
	 
}