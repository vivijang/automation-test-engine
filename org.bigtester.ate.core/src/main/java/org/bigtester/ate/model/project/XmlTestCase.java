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

import org.eclipse.jdt.annotation.Nullable;

// TODO: Auto-generated Javadoc
/**
 * The Class TestCase defines ....
 * 
 * @author Peidong Hu
 */
public class XmlTestCase {
	
	
	/** The test case name. */
	private String testCaseFilePathName;
	
	/** The depend on test cases. */
	@Nullable
	private List<CaseDependency> dependOnTestCases;

	/**
	 * Instantiates a new xml test case.
	 *
	 * @param testCaseName the test case name
	 */
	public XmlTestCase(String testCaseName) {
		this.testCaseFilePathName = testCaseName;
	}
	/**
	 * Gets the test case name.
	 *
	 * @return the testCaseName
	 */
	public String getTestCaseFilePathName() {
		return testCaseFilePathName;
	}

	/**
	 * Sets the test case name.
	 *
	 * @param testCaseName the testCaseName to set
	 */
	public void setTestCaseFilePathName(final String testCaseName) {
		this.testCaseFilePathName = testCaseName;
	}
	/**
	 * @return the dependOnTestCases
	 */
	@Nullable
	public List<CaseDependency> getDependOnTestCases() {
		return dependOnTestCases;
	}
	/**
	 * @param dependOnTestCases the dependOnTestCases to set
	 */
	public void setDependOnTestCases(List<CaseDependency> dependOnTestCases) {
		this.dependOnTestCases = dependOnTestCases;
	}

	

}
