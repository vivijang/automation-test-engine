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

import org.bigtester.ate.model.page.page.MyWebElement;

// TODO: Auto-generated Javadoc
/**
 * The Class TestStep defines ....
 * 
 * @author Peidong Hu
 */
public class TestStep implements ITestStep {
	// TOTO add pageObject as another member.

	/** The my we. */
	private MyWebElement myWebElement;

	/**
	 * Gets the my web element.
	 *
	 * @return the myWebElement
	 */
	public final MyWebElement getMyWebElement() {
		return myWebElement;
	}

	/**
	 * Sets the my web element.
	 *
	 * @param myWebElement            the myWebElement to set
	 */
	public final void setMyWebElement(final MyWebElement myWebElement) {
		this.myWebElement = myWebElement;
	}

	/**
	 * Instantiates a new test step.
	 * 
	 * @param myWe
	 *            the my we
	 */
	public TestStep(final MyWebElement myWe) {
		this.myWebElement = myWe;
	}

	
	/**
	 * {@inheritDoc}
	 */
	public void doStep() {

		myWebElement.doAction();
	}
}
