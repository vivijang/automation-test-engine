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
package org.bigtester.ate.systemlogger.problems;

import org.bigtester.ate.model.IATECaseExecException;
import org.bigtester.ate.model.page.exception.StepExecutionException2;
import org.bigtester.ate.model.casestep.ITestStep;
import org.bigtester.ate.model.casestep.TestCase;


// TODO: Auto-generated Javadoc
/**
 * This class StepExecutionProblem defines ....
 * 
 * @author Peidong Hu
 * 
 */
public class StepExecutionProblem2 extends GenericATEProblem implements IATECaseExecProblem{
	
	
	
	/** The problem test case. */
	private final TestCase problemTestCase;	
	/** The step exec exception. */
	private final StepExecutionException2 stepExecException;
	
	/**
	 * Instantiates a new page validation problem.
	 *
	 * @param source the source
	 * @param see the see
	 * @param pTc the tc
	 */
	public StepExecutionProblem2(Object source, StepExecutionException2 see) {
		super(source, see);
		stepExecException = see;
		problemTestCase = see.getCurrentTestCase();
	}
	
	

	/**
	 * Gets the step exec exception.
	 *
	 * @return the stepExecException
	 */
	public StepExecutionException2 getStepExecException() {
		return stepExecException;
	}

	/**
	 * Gets the problem test case.
	 *
	 * @return the problemTestCase
	 */
	public TestCase getProblemTestCase() {
		return problemTestCase;
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public TestCase getCurrentTestCase() {
		return this.stepExecException.getCurrentTestCase();
	}



	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public ITestStep getCurrentTestStep() {
		return this.getCurrentTestCase().getCurrentTestStep();
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getProblemMessage() {
		return this.getATECaseExecException().getMessage();
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public IATECaseExecException getATECaseExecException() {
		return this.getStepExecException();
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getErrorCode() {
		return this.getStepExecException().getErrorCode();
	}


}
