package org.bigtester.AutomationTestEngine;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.*;

@CucumberOptions(features = "src/test/resources/org/bigtester/AutomationTestEngine", format = {
		"pretty", "html:target/cucumber" })

public class StartSuitesTest {
	public static int  invCount;
	
	@BeforeClass
	public void initCount() {
		StartSuitesTest.invCount = 0;
		
	}

	@Test(invocationCount = 1)
	public void f() {
		StartSuitesTest.invCount++;
		new TestNGCucumberRunner(getClass()).runCukes();

	}

}
