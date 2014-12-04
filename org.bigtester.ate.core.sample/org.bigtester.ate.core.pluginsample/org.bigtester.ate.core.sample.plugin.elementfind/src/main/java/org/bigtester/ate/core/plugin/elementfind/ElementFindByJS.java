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
package org.bigtester.ate.core.plugin.elementfind;

import org.bigtester.ate.model.page.atewebdriver.IMyWebDriver;
import org.bigtester.ate.model.page.elementfind.AbstractElementFind;
import org.bigtester.ate.model.page.elementfind.IElementFind;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;



// TODO: Auto-generated Javadoc
/**
 * This class ElementFindByJS defines ....
 * 
 * @author Peidong Hu
 *
 */

public class ElementFindByJS extends AbstractElementFind implements IElementFind {
	/** The find by value. */
	private String findByValue;
	
	/** The find by index. */
	private int findByIndex;
	
	/**
	 * @return the findByIndex
	 */
	/**
	 * {@inheritDoc}
	 */
	public int getFindByIndex() {
		return findByIndex;
	}

	/**
	 * @param findByIndex the findByIndex to set
	 */
	public void setFindByIndex(int findByIndex) {
		this.findByIndex = findByIndex;
	}
	/**
	 * Gets the find by value.
	 * 
	 * @return the find by value
	 */
	/**
	 * {@inheritDoc}
	 */
	public String getFindByValue() {
		return findByValue;
	}
	
	/**
	 * Sets the find by value.
	 * 
	 * @param findByValue
	 *            the new find by value
	 */
	public void setFindByValue(final String findByValue) {
		this.findByValue = findByValue;
	}

	
	/**
	 * {@inheritDoc}
	 */
	public boolean supports(String arg0) {
		// TODO Auto-generated method stub
		return "ElementFind".equals(arg0);
	}

	/**
	 * {@inheritDoc}
	 */
	public WebElement doFind(IMyWebDriver myWebDriver, String findByValue) {
		return myWebDriver.getWebDriver().findElement(By.id(findByValue));
	}

	

}
