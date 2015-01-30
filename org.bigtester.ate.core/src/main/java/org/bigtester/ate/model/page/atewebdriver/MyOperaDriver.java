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

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.bigtester.ate.GlobalUtils;
import org.bigtester.ate.browser.BrowserProfile;
import org.eclipse.jdt.annotation.Nullable;

// TODO: Auto-generated Javadoc
/**
 * The Class MyChromeDriver defines ....
 * 
 * @author Jun Yang
 */
public class MyOperaDriver extends WebDriverBase implements IMyWebDriver{
	
	/** The browser profile. */
	@Nullable
	final private BrowserProfile<ChromeOptions> browserProfile;
	/** The Constant BROWSERNAME. */
	final static private String BROWSERNAME = "webdriver.opera.driver";
	
	
	/**
	 * Instantiates a new my Opera driver.
	 */
	public MyOperaDriver() {
		//TODO create Opera browsers and remote web driver handler
		super();
		browserProfile = null;
		System.setProperty("webdriver.chrome.driver", "browserdriver/windows/opera/32bit/0.1.0/operadriver.exe");
	}

	/**
	 * @return the browserProfile
	 */
	
	public BrowserProfile<ChromeOptions> getBrowserProfile() {
		final BrowserProfile<ChromeOptions> retVal = browserProfile;
		if (null == retVal) {
			throw new IllegalStateException("browserProfile is not correctly populated");
		} else {
			return retVal;
		}
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
		OSinfo osinfo = new OSinfo(); 
		EPlatform platform = osinfo.getOSname();
		switch (platform)
		{
			case Windows_32:	
				System.setProperty(BROWSERNAME, "browserdriver/windows/opera/32bit/0.1.0/operadriver.exe");
				break;
			case Windows_64:	
				System.setProperty(BROWSERNAME, "browserdriver/windows/opera/64bit/0.1.0/operadriver.exe");
				break;	
			case Linux_32:	
				System.setProperty(BROWSERNAME, "browserdriver/linux/opera/32bit/0.1.0/operadriver");
				break;
			case Linux_64:	
				System.setProperty(BROWSERNAME, "browserdriver/linux/opera/64bit/0.1.0/operadriver");
				break;
			case Mac_OS_X_32:	
				System.setProperty(BROWSERNAME, "browserdriver/osx/opera/32bit/0.1.0/operadriver");
				break;	
			case Mac_OS_X_64:	
				System.setProperty(BROWSERNAME, "browserdriver/osx/opera/64bit/0.1.0/operadriver");
				break;		
			default:
				throw GlobalUtils.createNotInitializedException("operating system is not supported ");
		}        
		WebDriver retVal = new ChromeDriver();
		setWebDriver(retVal);
		return retVal;
		/*
		if ( null == retVal) {
			if (null == getBrowserProfile().getProfile()) {
				retVal = new ChromeDriver();
			} else {
				retVal = new ChromeDriver(getBrowserProfile().getProfile());
			}
			setWebDriver(retVal);
		}
		return retVal;
		*/
	}
    	
}
