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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bigtester.ate.model.page.AbstractPageModelBase;
import org.eclipse.jdt.annotation.Nullable;
import org.openqa.selenium.Cookie;
import org.springframework.core.io.Resource;

// TODO: Auto-generated Javadoc
/**
 * This class AbstractPageObject defines ....
 * 
 * @author Peidong Hu
 * 
 */
public class AbstractPageObject extends AbstractPageModelBase {

	/** The page name. */
	private String pageName;
	
	/** The data file. */
	@Nullable
	private Resource dataFile;
	
	/** The web element list. */
	private Map<Long, MyWebElement> myWebElementList = new HashMap<Long, MyWebElement>();//NOPMD

	/** The cookies. */
	private List<Cookie> cookies = new ArrayList<Cookie>();
	
	/** The page title. */
	private String pageTitle;
	
	/**
	 * Gets the page title.
	 *
	 * @return the pageTitle
	 */
	public String getPageTitle() {
		return pageTitle;
	}

	/**
	 * Sets the page title.
	 *
	 * @param pageTitle the pageTitle to set
	 */
	public void setPageTitle(String pageTitle) {
		this.pageTitle = pageTitle;
	}

	/**
	 * Gets the cookies.
	 *
	 * @return the cookies
	 */
	public List<Cookie> getCookies() {
		return cookies;
	}

	/**
	 * Sets the cookies.
	 *
	 * @param cookies the cookies to set
	 */
	public void setCookies(List<Cookie> cookies) {
		this.cookies = cookies;
	}

	/**
	 * Sets the my web element list.
	 * 
	 * @param myWebElementList
	 *            the myWebElementList to set
	 */
	public void setMyWebElementList(Map<Long, MyWebElement> myWebElementList) {
		this.myWebElementList = myWebElementList;
	}

	/**
	 * Gets the web element list.
	 * 
	 * @return the web element list
	 */
	public Map<Long, MyWebElement> getMyWebElementList() {
		return myWebElementList;
	}

	
	/**
	 * Gets the page name.
	 *
	 * @return the pageName
	 */
	public String getPageName() {
		return pageName;
	}

	/**
	 * Sets the page name.
	 *
	 * @param pageName            the pageName to set
	 */
	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	/**
	 * Gets the data file.
	 *
	 * @return the dataFile
	 */
	@Nullable
	public Resource getDataFile() {
		return dataFile;
	}

	/**
	 * Sets the data file.
	 *
	 * @param dataFile the dataFile to set
	 */
	public void setDataFile(Resource dataFile) {
		this.dataFile = dataFile;
	}

}
