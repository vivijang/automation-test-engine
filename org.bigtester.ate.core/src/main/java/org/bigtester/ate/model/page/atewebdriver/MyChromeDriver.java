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
public class MyChromeDriver extends WebDriverBase implements IMyWebDriver{
	
	/** The browser profile. */
	@Nullable
	final private BrowserProfile<ChromeOptions> browserProfile;
	
	/** The Constant BROWSERNAME. */
	private static final String BROWSERNAME = "googlechrome";
	/** The Constant BROWSERDRVNAME. */
	private static final String BROWSERDRVNAME = "webdriver.chrome.driver";
	/** The Constant BROWSERWIN32PATH. */
	private static final String BROWSERWIN32PATH = "browserdriver/windows/googlechrome/32bit/";
	/** The Constant BROWSERWIN64PATH. */
	private static final String BROWSERWIN64PATH = "browserdriver/windows/googlechrome/64bit/";
	/** The Constant BROWSERLINUX32PATH. */
	private static final String BROWSERLINUX32PATH = "browserdriver/linux/googlechrome/32bit/";
	/** The Constant BROWSERLINUX64PATH. */
	private static final String BROWSERLINUX64PATH = "browserdriver/liunx/googlechrome/64bit/";
	/** The Constant BROWSEROSX32PATH. */	
	private static final String BROWSEROSX32PATH = "browserdriver/osx/googlechrome/32bit/";
	/** The Constant BROWSEROSX32PATH. */
	private static final String BROWSEROSX64PATH = "browserdriver/osx/googlechrome/64bit/";
	/** The Constant BROWSERFILENAME. */
	private static final String BROWSERFILENAME = "/chromedriver.exe";
	
	/**
	 * Instantiates a new my Chrome driver.
	 */
	public MyChromeDriver() {
		//TODO create Chrome browsers and remote web driver handler
		super();
		browserProfile = null;
	}

	/**
	 * @return the browserProfile
	 */
	
	public @Nullable BrowserProfile<ChromeOptions> getBrowserProfile() {
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
		String versionNum;
		OSinfo osinfo = new OSinfo(); 
		EPlatform platform = osinfo.getOSname();
		
		switch (platform)
		{
            case Windows_32:
                 versionNum = ReadXmlFile.parserXml(ReadXmlFile.REPOFILENAME,"windows",BROWSERNAME,ReadXmlFile.VERSION);
                 System.setProperty(BROWSERDRVNAME, BROWSERWIN32PATH + versionNum + BROWSERFILENAME);
                 break;
            case Windows_64:
                 versionNum = ReadXmlFile.parserXml(ReadXmlFile.REPOFILENAME,"windows",BROWSERNAME,ReadXmlFile.VERSION);
                 System.setProperty(BROWSERDRVNAME, BROWSERWIN64PATH + versionNum + BROWSERFILENAME);
                 break;	
            case Linux_32:
                 versionNum = ReadXmlFile.parserXml(ReadXmlFile.REPOFILENAME,"linux",BROWSERNAME,ReadXmlFile.VERSION);
                 System.setProperty(BROWSERDRVNAME, BROWSERLINUX32PATH + versionNum + BROWSERFILENAME);
                 break;
            case Linux_64:	
                 versionNum = ReadXmlFile.parserXml(ReadXmlFile.REPOFILENAME,"linux",BROWSERNAME,ReadXmlFile.VERSION);
                 System.setProperty(BROWSERDRVNAME, BROWSERLINUX64PATH + versionNum + BROWSERFILENAME);
                 break;	
            case Mac_OS_X_32:
                 versionNum = ReadXmlFile.parserXml(ReadXmlFile.REPOFILENAME,"osx",BROWSERNAME,ReadXmlFile.VERSION);
                 System.setProperty(BROWSERDRVNAME, BROWSEROSX32PATH + versionNum + BROWSERFILENAME);
                 break;
            case Mac_OS_X_64:	
                 versionNum = ReadXmlFile.parserXml(ReadXmlFile.REPOFILENAME,"osx",BROWSERNAME,ReadXmlFile.VERSION);
                 System.setProperty(BROWSERNAME, BROWSEROSX64PATH + versionNum + BROWSERFILENAME);
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
