package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(

	features="/src/test/resources/features",
	glue= {"stepDefinitions","hooks","transformers"},
	tags= "@SanityTest",
	monochrome = true,
	dryRun=false, // when it's set to true, it checks the mapping between feature file and step definition file without running the browser
	plugin= {"pretty",
					"junit:target/junitReports/report.xml",
					"json:target/JSONReports/report.json",
					"html:target/HtmlReport.html",
			}

)

public class TestRunner extends AbstractTestNGCucumberTests{

}