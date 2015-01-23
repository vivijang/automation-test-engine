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
package org.bigtester.ate.model.page.atewebdriver;

import org.eclipse.jdt.annotation.Nullable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

// TODO: Auto-generated Javadoc
/**
 * The Class MyIEDriver defines ....
 * 
 * @author Jun Yang
 */
public class MyIEDriver extends WebDriverBase implements IMyWebDriver{
	
	/**
	 * Instantiates a new my IE driver.
	 */
	public MyIEDriver() {
		//TODO create multi browsers and remote web driver handler
		super();
		System.setProperty("webdriver.ie.driver", "browserdriver/IEDriverServer32.exe");
//		System.setProperty("webdriver.ie.driver.loglevel", "ERROR");
//		System.setProperty("webdriver.ie.driver.logfile", "d:/develop/IEDriver64.log");
//		DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
//      ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public @Nullable WebDriver getWebDriver() {
		return super.getWebDriver();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public WebDriver createDriver() {
		WebDriver retVal = new InternetExplorerDriver();
		setWebDriver(retVal);
		return retVal;
	}
	
}
