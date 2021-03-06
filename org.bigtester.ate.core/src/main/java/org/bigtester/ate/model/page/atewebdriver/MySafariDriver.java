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

import org.bigtester.ate.browser.BrowserProfile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.eclipse.jdt.annotation.Nullable;

// TODO: Auto-generated Javadoc
/**
 * The Class MysafariDriver defines ....
 * 
 * @author Jun Yang
 */
public class MySafariDriver extends WebDriverBase implements IMyWebDriver{

	/** The browser profile. */
	@Nullable
	final private BrowserProfile<SafariOptions> browserProfile;
//	/** The Constant BROWSERNAME. */
//	final static private String BROWSERNAME = "webdriver.safari.driver";
	
	/**
	 * Instantiates a new my safari driver.
	 */
	public MySafariDriver() {
		//TODO create Safari browsers and remote web driver handler
		super();
		browserProfile = null;
	}

	/**
	 * Instantiates a new my Safari driver.
	 *
	 * @param profileName the profile name
	 */
	public MySafariDriver(String profileName) {
		super();
		browserProfile = new BrowserProfile<SafariOptions>(SafariOptions.class, profileName);
		//setWebDriver(new SafariDriver(browserProfile.getProfile()));
	}
	
	
	/**
	 * @return the browserProfile
	 */
	
	public BrowserProfile<SafariOptions> getBrowserProfile() {
		
		final BrowserProfile<SafariOptions> retVal = browserProfile;
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
//		OSinfo osinfo = new OSinfo(); 
//		EPlatform platform = osinfo.getOSname();
//		switch (platform)
//		{
//			case Windows_32:	
//				System.setProperty(BROWSERNAME, "browserdriver/windows/safari/32bit/2.12/safaridriver.exe");
//				break;
//			case Windows_64:	
//				System.setProperty(BROWSERNAME, "browserdriver/windows/safari/64bit/2.12/safaridriver.exe");
//				break;	
//			case Linux_32:	
//				System.setProperty(BROWSERNAME, "browserdriver/linux/safari/32bit/2.12/safaridriver.exe");
//				break;
//			case Linux_64:	
//				System.setProperty(BROWSERNAME, "browserdriver/linux/safari/64bit/2.12/safaridriver.exe");
//				break;	
//			case Mac_OS_X_32:	
//				System.setProperty(BROWSERNAME, "browserdriver/osx/safari/32bit/2.11/safaridriver.exe");
//				break;
//			case Mac_OS_X_64:	
//				System.setProperty(BROWSERNAME, "browserdriver/osx/safari/64bit/2.11/safaridriver.exe");
//				break;		
//			default:
//				throw GlobalUtils.createNotInitializedException("operating system is not supported ");
//		}        
		WebDriver retVal = new SafariDriver();
		setWebDriver(retVal);
		return retVal;
		/*
		if ( null == retVal) {
			if (null == getBrowserProfile().getProfile()) {
				retVal = new SafariDriver();
			} else {
				retVal = new SafariDriver(getBrowserProfile().getProfile());
			}
			setWebDriver(retVal);
			
		}
		return retVal;
		*/
	}
	
	
}
