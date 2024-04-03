package Runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
@RunWith(Cucumber.class)
@CucumberOptions(features = "Feature" ,
glue = "stepdefinitions",
plugin={"pretty","junit:target/cucumberReports.xml"}
		)

public class Runnerclass extends AbstractTestNGCucumberTests{

}
