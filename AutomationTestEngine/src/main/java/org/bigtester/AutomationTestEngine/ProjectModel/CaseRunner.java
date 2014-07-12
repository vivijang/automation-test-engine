package org.bigtester.AutomationTestEngine.ProjectModel;


import org.bigtester.AutomationTestEngine.CaseModel.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.ITestContext;
import org.testng.annotations.Test;


public class CaseRunner {
	private TestCase myTc;
	@Test
	public void testRunner1(ITestContext ctx) {
		String testname = ctx.getCurrentXmlTest().getName();
		//String testname = "applicationContext1.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(testname);
		System.out.println("processing fileabc: " + testname);
		
		myTc = (TestCase) context.getBean("testcase2");
		myTc.goSteps();
		((ConfigurableApplicationContext)context).close();
		
	}
}


   