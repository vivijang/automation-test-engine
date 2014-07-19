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

import java.lang.reflect.Method;

import org.bigtester.ate.model.casestep.TestCase;
import org.bigtester.ate.model.data.TestParameters;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

// TODO: Auto-generated Javadoc
/**
 * The Class CaseRunner defines ....
 * 
 * @author Peidong Hu
 */
public class CaseRunner implements IRunTestCase {

	/** The my tc. */
	private TestCase myTestCase;

	/** The current executing tc name. */
	protected String currentExecutingTCName; // must not be null

	/**
	 * @return the currentExecutingTCName
	 */
	public String getCurrentExecutingTCName() {
		return currentExecutingTCName;
	}

	/**
	 * @param currentExecutingTCName
	 *            the currentExecutingTCName to set
	 */
	public void setCurrentExecutingTCName(String currentExecutingTCName) {
		this.currentExecutingTCName = currentExecutingTCName;
	}

	/**
	 * @return the myTestCase
	 */
	public TestCase getMyTestCase() {
		return myTestCase;
	}

	/**
	 * @param myTestCase
	 *            the myTestCase to set
	 */
	public void setMyTestCase(final TestCase myTestCase) {
		this.myTestCase = myTestCase;
	}

	/**
	 * Gets the test data.
	 * 
	 * @param ctx
	 *            the ctx
	 * @return the test data
	 */
	@DataProvider(name = "dp")
	public Object[][] getTestData(ITestContext ctx) {
		Object[][] data = new Object[][] { { new TestParameters(ctx
				.getCurrentXmlTest().getName(), ctx.getCurrentXmlTest()
				.getName()) } };
		return data;
	}

	/**
	 * Test data.
	 * 
	 * @param method
	 *            the method
	 * @param testData
	 *            the test data
	 */
	@BeforeMethod(alwaysRun = true)
	public void testData(Method method, Object[] testData) {
		String testCase;
		if (testData != null && testData.length > 0) {
			TestParameters testParams;
			// Check if test method has actually received required parameters
			for (Object testParameter : testData) {
				if (testParameter instanceof TestParameters) {
					testParams = (TestParameters) testParameter;
					testCase = testParams.getTestName();
					this.currentExecutingTCName = String.format("%s", testCase);
					break;
				}
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getTestName() {

		return this.currentExecutingTCName;
	}

	/**
	 * Test runner1.
	 * 
	 * @param ctx
	 *            the ctx
	 */
	@Test(dataProvider = "dp")
	public void runTest(TestParameters testParams) {
		String testname = testParams.getTestFilename();
		// String testname = "applicationContext1.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(
				testname);
		System.out.println("processing fileabc: " + testname); 
		Assert.assertTrue(true);
		myTestCase = (TestCase) context.getBean("testcase2");
		myTestCase.goSteps();
		((ConfigurableApplicationContext) context).close();

	}

}
