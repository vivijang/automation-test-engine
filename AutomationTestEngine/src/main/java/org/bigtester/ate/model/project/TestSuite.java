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
package org.bigtester.ate.model.project;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class TestSuite defines ....
 * 
 * @author Peidong Hu
 */
public class TestSuite {
	
	/**
	 * Gets the l testcase.
	 * 
	 * @return the l testcase
	 */
	public List<TestCase> getlTestcase() {
		return lTestcase;
	}
	
	/**
	 * Sets the l testcase.
	 * 
	 * @param lTestcase
	 *            the new l testcase
	 */
	public void setlTestcase(List<TestCase> lTestcase) {
		this.lTestcase = lTestcase;
	}
	
	/** The l testcase. */
	private List<TestCase> lTestcase;
	
	/** The suite name. */
	private String suiteName;
	
	/**
	 * Gets the suite name.
	 * 
	 * @return the suite name
	 */
	public String getSuiteName() {
		return suiteName;
	}
	
	/**
	 * Sets the suite name.
	 * 
	 * @param suiteName
	 *            the new suite name
	 */
	public void setSuiteName(String suiteName) {
		this.suiteName = suiteName;
	}
	
	/**
	 * Instantiates a new test suite.
	 */
	public TestSuite () {
		
	}
}
