/*******************************************************************************
 * ATE, Automation Test Engine
 *
 * Copyright 2015, Montreal PROT, or individual contributors as
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

import org.bigtester.ate.model.asserter.IExpectedResultAsserter;
import org.bigtester.ate.model.data.IDataParser;
import org.bigtester.ate.model.data.IStepInputData;
import org.bigtester.ate.model.data.exception.RuntimeDataException;
import org.bigtester.ate.model.page.atewebdriver.IMyWebDriver;
import org.bigtester.ate.model.page.exception.PageValidationException2;
import org.bigtester.ate.model.page.exception.StepExecutionException2;
import org.bigtester.ate.model.page.page.IPageObject;
import org.bigtester.ate.model.page.page.MyWebElement;
import org.eclipse.jdt.annotation.Nullable;

// TODO: Auto-generated Javadoc
/**
 * This class RepeatStep defines ....
 * @author Peidong Hu
 *
 */
public class RepeatStep extends AbstractTestStep implements ITestStep{

	/** The test case. */
	final private TestCase testCase;
	/** The start step id. */
	private String startStepID;
	
	/** The end step id. */
	private String endStepID;

	/** The continue on failure. */
	private boolean continueOnFailure;
	
	/** The repeat times. */
	private int repeatTimes;
	
	/** The step i ds. */
	final private List<Integer> stepIDs = new ArrayList<Integer>();
		
//	/** The input data holders. */
//	final private List<IStepInputData> inputDataHolders;
//	
//	/** The data parsers. */
//	final private List<IDataParser> dataParsers;
//	
//	final private List<IExpectedResultAsserter> expectedResultAsserters;
	
	public RepeatStep(String startStepID, String endStepID, TestCase testCase) {
		this.startStepID = startStepID;
		this.endStepID = endStepID;
		this.continueOnFailure = false;
		this.repeatTimes = 1;
		this.testCase = testCase;
		int startIndex = 0;
		int endIndex = testCase.getTestStepList().size();
		for (int i=0; i<testCase.getTestStepList().size(); i++) {
			if (testCase.getTestStepList().get(i).getStepName() == this.startStepID) {
				startIndex = i;
			}
			if (testCase.getTestStepList().get(i).getStepName() == this.endStepID) {
				endIndex = i;
			}
			if (i >= startIndex && i<=endIndex) {
				stepIDs.add(i);
			}
		}
		
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isPageValidation() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Nullable
	public IPageObject getPageObject() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Nullable
	public IMyWebDriver getMyWebDriver() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Nullable
	public MyWebElement getMyWebElement() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Nullable
	public List<IDataParser> getDataHolders() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isElementStepFlag() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doStep() throws StepExecutionException2,
			PageValidationException2, RuntimeDataException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @return the startStepID
	 */
	public String getStartStepID() {
		return startStepID;
	}

	/**
	 * @param startStepID the startStepID to set
	 */
	public void setStartStepID(String startStepID) {
		this.startStepID = startStepID;
	}

	/**
	 * @return the endStepID
	 */
	public String getEndStepID() {
		return endStepID;
	}

	/**
	 * @param endStepID the endStepID to set
	 */
	public void setEndStepID(String endStepID) {
		this.endStepID = endStepID;
	}

	/**
	 * @return the continueOnFailure
	 */
	public boolean isContinueOnFailure() {
		return continueOnFailure;
	}

	/**
	 * @param continueOnFailure the continueOnFailure to set
	 */
	public void setContinueOnFailure(boolean continueOnFailure) {
		this.continueOnFailure = continueOnFailure;
	}

	/**
	 * @return the repeatTimes
	 */
	public int getRepeatTimes() {
		return repeatTimes;
	}

	/**
	 * @param repeatTimes the repeatTimes to set
	 */
	public void setRepeatTimes(int repeatTimes) {
		this.repeatTimes = repeatTimes;
	}

//	/**
//	 * @return the inputDataHolders
//	 */
//	public List<IStepInputData> getInputDataHolders() {
//		return inputDataHolders;
//	}
//
//	
//
//	/**
//	 * @return the dataParsers
//	 */
//	public List<IDataParser> getDataParsers() {
//		return dataParsers;
//	}
//
//	
//
//	/**
//	 * @return the expectedResultAsserters
//	 */
//	public List<IExpectedResultAsserter> getExpectedResultAsserters() {
//		return expectedResultAsserters;
//	}

	
}
