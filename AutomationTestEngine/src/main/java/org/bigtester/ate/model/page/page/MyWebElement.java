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

import org.bigtester.ate.model.page.AbstractPageModelBase;
import org.bigtester.ate.model.page.elementaction.IElementAction;
import org.bigtester.ate.model.page.elementfind.IElementFind;

// TODO: Auto-generated Javadoc
/**
 * The Class MyWebElement defines ....
 * 
 * @author Peidong Hu
 */
public class MyWebElement extends AbstractPageModelBase{

	/** The i elm action. */
	private IElementAction elementAction;

	/** The i elm find. */
	private IElementFind elementFind;

	/**
	 * Instantiates a new my web element.
	 * 
	 * @param iElmFind
	 *            the ef
	 * @param iElmAction
	 *            the ea
	 */
	public MyWebElement(final IElementFind iElmFind,
			final IElementAction iElmAction) {
		super();
		this.elementAction = iElmAction;
		this.elementFind = iElmFind;
	}

	
	/**
	 * @return the elementAction
	 */
	public IElementAction getElementAction() {
		return elementAction;
	}


	/**
	 * @param elementAction the elementAction to set
	 */
	public void setElementAction(final IElementAction elementAction) {
		this.elementAction = elementAction;
	}


	/**
	 * @return the elementFind
	 */
	public IElementFind getElementFind() {
		return elementFind;
	}


	/**
	 * @param elementFind the elementFind to set
	 */
	public void setElementFind(final IElementFind elementFind) {
		this.elementFind = elementFind;
	}


	/**
	 * Do action.
	 */
	public void doAction() {
		elementAction.doAction(elementFind.doFind(getMyWd(), elementFind.getFindByValue(), elementFind.getFindByIndex()));
	}

}
