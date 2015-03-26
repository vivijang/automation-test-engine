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

import org.bigtester.ate.GlobalUtils;
import org.bigtester.ate.constant.ExceptionErrorCode;
import org.bigtester.ate.constant.StepResultStatus;
import org.bigtester.ate.model.data.exception.RuntimeDataException;
import org.bigtester.ate.model.page.atewebdriver.IMyWebDriver;
import org.bigtester.ate.model.page.exception.PageValidationException2;
import org.bigtester.ate.model.page.exception.StepExecutionException2;
import org.bigtester.ate.model.utils.ThinkTime;
import org.eclipse.jdt.annotation.Nullable;
import org.springframework.aop.support.AopUtils;

// TODO: Auto-generated Javadoc
/**
 * This class RepeatStep defines ....
 * 
 * @author Peidong Hu
 *
 */
public class RepeatStep extends BaseTestStep implements ITestStep {

	/** The test case. */
	final private TestCase testCase;
	/** The start step id. */
	private String startStepName;

	/** The end step id. */
	private String endStepName;

	/** The continue on failure. */
	private boolean continueOnFailure;

	/** The repeat times. */
	private int numberOfIterations;

	/** The step i ds. */
	final private List<Integer> stepIndexes = new ArrayList<Integer>();

	/** The external repeat node of this step. */
	private transient @Nullable RepeatStepExecutionLoggerNode externalRepeatNodeOfThisStep;

	/** The current repeat node of this step. */
	private transient @Nullable RepeatStepExecutionLoggerNode currentRepeatNodeOfThisStep;

	// /** The input data holders. */
	// final private List<IStepInputData> inputDataHolders;
	//
	// /** The data parsers. */
	// final private List<IDataParser> dataParsers;
	//
	// final private List<IExpectedResultAsserter> expectedResultAsserters;

	/**
	 * Instantiates a new repeat step.
	 *
	 * @param startStepName
	 *            the start step name
	 * @param endStepName
	 *            the end step name
	 * @param testCase
	 *            the test case
	 */
	public RepeatStep(String startStepName, String endStepName,
			TestCase testCase) {
		super();
		this.startStepName = startStepName;
		this.endStepName = endStepName;
		this.continueOnFailure = false;
		this.numberOfIterations = 1;
		this.testCase = testCase;

	}

