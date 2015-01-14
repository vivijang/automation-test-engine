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

import org.bigtester.ate.model.asserter.IExpectedResultAsserter;
import org.bigtester.ate.model.page.page.IPageObject;
import org.bigtester.ate.model.page.page.MyWebElement;
import org.eclipse.jdt.annotation.Nullable;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

// TODO: Auto-generated Javadoc
/**
 * This class AbstractTestStep defines ....
 * 
 * @author Peidong Hu
 * 
 */
public class BaseTestStep implements ApplicationContextAware {//NOPMD
	/** The page object. */
	@Nullable
	private IPageObject pageObject;

	/** The forced page validation. */
	private boolean forcedPageValidation;

	/** The target step. */
	private boolean targetStep;

	/** The step name. */
	private String stepName = "";

	/** The step description. */
	@Nullable
	private String stepDescription = "";
	
	/** The element step flag. */
	
	private transient boolean elementStepFlag;
	
	/** The my web element. */
	@Nullable
	protected MyWebElement myWebElement;
	
	/** The i expected result asserter. */
	@Nullable
	private List<IExpectedResultAsserter> expectedResultAsserter;
	
	/** The application context. */
	@Nullable
	private ApplicationContext applicationContext;

	/**
	 * Instantiates a new base test step.
	 *
	 * @param pageObject the page object
	 * @param myWebElement the my web element
	 */
	public BaseTestStep( IPageObject pageObject, @Nullable MyWebElement myWebElement) {
		this.pageObject = pageObject;
		this.myWebElement = myWebElement;
	}
	/**
	 * Instantiates a new base test step.
	 *
	 * @param pageObject the page object
	 * @param myWebElement the my web element
	 */
	public BaseTestStep( MyWebElement myWebElement) {
		this.myWebElement = myWebElement;
	}
	
	/**
	 * Instantiates a new base test step.
	 *
	 * @param pageObject the page object
	 * @param myWebElement the my web element
	 */
	public BaseTestStep( IPageObject pageObject ) {
		this.pageObject = pageObject;
	}
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
	public void setStepName(final String stepName) {
		this.stepName = stepName;
	}

	/**
	 * Gets the step description.
	 * 
	 * @return the stepDescription
	 */
	@Nullable
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
	@Nullable
	public MyWebElement getMyWebElement() {
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
	@Nullable
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
	@Nullable
	public List<IExpectedResultAsserter> getExpectedResultAsserter() {
		return expectedResultAsserter;
	}

	/**
	 * @param iExpectedResultAsserter the iExpectedResultAsserter to set
	 */
	public void setExpectedResultAsserter(List<IExpectedResultAsserter> iExpectedResultAsserter) {
		this.expectedResultAsserter = iExpectedResultAsserter;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setApplicationContext(@Nullable ApplicationContext applicationContext)
			throws BeansException {
		if (null == applicationContext) {
			throw new NoSuchBeanDefinitionException(ApplicationContext.class);
		} else {
			this.applicationContext = applicationContext;
		}
		
	}
	
	/**
	 * Gets the application context.
	 *
	 * @return the application context
	 */
	public ApplicationContext getApplicationContext() throws IllegalStateException{
		
		final ApplicationContext applicationContext2 = applicationContext;
		if (null == applicationContext2) {
			throw new IllegalStateException("applicationContext is not correctly initialized in test step");
		} else {
			return applicationContext2;
		}
	}
}
