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
import org.openqa.selenium.WebElement;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class PageObject defines ....
 * 
 * @author Peidong Hu
 */
public class PageObject extends AbstractPageModelBase {

	/** The l we. */
	private List<WebElement> webElementList;

	/**
	 * Gets the web element list.
	 * 
	 * @return the web element list
	 */
	public List<WebElement> getWebElementList() {
		return webElementList;
	}

	/**
	 * Sets the web element list.
	 * 
	 * @param webElementList
	 *            the new web element list
	 */
	public void setWebElementList(final List<WebElement> webElementList) {
		this.webElementList = webElementList;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void navigate() {
		// TODO Auto-generated method stub
		
	}

}
