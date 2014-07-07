package org.bigtester.AutomationTestEngine;

import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.*;
@CucumberOptions(features="src/test/resources/org/bigtester/AutomationTestEngine", format={"pretty", "html:target/cucumber"})
public class StartSuitesTest {
   @Test	
   public void f() {
	   new TestNGCucumberRunner(getClass()).runCukes();
	  
  }
   
}
