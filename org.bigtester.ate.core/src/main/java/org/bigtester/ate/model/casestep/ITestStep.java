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

import java.util.List;

import org.bigtester.ate.constant.StepResultStatus;
import org.bigtester.ate.model.asserter.IExpectedResultAsserter;
import org.bigtester.ate.model.data.IDataParser;
import org.bigtester.ate.model.data.exception.RuntimeDataException;
import org.bigtester.ate.model.page.atewebdriver.IMyWebDriver;
import org.bigtester.ate.model.page.exception.PageValidationException2;
import org.bigtester.ate.model.page.exception.StepExecutionException2;
import org.bigtester.ate.model.page.page.IPageObject;
import org.bigtester.ate.model.page.page.MyWebElement;
import org.eclipse.jdt.annotation.Nullable;

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
	 * Checks if is optional step.
	 *
	 * @return true, if is optional step
	 */
	boolean isOptionalStep();
	
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
	@Nullable
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
	@Nullable
	MyWebElement getMyWebElement();
	/**
	 * Gets the step description.
	 * 
	 * @return the stepDescription
	 */
	@Nullable
	String getStepDescription();
	
	/**
	 * Gets the expected result asserter.
	 *
	 * @return the expected result asserter
	 */
	List<IExpectedResultAsserter> getExpectedResultAsserter();
	
	/**
	 * Gets the data holders.
	 *
	 * @return the data holders
	 */
	List<IDataParser> getDataHolders();
	/**
	 * Checks if is element step.
	 *
	 * @return true, if is element step
	 */
	boolean isElementStepFlag();
	/**
	 * Do step.
	 * @throws RuntimeDataException 
	 *
	 * @throws StepExecutionException the step execution exception
	 * @throws PageValidationException 
	 */

	void doStep () throws StepExecutionException2, PageValidationException2, RuntimeDataException;
	
	/**
	 * Sets the step result status.
	 *
	 * @param stepResultStatus the new step result status
	 */
	void setStepResultStatus(StepResultStatus stepResultStatus); 
	
	/**
	 * Gets the step result status.
	 *
	 * @return the step result status
	 */
	StepResultStatus getStepResultStatus();
	
}
