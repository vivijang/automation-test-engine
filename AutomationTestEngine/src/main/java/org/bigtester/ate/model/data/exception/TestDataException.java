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
package org.bigtester.ate.model.data.exception;

import lombok.Getter;
import lombok.Setter;

import org.bigtester.ate.model.AbstractATEException;

// TODO: Auto-generated Javadoc
/**
 * This class StepExecutionException defines ....
 * 
 * @author Peidong Hu
 * 
 */
public class TestDataException extends AbstractATEException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2675548817712757408L;
	
	/**
	 * Sets the message.
	 *
	 * @param message the new message
	 */
	@Setter
	
	/**
	 * @override
	 */
	@Getter
	private String message; //NOPMD
	
	
	/**
	 * Gets the test step name.
	 *
	 * @return the test step name
	 */
	@Getter
	
		
	/**
	 * Sets the test step name.
	 *
	 * @param testStepName the new test step name
	 */
	@Setter
	private String testStepName; //NOPMD
	
	/**
	 * Gets the test case name.
	 *
	 * @return the test case name
	 */
	@Getter
	
	/**
	 * Sets the test case name.
	 *
	 * @param testCaseName the new test case name
	 */
	@Setter
	private String testCaseName; //NOPMD

	/**
	 * Instantiates a new step execution exception.
	 *
	 * @param message            the message
	 * @param errorCode            the error code
	 */
	public TestDataException(String message, String errorCode) {
		super(message, errorCode);
		this.message = message;
		
	}
}
