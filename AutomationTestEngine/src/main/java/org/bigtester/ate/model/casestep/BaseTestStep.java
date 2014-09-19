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


import org.bigtester.ate.model.asserter.IExpectedResultAsserter;
import org.bigtester.ate.model.page.page.IPageObject;
import org.bigtester.ate.model.page.page.MyWebElement;

// TODO: Auto-generated Javadoc
/**
 * This class AbstractTestStep defines ....
 * 
 * @author Peidong Hu
 * 
 */
public class BaseTestStep {//NOPMD
	/** The page object. */
	private IPageObject pageObject;

	/** The forced page validation. */
	private boolean forcedPageValidation;

	/** The target step. */
	private boolean targetStep;

	/** The step name. */
	private String stepName = "";

	/** The step description. */
	private String stepDescription = "";
	
	/** The element step flag. */
	
	private transient boolean elementStepFlag;
	
	/** The my web element. */
	private MyWebElement myWebElement;
	
	/** The i expected result asserter. */
	private IExpectedResultAsserter expectedResultAsserter;
	
		
	/**
	 * Gets the step name.
	 * 
	 * @return the stepName
	 */
	public String getStepName() {
		return stepName;
	}

	/**
	 * Sets the step name.
	 * 
	 * @param stepName
	 *            the stepName to set
	 */
	public void setStepName(String stepName) {
		this.stepName = stepName;
	}

	/**
	 * Gets the step description.
	 * 
	 * @return the stepDescription
	 */
	public String getStepDescription() {
		return stepDescription;
	}

	/**
	 * Sets the step description.
	 * 
	 * @param stepDescription
	 *            the stepDescription to set
	 */
	public void setStepDescription(String stepDescription) {
		this.stepDescription = stepDescription;
	}

	/**
	 * Gets the my web element.
	 * 
	 * @return the myWebElement
	 */
	public final MyWebElement getMyWebElement() {
		return myWebElement;
	}

	/**
	 * Sets the my web element.
	 * 
	 * @param myWebElement
	 *            the myWebElement to set
	 */
	public final void setMyWebElement(final MyWebElement myWebElement) {
		this.elementStepFlag = true;
		this.myWebElement = myWebElement;
	}

	/**
	 * Checks if is target step.
	 * 
	 * @return the targetStep
	 */
	public boolean isTargetStep() {
		return targetStep;
	}

	/**
	 * Sets the target step.
	 * 
	 * @param targetStep
	 *            the targetStep to set
	 */
	public void setTargetStep(boolean targetStep) {
		this.targetStep = targetStep;
	}

	/**
	 * Gets the page object.
	 * 
	 * @return the pageObject
	 */
	public IPageObject getPageObject() {
		return pageObject;
	}

	/**
	 * Sets the page object.
	 * 
	 * @param pageObject
	 *            the pageObject to set
	 */
	public void setPageObject(IPageObject pageObject) {
		this.pageObject = pageObject;
	}

	
	/**
	 * Checks if is forced page validation.
	 *
	 * @return the forcedPageValidation
	 */
	public boolean isForcedPageValidation() {
		return forcedPageValidation;
	}

	/**
	 * Sets the forced page validation.
	 *
	 * @param forcedPageValidation the forcedPageValidation to set
	 */
	public void setForcedPageValidation(boolean forcedPageValidation) {
		this.forcedPageValidation = forcedPageValidation;
	}
	
	/**
	 * Checks if is page validation.
	 *
	 * @return true, if is page validation
	 */
	public boolean isPageValidation() {
		
		return forcedPageValidation ? true : targetStep;
	
	}

	/**
	 * @return the elementStepFlag
	 */
	public boolean isElementStepFlag() {
		return elementStepFlag;
	}

	/**
	 * @return the iExpectedResultAsserter
	 */
	public IExpectedResultAsserter getExpectedResultAsserter() {
		return expectedResultAsserter;
	}

	/**
	 * @param iExpectedResultAsserter the iExpectedResultAsserter to set
	 */
	public void setExpectedResultAsserter(IExpectedResultAsserter iExpectedResultAsserter) {
		this.expectedResultAsserter = iExpectedResultAsserter;
	}

}
