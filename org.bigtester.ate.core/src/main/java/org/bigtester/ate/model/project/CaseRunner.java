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

import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.bigtester.ate.GlobalUtils;
import org.bigtester.ate.constant.LogbackTag;
import org.bigtester.ate.model.casestep.TestCase;
import org.bigtester.ate.model.data.TestParameters;
import org.bigtester.ate.model.data.exception.TestDataException;
import org.bigtester.ate.model.page.atewebdriver.IMyWebDriver;
import org.bigtester.ate.systemlogger.LogbackWriter;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.springframework.beans.FatalBeanException;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestRunner;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.internal.Utils;

// TODO: Auto-generated Javadoc
/**
 * The Class CaseRunner runs a single test case
 * 
 * @author Peidong Hu
 */
public class CaseRunner implements IRunTestCase {

	/** The context. */
	private ApplicationContext context;

	/** The my tc. */
	private TestCase myTestCase;

	/** The current executing tc name. */
	protected String currentExecutingTCName; // must not be null

	
	/** The page object data files. */
	private List<Resource> pageObjectDataFiles = new ArrayList<Resource>();

	/**
	 * @return the pageObjectDataFiles
	 */
	public List<Resource> getPageObjectDataFiles() {
		return pageObjectDataFiles;
	}

	/**
	 * @param pageObjectDataFiles
	 *            the pageObjectDataFiles to set
	 */
	public void setPageObjectDataFiles(List<Resource> pageObjectDataFiles) {
		this.pageObjectDataFiles = pageObjectDataFiles;
	}

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
		TestParameters params = new TestParameters(ctx.getCurrentXmlTest()
				.getName(), ctx.getCurrentXmlTest().getName());
		for (int index = 0; index < ((TestRunner) ctx).getTestListeners()
				.size(); index++) {
			if (((TestRunner) ctx).getTestListeners().get(index) instanceof TestProjectListener) {
				int thinkT = ((TestProjectListener) ((TestRunner) ctx)
						.getTestListeners().get(index)).getMytp()
						.getStepThinkTime();
				params.setStepThinkTime(thinkT);
				params.setGlobalAppCtx(((TestProjectListener) ((TestRunner) ctx)
						.getTestListeners().get(index)).getMytp().getAppCtx());
				break;
			}
		}

		return new Object[][] { { params } };

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
	public void testData(Method method, Object[] testData) { // NOPMD
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
	 * @throws Throwable
	 */
	@Test(dataProvider = "dp")
	public void runTest(TestParameters testParams) throws Throwable {
		String testname = testParams.getTestFilename();

		// ApplicationContext context;
		try {
			context = new FileSystemXmlApplicationContext(testname);
			myTestCase = GlobalUtils.findTestCaseBean(context);
			myTestCase.setStepThinkTime(testParams.getStepThinkTime());
			myTestCase.goSteps();

		} catch (FatalBeanException fbe) {
			if (fbe.getCause() instanceof FileNotFoundException) {
				context = new ClassPathXmlApplicationContext(testname);
				myTestCase = GlobalUtils.findTestCaseBean(context);
				myTestCase.setStepThinkTime(testParams.getStepThinkTime());
				myTestCase.goSteps();

			} else if (fbe instanceof BeanCreationException) { // NOPMD
				ITestResult itr = Reporter.getCurrentTestResult();

				if (itr.getThrowable() != null
						&& itr.getThrowable() instanceof TestDataException) {
					TestDataException tde = (TestDataException) itr
							.getThrowable();
					tde.setTestStepName(((BeanCreationException) fbe.getCause())
							.getBeanName());
					tde.setTestCaseName(((BeanCreationException) fbe)
							.getResourceDescription());
					tde.setMessage(tde.getMessage() + LogbackTag.TAG_SEPERATOR
							+ tde.getTestCaseName() + LogbackTag.TAG_SEPERATOR
							+ tde.getTestStepName());
					throw (TestDataException) itr.getThrowable();
				} else { // other test case bean creation errors. need to create
					// another exception to handle it.
					String[] fullST = Utils.stackTrace(fbe, false);
					LogbackWriter.writeSysError(fullST[1]);
					throw fbe;
				}
			} else {
				throw fbe;
			}
		}
	}

	/**
	 * Tear down.
	 */
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		try {
			Map<String, IMyWebDriver> myWebDrivers = context
					.getBeansOfType(IMyWebDriver.class);
			for (IMyWebDriver myWebDriver2 : myWebDrivers.values()) {
				myWebDriver2.getWebDriver().close();
			}
		} catch (UnreachableBrowserException e) {//NOPMD
			//browser has been closed, no action needs to be done here.
		}

		((ConfigurableApplicationContext) context).close();
	}

	/**
	 * @return the context
	 */
	public ApplicationContext getContext() {
		return context;
	}

	/**
	 * @param context
	 *            the context to set
	 */
	public void setContext(ApplicationContext context) {
		this.context = context;
	}

}
