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

import java.util.ArrayList;
import java.util.List;

import org.bigtester.ate.reporter.ATEXMLReporter;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.reporters.XMLReporterConfig;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

// TODO: Auto-generated Javadoc
/**
 * The Class TestProject defines ....
 * 
 * @author Peidong Hu
 */
public class TestProject {

	/** The suite list. */
	private List<TestSuite> suiteList;

	/**
	 * Gets the suite list.
	 * 
	 * @return the suiteList
	 */
	public List<TestSuite> getSuiteList() {
		return suiteList;
	}

	/**
	 * Sets the suite list.
	 * 
	 * @param suiteList
	 *            the suiteList to set
	 */
	public void setSuiteList(List<TestSuite> suiteList) {
		this.suiteList = suiteList;
	}

	/**
	 * Run suites.
	 */
	public void runSuites() {

		final TestListenerAdapter tla = new TestListenerAdapter();
		final TestNG testng = new TestNG();
		testng.addListener(tla);
		
		ATEXMLReporter rng = new ATEXMLReporter();
		rng.setStackTraceOutputMethod(XMLReporterConfig.STACKTRACE_NONE);
		testng.addListener(rng);
		
		final List<XmlSuite> suites = new ArrayList<XmlSuite>();

		for (TestSuite tempSuite : suiteList) {

			XmlSuite suite = new XmlSuite();
			suite.setName(tempSuite.getSuiteName());

			for (TestCase tempTC : tempSuite.getTestCaseList()) {

				XmlClass xmlClass = new XmlClass(
						"org.bigtester.ate.model.project.CaseRunner");

				List<XmlClass> classes = new ArrayList<XmlClass>();
				classes.add(xmlClass);

				XmlTest test = new XmlTest(suite);
				test.setName(tempTC.getTestCaseName());
				test.setXmlClasses(classes);
			}
			suites.add(suite);
			System.out.println(suite.toXml());
		}
		if (suites.isEmpty()) {
			// TODO
		} else {
			testng.setXmlSuites(suites);

			testng.run();

		}

	}

}
