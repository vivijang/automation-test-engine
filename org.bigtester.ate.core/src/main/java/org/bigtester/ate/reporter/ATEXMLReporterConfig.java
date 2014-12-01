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

import org.testng.reporters.XMLReporterConfig;

// TODO: Auto-generated Javadoc
/**
 * This class ATEXMLReporterConfig defines ....
 * 
 * @author Peidong Hu
 * 
 */
public final class ATEXMLReporterConfig extends XMLReporterConfig {
	/** The Constant TAG_STEPS. */
	public final static String TAG_STEPS = "Steps";

	/** The Constant TAG_STEP. */
	public final static String TAG_STEP = "Step";

	/** The Constant TAG_STEP_DESC. */
	public final static String TAG_STEP_DESC = "StepDescription";
	
	/** The Constant TAG_STEP_RESULT. */
	public final static String TAG_STEP_RESULT = "StepResult";

	private ATEXMLReporterConfig() {
		super();
	}

}
