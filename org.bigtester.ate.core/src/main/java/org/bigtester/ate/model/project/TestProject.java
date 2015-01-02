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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bigtester.ate.reporter.ATEXMLReporter;
import org.bigtester.ate.systemlogger.LogbackWriter;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
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

	/** The app ctx. */
	private ApplicationContext appCtx;
	
	/** The global init xmlfiles. */
	private Resource globalInitXmlFile;
	
	/** The step think time. */
	private int stepThinkTime;
	
	/** The test project listener. */
	private TestProjectListener testProjectListener;
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

		final TestProjectListener tla = new TestProjectListener();
		tla.setMytp(this);
		final TestNG testng = new TestNG();
		testng.addListener(tla);
		
		ATEXMLReporter rng = new ATEXMLReporter();
		rng.setStackTraceOutputMethod(XMLReporterConfig.STACKTRACE_NONE);
		testng.addListener(rng);
		
		final List<XmlSuite> suites = new ArrayList<XmlSuite>();

		for (TestSuite tempSuite : suiteList) {

			XmlSuite suite = new XmlSuite();
			suite.setName(tempSuite.getSuiteName());

			for (XmlTestCase tempTC : tempSuite.getTestCaseList()) {

				XmlClass xmlClass = new XmlClass(
						"org.bigtester.ate.model.project.CaseRunner");

				List<XmlClass> classes = new ArrayList<XmlClass>();
				classes.add(xmlClass);

				XmlTest test = new XmlTest(suite);
				//test.addParameter(ThinkTimeConstants.TESTNG_THINKTIME_PARAM_NAME, Integer.toString(stepThinkTime));
				test.setName(tempTC.getTestCaseName());
				test.setXmlClasses(classes);
			}
			suites.add(suite);
			LogbackWriter.writeAppInfo(suite.toXml());
		}
		if (suites.isEmpty()) {
			// TODO
		} else {
			testng.setXmlSuites(suites);

			testng.run();

		}

	}

	
	

	/**
	 * @return the stepThinkTime
	 */
	public int getStepThinkTime() {
		return stepThinkTime;
	}

	/**
	 * @param stepThinkTime the stepThinkTime to set
	 */
	public void setStepThinkTime(int stepThinkTime) {
		this.stepThinkTime = stepThinkTime;
	}

	/**
	 * @return the testProjectListener
	 */
	public TestProjectListener getTestProjectListener() {
		return testProjectListener;
	}

	/**
	 * @param testProjectListener the testProjectListener to set
	 */
	public void setTestProjectListener(TestProjectListener testProjectListener) {
		this.testProjectListener = testProjectListener;
	}

	/**
	 * @return the appCtx
	 */
	public ApplicationContext getAppCtx() {
		return appCtx;
	}

	/**
	 * @param appCtx the appCtx to set
	 */
	public void setAppCtx(ApplicationContext appCtx) {
		this.appCtx = appCtx;
	}

	/**
	 * @return the globalInitXmlfile
	 */
	public Resource getGlobalInitXmlFile() {
		return globalInitXmlFile;
	}

	/**
	 * @param globalInitXmlfile the globalInitXmlfile to set
	 * @throws IOException 
	 */
	public void setGlobalInitXmlFile(Resource globalInitXmlFile) throws IOException {
		this.globalInitXmlFile = globalInitXmlFile;
	}

}
