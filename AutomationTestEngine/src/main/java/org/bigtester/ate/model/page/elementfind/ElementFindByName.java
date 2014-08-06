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
package org.bigtester.ate.model.page.elementfind;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

// TODO: Auto-generated Javadoc
/**
 * The Class ElementFindByName defines the way to find element by name
 * 
 * @author Peidong Hu
 */
public class ElementFindByName extends AbstractElementFind implements IElementFind {
	
	/** The find by value. */
	private String findByValue;
	
	
	/**
	 * {@inheritDoc}
	 */
	public String getFindByValue() {
		return findByValue;
	}
	
	
	/**
	 * {@inheritDoc}
	 */
	public void setFindByValue(final String findByValue) {
		this.findByValue = findByValue;
	}
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public WebElement doFind(final String findByValue) {
		return super.getMyWd().getWebDriver().findElement(By.name(findByValue));
	}


	
	
}
