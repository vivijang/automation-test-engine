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

import org.testng.TestListenerAdapter;

// TODO: Auto-generated Javadoc
/**
 * This class TestProjectListener defines ....
 * @author Peidong Hu
 *
 */
public class TestProjectListener extends TestListenerAdapter {
	
	/** The my test plan. */
	private TestProject mytp;

	/**
	 * Instantiates a new test project listener.
	 *
	 * @param mytp the mytp
	 */
	public TestProjectListener( TestProject mytp) {
		super();
		this.mytp = mytp;
	}
	
	/**
	 * @return the mytp
	 */
	public TestProject getMytp() {
		return mytp;
	}

	/**
	 * @param mytp the mytp to set
	 */
	public void setMytp(TestProject mytp) {
		this.mytp = mytp;
	}
}
