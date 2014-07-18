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
package org.bigtester.ate.model.page.page;

import org.bigtester.ate.model.page.elementaction.IElementAction;
import org.bigtester.ate.model.page.elementfind.IElementFind;

// TODO: Auto-generated Javadoc
/**
 * The Class MyWebElement defines ....
 * 
 * @author Peidong Hu
 */
public class MyWebElement {

	/** The ea. */
	private IElementAction ea;

	/** The ef. */
	private IElementFind ef;

	/**
	 * Instantiates a new my web element.
	 * 
	 * @param ef
	 *            the ef
	 * @param ea
	 *            the ea
	 */
	public MyWebElement(IElementFind ef, IElementAction ea) {
		this.ea = ea;
		this.ef = ef;
	}

	/**
	 * Do action.
	 */
	public void doAction() {
		ea.doAction(ef.doFind(ef.getFindByValue()));
	}

	/**
	 * Gets the ea.
	 * 
	 * @return the ea
	 */
	public IElementAction getEa() {
		return ea;
	}

	/**
	 * Sets the ea.
	 * 
	 * @param ea
	 *            the new ea
	 */
	public void setEa(IElementAction ea) {
		this.ea = ea;
	}

	/**
	 * Gets the ef.
	 * 
	 * @return the ef
	 */
	public IElementFind getEf() {
		return ef;
	}

	/**
	 * Sets the ef.
	 * 
	 * @param ef
	 *            the new ef
	 */
	public void setEf(IElementFind ef) {
		this.ef = ef;
	}

}
