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
package org.bigtester.ate.model.casestep;

import java.util.List;

import org.bigtester.ate.model.page.atewebdriver.IMyWebDriver;
import org.bigtester.ate.model.page.exception.PageValidationException2;
import org.bigtester.ate.model.page.exception.StepExecutionException2;
import org.bigtester.ate.model.utils.ThinkTime;


// TODO: Auto-generated Javadoc
/**
 * The Class TestCase defines ....
 * 
 * @author Peidong Hu
 */
public class TestCase {
	
	/** The current web driver. */
	private IMyWebDriver currentWebDriver;
	/** The test case name. */
	private String testCaseName;
	
	/** The step think time. */
	private int stepThinkTime = 0;
	
	/**
	 * @return the stepThinkTime
	 */
	public int getStepThinkTime() {
		return stepThinkTime;
	}

	/**
	 * @param stepThinkTime the stepThinkTime to set
	 */
	public void setStepThinkTime(int stepThinkTime) {
		this.stepThinkTime = stepThinkTime;
	}

	/** The current test step. */
	private ITestStep currentTestStep;
	/** The test step list. */
	private List<ITestStep> testStepList;

	/**
	 * Gets the test step list.
	 * 
	 * @return the testStepList
	 */
	public List<ITestStep> getTestStepList() {
		return testStepList;
	}

	/**
	 * Sets the test step list.
	 * 
	 * @param testStepList
	 *            the testStepList to set
	 */
	public final void setTestStepList(final List<ITestStep> testStepList) {
		this.testStepList = testStepList;
	}

	/**
	 * run steps.
	 * @throws StepExecutionException 
	 * @throws PageValidationException 
	 */
	public void goSteps() throws StepExecutionException2, PageValidationException2 {
		
		for (int i=0; i<testStepList.size(); i++) {
			
			currentTestStep = testStepList.get(i);
			currentWebDriver = currentTestStep.getMyWebDriver();
			
			currentTestStep.doStep();//NOPMD
			
			if (stepThinkTime > 0) {
				ThinkTime thinkTimer = new ThinkTime (stepThinkTime);
				thinkTimer.setTimer();
			}
			
		}
	}

	/**
	 * Gets the test case name.
	 *
	 * @return the testCaseName
	 */
	public String getTestCaseName() {
		return testCaseName;
	}

	/**
	 * Sets the test case name.
	 *
	 * @param testCaseName the testCaseName to set
	 */
	public void setTestCaseName(String testCaseName) {
		this.testCaseName = testCaseName;
	}

	/**
	 * Gets the current test step.
	 *
	 * @return the currentTestStep
	 */
	public ITestStep getCurrentTestStep() {
		return currentTestStep;
	}

	/**
	 * Sets the current test step.
	 *
	 * @param currentTestStep the currentTestStep to set
	 */
	public void setCurrentTestStep(ITestStep currentTestStep) {
		this.currentTestStep = currentTestStep;
	}

	/**
	 * Gets the current web driver.
	 *
	 * @return the currentWebDriver
	 */
	public IMyWebDriver getCurrentWebDriver() {
		return currentWebDriver;
	}

	/**
	 * Sets the current web driver.
	 *
	 * @param currentWebDriver the currentWebDriver to set
	 */
	public void setCurrentWebDriver(IMyWebDriver currentWebDriver) {
		this.currentWebDriver = currentWebDriver;
	}

}
