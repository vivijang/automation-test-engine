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

// TODO: Auto-generated Javadoc
/**
 * The Class TestCase defines ....
 * 
 * @author Peidong Hu
 */
public class TestCase {
	
	/** The l ts. */
	private List<ITestStep> lTs;
	
	/**
	 * Go steps.
	 */
	public void goSteps() {
		for (ITestStep tempStep : lTs) {
			tempStep.doStep();
		}
	}
	
	/**
	 * Gets the l ts.
	 * 
	 * @return the l ts
	 */
	public List<ITestStep> getlTs() {
		return lTs;
	}
	
	/**
	 * Sets the l ts.
	 * 
	 * @param lTs
	 *            the new l ts
	 */
	public void setlTs(List<ITestStep> lTs) {
		this.lTs = lTs;
	}
	

}
