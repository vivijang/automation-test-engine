// Test case for open 4 times 
package org.bigtester.AutomationTestEngine;

import org.bigtester.AutomationTestEngine.ProjectModel.TestProject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestProjectRunner {
  
	public static void main(String[] args) {
	  	ApplicationContext context = new ClassPathXmlApplicationContext(
				"testproject.xml");
		
		TestProject tp = (TestProject) context.getBean("testproject");
		tp.runSuites();
		((ConfigurableApplicationContext)context).close();
  }
  

}