	private void createRepeatStepIndexes() {
		int startIndex = -1; // NOPMD
		int endIndex = -1; // NOPMD
		stepIndexes.clear();
		for (int i = 0; i < testCase.getTestStepList().size(); i++) {
			if (testCase.getTestStepList().get(i).getStepName()
					.equals(this.startStepName)) {
				startIndex = i;
			}
			if (testCase.getTestStepList().get(i).getStepName()
					.equals(this.endStepName)) {
				endIndex = i;
			}
		}
		if (startIndex == -1 || endIndex == -1) throw GlobalUtils.createNotInitializedException("startStepName or endStepName");
		for (int i = 0; i < testCase.getTestStepList().size(); i++) {
			if (i >= startIndex && i <= endIndex) {
				stepIndexes.add(i);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doStep() throws StepExecutionException2,
			PageValidationException2, RuntimeDataException {

		repeatSteps();

	}

	/**
	 * run steps.
	 * 
	 * @throws RuntimeDataException
	 * @throws StepExecutionException
	 * @throws PageValidationException
	 */
	private void repeatSteps() throws StepExecutionException2,
			PageValidationException2, RuntimeDataException {
		createRepeatStepIndexes();
		for (int iteration = 1; iteration <= getNumberOfIterations(); iteration++) {
			if (1 == iteration) {// NOPMD

				if (null != getRepeatStepLogger().getRepeatStepExternalNode()) {
					externalRepeatNodeOfThisStep = getRepeatStepLogger()
							.getRepeatStepExternalNode();
				}
				getRepeatStepLogger().addRepeatStepName(getStepName());

				if (null != getRepeatStepLogger().getCurrentRepeatStepNode()) {
					currentRepeatNodeOfThisStep = getRepeatStepLogger()
							.getCurrentRepeatStepNode();
				}
			}
			setCurrentIteration(iteration);
			getApplicationContext().publishEvent(
					new RepeatDataRefreshEvent(this, getRepeatStepLogger()
							.getCurrentRepeatStepPathNodes(), iteration));
			for (int i = 0; i < getStepIndexes().size(); i++) {
				ITestStep currentTestStepTmp = getTestCase().getTestStepList()
						.get(getStepIndexes().get(i));
				if (null == currentTestStepTmp) {
					throw new IllegalStateException(
							"Test Step List was not successfully initialized by ApplicationContext at list index"
									+ i);
				} else {
					getTestCase().setCurrentTestStep(currentTestStepTmp);
				}

				try {
					String tmpStepDesc = currentTestStepTmp
							.getStepDescription();
					if (AopUtils.getTargetClass(currentTestStepTmp) == RepeatStep.class) {
						getRepeatStepLogger().setRepeatStepExternalNode(
								getRepeatStepLogger()
										.getCurrentRepeatStepNode());
						// Advised advisedStep = (Advised)currentTestStepTmp;
						// RepeatStep proxyTargetedStep = (RepeatStep)
						// advisedStep.getTargetSource().getTarget();
						// List<Integer> tmpIndexes = new
						// ArrayList(proxyTargetedStep.getStepIndexes());
					} else {
						currentTestStepTmp
								.setStepDescription(currentTestStepTmp
										.getStepDescription()
										+ " | "
										+ getRepeatStepLogger()
												.getCurrentRepeatStepFullPathString());
					}

					getTestCase().getCurrentTestStep().doStep();// NOPMD

					if (AopUtils.getTargetClass(currentTestStepTmp) == RepeatStep.class) {
						getRepeatStepLogger().setRepeatStepExternalNode(
								externalRepeatNodeOfThisStep);
						getRepeatStepLogger().setCurrentRepeatStepNode(
								currentRepeatNodeOfThisStep);
						getApplicationContext()
								.publishEvent(
										new RepeatDataRefreshEvent(
												this,
												getRepeatStepLogger()
														.getCurrentRepeatStepPathNodes(),
												iteration));

					}
					if (null == tmpStepDesc)
						tmpStepDesc = ""; // NOPMD
					else
						currentTestStepTmp.setStepDescription(tmpStepDesc);

					getTestCase().getCurrentTestStep().setStepResultStatus(
							StepResultStatus.PASS);
				} catch (StepExecutionException2 stepE) {
					if (stepE.getErrorCode() == ExceptionErrorCode.WEBELEMENT_NOTFOUND
							&& getTestCase().getCurrentTestStep()
									.isOptionalStep()) {
						getTestCase().getCurrentTestStep().setStepResultStatus(
								StepResultStatus.SKIP);
					} else {
						throw stepE;
					}
				} catch (PageValidationException2 pve) {//NOPMD
					//TODO add code to handle the page validation error according to parameter of continueOnFailure
					throw pve;
				}catch (Exception e) { // NOPMD
					throw GlobalUtils.createInternalError("Error not handled", e); // NOPMD
				}
				if (getTestCase().getStepThinkTime() > 0) {
					ThinkTime thinkTimer = new ThinkTime(getTestCase()
							.getStepThinkTime());
					thinkTimer.setTimer();
				}

			}
		}
		RepeatStepExecutionLoggerNode thisStepNode = getRepeatStepLogger()
				.getCurrentRepeatStepNode();
		if (thisStepNode != null && thisStepNode.getParent() == null) {
			getApplicationContext().publishEvent(
					new RepeatDataRefreshEvent(this));
		}
	}

	/**
	 * @return the startStepID
	 */
	public String getStartStepName() {
		return startStepName;
	}

	/**
	 * @param startStepName
	 *            the startStepID to set
	 */
	public void setStartStepName(String startStepName) {
		this.startStepName = startStepName;
	}

	/**
	 * @return the endStepID
	 */
	public String getEndStepName() {
		return endStepName;
	}

	/**
	 * @param endStepName
	 *            the endStepID to set
	 */
	public void setEndStepName(String endStepName) {
		this.endStepName = endStepName;
	}

	/**
	 * @return the continueOnFailure
	 */
	public boolean isContinueOnFailure() {
		return continueOnFailure;
	}

	/**
	 * @param continueOnFailure
	 *            the continueOnFailure to set
	 */
	public void setContinueOnFailure(boolean continueOnFailure) {
		this.continueOnFailure = continueOnFailure;
	}

	/**
	 * @return the repeatTimes
	 */
	public int getNumberOfIterations() {
		return numberOfIterations;
	}

	/**
	 * @param numberOfIterations
	 *            the repeatTimes to set
	 */
	public void setNumberOfIterations(int numberOfIterations) {
		this.numberOfIterations = numberOfIterations;
	}

	/**
	 * @return the testCase
	 */
	public TestCase getTestCase() {
		return testCase;
	}

	/**
	 * @return the stepIndexes
	 */
	public List<Integer> getStepIndexes() {
		return stepIndexes;
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

}
