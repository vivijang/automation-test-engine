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
package org.bigtester.ate.model.asserter;

import java.util.ArrayList;
import java.util.List;

import org.bigtester.ate.model.data.StepExecutionResult;
import org.bigtester.ate.model.data.StepExpectedResultValue;
import org.bigtester.ate.model.page.page.IPageObject;
import org.eclipse.jdt.annotation.Nullable;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

// TODO: Auto-generated Javadoc
/**
 * This class AbstractExpectedResultAsserter defines ....
 * 
 * @author Peidong Hu
 *
 */
public abstract class AbstractExpectedResultAsserter implements
		ApplicationContextAware { // NOPMD
	/** The result page. */
	@Nullable
	private IPageObject resultPage;

	/** The interesting erdb indexes. */
	protected final transient List<Long> interestingERDBIndexes = new ArrayList<Long>(); // NOPMD

	/** The step er value. */
	@Nullable
	private StepExpectedResultValue stepERValue;

	/** The exec result. */
	protected final transient StepExecutionResult execResult = new StepExecutionResult();

	/** The application context. */
	@Nullable
	private ApplicationContext applicationContext;

	/** The Constant EXIST. */
	public final static String CORRECT = "Correct";

	/** The Constant NOTEXIST. */
	public final static String NOTCORRECT = "NotCorrect";

	/** The Constant EXIST. */
	public final static String EXIST = "Exist";

	/** The Constant NOTEXIST. */
	public final static String NOTEXIST = "NotExist";

	/** The assert report msg. */
	protected transient String assertReportMSG = "";

	/**
	 * @return the assertReportMSG
	 */
	public String getAssertReportMSG() {
		return assertReportMSG;
	}

	/**
	 * @return the interestingERDBIndexes
	 */
	public List<Long> getInterestingERDBIndexes() {
		return interestingERDBIndexes;
	}

	/**
	 * Gets the result page.
	 *
	 * @return the resultPage
	 */

	public IPageObject getResultPage() throws IllegalStateException{
		final IPageObject resultPage2 = resultPage;
		if (null == resultPage2) {
			throw new IllegalStateException ("Page Object is not correct initialized in asserter");
			
		} else {
			return resultPage2;
		}

	}

	/**
	 * Sets the result page.
	 *
	 * @param resultPage
	 *            the resultPage to set
	 */
	public void setResultPage(final IPageObject resultPage) {
		this.resultPage = resultPage;
	}

	/**
	 * @return the stepERValue
	 */

	public StepExpectedResultValue getStepERValue() throws IllegalStateException{
		final StepExpectedResultValue stepERValue2 = stepERValue;
		if ( null == stepERValue2 ) {
			throw new IllegalStateException("StepERValue is not correctly initialized in asserter");
		} else {

			return stepERValue2;
		}
	}

	/**
	 * @param stepERValue
	 *            the stepERValue to set
	 */
	public void setStepERValue(StepExpectedResultValue stepERValue) {
		this.stepERValue = stepERValue;
	}

	/**
	 * @return the execResult
	 */
	public StepExecutionResult getExecResult() {
		return execResult;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setApplicationContext(
			@Nullable ApplicationContext applicationContext)
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
			throw new IllegalStateException("Couldn't get test case application context in asserter.");
		} else {
			return applicationContext2;
		}
	}
}
