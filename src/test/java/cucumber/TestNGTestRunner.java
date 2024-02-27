package cucumber;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/cucumber",
glue="mayuriraoraneacademy.stepDefinations",
plugin = { "pretty", "html:target/cucumber.html"},
monochrome = true)

public class TestNGTestRunner extends AbstractTestNGCucumberTests {
	
	
	
	
	
	
	
	

}
