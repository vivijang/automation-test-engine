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

import org.bigtester.ate.constant.EnumElementFindType;
import org.bigtester.ate.model.page.elementaction.IElementAction;
import org.bigtester.ate.model.page.elementfind.ElementFindById;
import org.bigtester.ate.model.page.elementfind.ElementFindByLinkText;
import org.bigtester.ate.model.page.elementfind.ElementFindByName;
import org.bigtester.ate.model.page.elementfind.IElementFind;

// TODO: Auto-generated Javadoc
/**
 * This class ATEPageFactory defines ....
 * 
 * @author Peidong Hu
 * 
 */
public final class ATEPageFactory implements IATEPageFactory {

	//private IPageObject iPageOject;
	//private MyWebElement myWebElement;
	//private IElementFind iElementFind;
	//private IElementAction iElementAction;
	/** The instance. */
	private static IATEPageFactory instance;

	private ATEPageFactory() {
	}

	/**
	 * Gets the single instance of ATEPageFactory.
	 * 
	 * @return single instance of ATEPageFactory
	 */
	public static synchronized IATEPageFactory getInstance() { //NOPMD

		if (null == instance) {
			instance = new ATEPageFactory();
		}
		return instance;

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IPageObject getIPageObject() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MyWebElement getMyWebElement(
			EnumElementFindType elementFindType, String findByValue) {
		synchronized (this) {
			return new MyWebElement(getIElementFind(elementFindType, findByValue), null);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IElementFind getIElementFind(
			EnumElementFindType elementFindType, String findByValue) {
		//TODO add more findby type
		synchronized (this) {
			IElementFind retVal;
			switch (elementFindType) {
			case ID:
				ElementFindById efbID = new ElementFindById();
				efbID.setFindByValue(findByValue);
				retVal = (IElementFind) efbID;
				break;
			case NAME:
				ElementFindByName efbName = new ElementFindByName();
				efbName.setFindByValue(findByValue);
				retVal = (IElementFind) efbName;
				break;
			case LINKTEXT:
				ElementFindByLinkText efbLinkText = new ElementFindByLinkText();
				efbLinkText.setFindByValue(findByValue);
				retVal = (IElementFind) efbLinkText;
				break;
			default:
				ElementFindById efbIDd = new ElementFindById();
				efbIDd.setFindByValue(findByValue);
				retVal = (IElementFind) efbIDd;
				break;
			}
			return retVal;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IElementAction getIElementAction() {
		// TODO Auto-generated method stub
		return null;
	}

}
