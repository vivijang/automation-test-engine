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


import java.util.ArrayList;
import java.util.List;

import org.bigtester.ate.constant.StepResultStatus;
import org.bigtester.ate.model.asserter.IExpectedResultAsserter;

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
public abstract class AbstractTestStep implements ApplicationContextAware {//NOPMD
	

	/** The target step. */
	private boolean targetStep;

	/** The optional step. default is false*/
	private boolean optionalStep;
	
	/** The passed. */
	private StepResultStatus stepResultStatus = StepResultStatus.FAIL;

	/** The step name. */
	private String stepName = "";

	/** The step description. */
	@Nullable
	private String stepDescription = "";
	
	
	
	/** The i expected result asserter. */
	private List<IExpectedResultAsserter> expectedResultAsserter = new ArrayList<IExpectedResultAsserter>();
	
	
	/** The application context. */
	@Nullable
	private ApplicationContext applicationContext;

	
	
	/**
	 * @return the optionalStep
	 */
	public boolean isOptionalStep() {
		return optionalStep;
	}
	/**
	 * @param optionalStep the optionalStep to set
	 */
	public void setOptionalStep(boolean optionalStep) {
		this.optionalStep = optionalStep;
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
	 * @return the iExpectedResultAsserter
	 */
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
	
	
	
	/**
	 * @return the stepResultStatus
	 */
	public StepResultStatus getStepResultStatus() {
		return stepResultStatus;
	}
	/**
	 * @param stepResultStatus the stepResultStatus to set
	 */
	public void setStepResultStatus(StepResultStatus stepResultStatus) {
		this.stepResultStatus = stepResultStatus;
	}



	
}
