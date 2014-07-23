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
package org.bigtester.ate.reporter;

import java.util.List;
import java.util.Properties;

import org.bigtester.ate.model.testresult.TestStepResult;
import org.testng.ITestResult;
import org.testng.reporters.XMLStringBuffer;

import com.sun.istack.internal.NotNull;

// TODO: Auto-generated Javadoc
/**
 * This class TestStepsXMLReporter defines ....
 * 
 * @author Peidong Hu
 * 
 */
public final class TestStepsXMLReporterUtils {

	private TestStepsXMLReporterUtils() {

	}

	/**
	 * Adds the test steps.
	 * 
	 * @param xmlBuffer
	 *            the xml buffer
	 * @param testResult
	 *            the test result
	 */
	public static void addTestSteps(XMLStringBuffer xmlBuffer,
			ITestResult testResult) {

		if (testResult.getAttribute(TestStepResult.STEPRESULTLIST) instanceof List<?>) {
			@SuppressWarnings("unchecked")
			List<TestStepResult> stepResults = (List<TestStepResult>) testResult
					.getAttribute(TestStepResult.STEPRESULTLIST);
			if (stepResults == null) {

			} else if (!stepResults.isEmpty()) {
				xmlBuffer.push(ATEXMLReporterConfig.TAG_STEPS);
				for (int i = 0; i < stepResults.size(); i++) {
					addStep(xmlBuffer, stepResults.get(i), i);
				}
				xmlBuffer.pop();
			}
		}
	}

	/**
	 * Adds the step.
	 * 
	 * @param xmlBuffer
	 *            the xml buffer
	 * @param tsr
	 *            the parameter
	 * @param iCount
	 *            the i
	 */
	private static void addStep(XMLStringBuffer xmlBuffer,
			@NotNull TestStepResult tsr, int iCount) {
		Properties attrs = new Properties();
		attrs.setProperty(ATEXMLReporterConfig.ATTR_INDEX,
				String.valueOf(iCount));
		attrs.setProperty(ATEXMLReporterConfig.ATTR_NAME, tsr.getStepName());
		xmlBuffer.push(ATEXMLReporterConfig.TAG_STEP, attrs);
		xmlBuffer.push(ATEXMLReporterConfig.TAG_STEP_DESC);
		xmlBuffer.addCDATA(tsr.getThisStep().getStepDescription());
		xmlBuffer.pop();
		xmlBuffer.pop();
	}

}
