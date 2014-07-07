package org.bigtester.AutomationTestEngine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@ContextConfiguration("classpath:applicationContext.xml")
public class RunATestCase {
	@Autowired
	private TestCase myTc;
	@Given("^a predefined test case Spring context xml file$")
	public void a_predefined_test_case_Spring_context_xml_file() throws Throwable {
	    System.out.println("pre-processing xml file");
	}

	@When("^run the test$")
	public void run_the_test() throws Throwable {
		//TODO wiring the beans 
		myTc.goSteps();
	}

	@Then("^generate a test case report$")
	public void generate_a_test_case_report() throws Throwable {
	    System.out.println("integrate report");
	}


}
