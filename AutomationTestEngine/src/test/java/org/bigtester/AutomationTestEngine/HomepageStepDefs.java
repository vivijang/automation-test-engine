package org.bigtester.AutomationTestEngine;

import org.bigtester.AutomationTestEngine.Services.MyStepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@ContextConfiguration("classpath:applicationContext.xml")
public class HomepageStepDefs {
	
	@Autowired
	private MyStepService myservice;
	
	@Given("^a homepage I just navigate to$")
	public void a_homepage_I_just_navigate_to() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		String msg = myservice.getMsg();
		System.out.println(msg);
	}

	@When("^I open About menu$")
	public void i_open_About_menu() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("pass2");
	}

	@Then("^About sub-menu appears$")
	public void about_sub_menu_appears() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Assert.assertTrue(true);
	}

}
