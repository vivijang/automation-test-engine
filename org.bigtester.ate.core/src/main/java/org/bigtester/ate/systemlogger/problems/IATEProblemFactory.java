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

import org.bigtester.ate.model.AbstractATEException;
import org.bigtester.problomatic2.Problem;

// TODO: Auto-generated Javadoc
/**
 * This class IPageFactory defines ....
 * @author Peidong Hu
 *
 */
public interface IATEProblemFactory {
	
	
	/**
	 * Gets the ATE problem.
	 *
	 * @param exceptionErrorCode the exception error code
	 * @return the ATE problem
	 */
	Problem getATEProblem(Object source, AbstractATEException ateException);
	
	/**
	 * Gets the ATE case exec problem.
	 *
	 * @param source the source
	 * @param ateException the ate exception
	 * @return the ATE case exec problem
	 */
	IATECaseExecProblem getATECaseExecProblem(Object source, AbstractATEException ateException);
	
}
