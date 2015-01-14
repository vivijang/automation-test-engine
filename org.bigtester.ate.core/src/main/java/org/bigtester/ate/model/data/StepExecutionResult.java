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
package org.bigtester.ate.model.data;

import java.util.HashMap;
import java.util.Map;

import org.bigtester.ate.constant.EnumAssertResult;
import org.eclipse.jdt.annotation.Nullable;



// TODO: Auto-generated Javadoc
/**
 * This class StepExecuteResult defines ....
 * @author Peidong Hu
 *
 */
public class StepExecutionResult {
	
	/** The step expected result value. */
	@Nullable
	private StepExpectedResultValue stepExpectedResultValue;
	
	/** The actual result. */
	private ActualResult actualResult = new ActualResult();
	
	/** The exec result. */
	private final transient Map<Long, EnumAssertResult> comparedResult = new HashMap<Long, EnumAssertResult>(); //NOPMD
	
	/** The failed results. */
	private Map<Long, EnumAssertResult> failedResults = new HashMap<Long, EnumAssertResult>(); //NOPMD
	
	/** The flag fail case. */
	private boolean flagFailCase;
	
	/**
	 * @return the stepExpectedResultValue
	 */
	public StepExpectedResultValue getStepExpectedResultValue() {
		final StepExpectedResultValue stepExpectedResultValue2 = stepExpectedResultValue;
		if (null == stepExpectedResultValue2 ) {
			throw new IllegalStateException("stepExpectedresultvalue is not correct populated");
		} else {
			return stepExpectedResultValue2;
		}
	}

	/**
	 * @param stepExpectedResultValue the stepExpectedResultValue to set
	 */
	public void setStepExpectedResultValue(StepExpectedResultValue stepExpectedResultValue) {
		this.stepExpectedResultValue = stepExpectedResultValue;
	}

	/**
	 * @return the actualResult
	 */
	public ActualResult getActualResult() {
		return actualResult;
	}

	/**
	 * @param actualResult the actualResult to set
	 */
	public void setActualResult(ActualResult actualResult) {
		this.actualResult = actualResult;
	}

	/**
	 * @return the comparedResult
	 */
	public Map<Long, EnumAssertResult> getComparedResult() {
		return comparedResult;
	}

	/**
	 * @return the failedResults
	 */
	public Map<Long, EnumAssertResult> getFailedResults() {
		return failedResults;
	}

	/**
	 * @param failedResults the failedResults to set
	 */
	public void setFailedResults(Map<Long, EnumAssertResult> failedResults) {
		this.failedResults = failedResults;
	}

	/**
	 * @return the flagFailCase
	 */
	public boolean isFlagFailCase() {
		return flagFailCase;
	}

	/**
	 * @param flagFailCase the flagFailCase to set
	 */
	public void setFlagFailCase(boolean flagFailCase) {
		this.flagFailCase = flagFailCase;
	}

		
	
}
