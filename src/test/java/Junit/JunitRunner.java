package Junit;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features",glue={ "StepDefinition" }, dryRun=false,monochrome = true, plugin = {"pretty",
		"com.cucumber.listener.ExtentCucumberFormatter:output/report.html" })



public class JunitRunner {
	@AfterClass
	public static void teardown()  {
		
	
		Reporter.loadXMLConfig(new File("./extend-config.xml"));
		Reporter.setSystemInfo("user", System.getProperty("user.name"));
		Reporter.setSystemInfo("os", "Windows os");
		Reporter.setTestRunnerOutput("S2B Project");
		Reporter.addStepLog("<a href='www.google.com'>Maveric/a>");
	}
}
		