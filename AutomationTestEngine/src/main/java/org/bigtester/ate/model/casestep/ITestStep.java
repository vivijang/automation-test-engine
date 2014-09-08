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
package org.bigtester.ate.model.casestep; //NOPMD

import org.bigtester.ate.model.page.atewebdriver.IMyWebDriver;
import org.bigtester.ate.model.page.exception.StepExecutionException;
import org.bigtester.ate.model.page.page.IPageObject;
import org.bigtester.ate.model.page.page.MyWebElement;

// TODO: Auto-generated Javadoc
/**
 * The Interface ITestStep defines ....
 * 
 * @author Peidong Hu
 */
public interface ITestStep {
	
	/**
	 * Checks if is target step.
	 *
	 * @return true, if is target step
	 */
	boolean isTargetStep();
	/**
	 * Checks if is page validation.
	 *
	 * @return true, if is page validation
	 */
	boolean isPageValidation();
	/**
	 * Gets the page object.
	 *
	 * @return the page object
	 */
	IPageObject getPageObject();
	
	/**
	 * Gets the my web driver.
	 *
	 * @return the my web driver
	 */
	IMyWebDriver getMyWebDriver();
	/**
	 * Gets the step name.
	 * 
	 * @return the stepName
	 */
	String getStepName();
	
	/**
	 * Gets the my web element.
	 *
	 * @return the my web element
	 */
	MyWebElement getMyWebElement();
	/**
	 * Gets the step description.
	 * 
	 * @return the stepDescription
	 */
	String getStepDescription();
	
	
	/**
	 * Checks if is element step.
	 *
	 * @return true, if is element step
	 */
	boolean isElementStepFlag();
	/**
	 * Do step.
	 *
	 * @throws StepExecutionException the step execution exception
	 */

	void doStep () throws StepExecutionException;
}
