/*******************************************************************************
 * ATE, Automation Test Engine
 *
 * Copyright 2014, Montreal PROT, or individual contributors as
 * indicated by the @author tags or express copyright attribution
 * statements applied by the authors.  All third-party contributions are
 * distributed under license by Montreal PROT.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package org.bigtester.ate.model.project;


import org.bigtester.ate.model.casestep.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;


// TODO: Auto-generated Javadoc
/**
 * The Class CaseRunner defines ....
 * 
 * @author Peidong Hu
 */
public class CaseRunner {
	
	/** The my tc. */
	private TestCase myTestCase;
	
	/**
	 * @return the myTestCase
	 */
	public TestCase getMyTestCase() {
		return myTestCase;
	}

	/**
	 * @param myTestCase the myTestCase to set
	 */
	public void setMyTestCase(final TestCase myTestCase) {
		this.myTestCase = myTestCase;
	}

	/**
	 * Test runner1.
	 * 
	 * @param ctx
	 *            the ctx
	 */
	@Test
	public void testRunner1(final ITestContext ctx) {
		final String testname = ctx.getCurrentXmlTest().getName();
		//String testname = "applicationContext1.xml";
		final ApplicationContext context = new ClassPathXmlApplicationContext(testname);
		System.out.println("processing fileabc: " + testname);
		Assert.assertTrue(true);
		myTestCase = (TestCase) context.getBean("testcase2");
		myTestCase.goSteps();
		((ConfigurableApplicationContext)context).close();
		
	}
}


   