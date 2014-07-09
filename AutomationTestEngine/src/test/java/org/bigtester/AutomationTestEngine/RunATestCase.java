package org.bigtester.AutomationTestEngine;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class RunATestCase {
	private ApplicationContext context;
	
	private TestCase myTc;
	
	@Given("^a predefined test case Spring context xml file$")
	public void a_predefined_test_case_Spring_context_xml_file() throws Throwable {
		
		if (StartSuitesTest.invCount == 1)
		{
			context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
			System.out.println("pre-processing xml file" + StartSuitesTest.invCount );
		} else {
			context = new ClassPathXmlApplicationContext(
					"applicationContext2.xml");
			System.out.println("pre-processing xml2 file");
		}
 
		myTc = (TestCase) context.getBean("testcase2");
		
	}

	@When("^run the test$")
	public void run_the_test() throws Throwable {
		//TODO wiring the beans 
		myTc.goSteps();
	}

	@Then("^generate a test case report$")
	public void generate_a_test_case_report() throws Throwable {
		((ConfigurableApplicationContext)context).close();
	    System.out.println("integrate report");
	}


}
