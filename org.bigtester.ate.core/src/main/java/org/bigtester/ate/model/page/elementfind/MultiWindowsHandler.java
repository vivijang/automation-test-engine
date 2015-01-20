/*******************************************************************************
 * ATE, Automation Test Engine
 *
 * Copyright 2015, Montreal PROT, or individual contributors as
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

import java.util.Set;

import org.bigtester.ate.GlobalUtils;
import org.eclipse.jdt.annotation.Nullable;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

// TODO: Auto-generated Javadoc
/**
 * This class MultiWindowsHandler defines ....
 * 
 * @author Peidong Hu
 *
 */
public class MultiWindowsHandler {

	/** The driver. */
	final private WebDriver driver;

	/** The main window handler. */
	final private String mainWindowHandler;

	/** The main window title. */
	final private String mainWindowTitle;

	/**
	 * @return the mainWindowTitle
	 */
	public String getMainWindowTitle() {
		return mainWindowTitle;
	}

	/**
	 * @return the driver
	 */
	public WebDriver getDriver() {
		return driver;
	}

	/**
	 * 
	 */
	public MultiWindowsHandler(WebDriver driver) {
		this.driver = driver;
		this.mainWindowTitle = retrieveCurrentWindowTitle();
		this.mainWindowHandler = retrieveMainWindowHandle();
	}

	/**
	 * Close all windows except main window.
	 */
	public void closeAllWindowsExceptMainWindow() {
		// To get the main window handle
		String windowTitle = retrieveCurrentWindowTitle();
		String mainWindow = retrieveMainWindowHandle();
		closeAllOtherWindows(mainWindow);
		Assert.assertTrue(windowTitle.contains(mainWindowTitle),
				"Main window title is not matching");
	}

	/**
	 * Retrieve main window handle.
	 *
	 * @return the string
	 */
	final public String retrieveMainWindowHandle() {
		String retVal = driver.getWindowHandle();
		if (null == retVal) {
			throw GlobalUtils.createInternalError("web driver internal error!");
		} else {
			return retVal;
		}
	}

	/**
	 * Retrieve current window title.
	 *
	 * @return the string
	 */
	final public String retrieveCurrentWindowTitle() {
		String windowTitle = driver.getTitle();
		if (null == windowTitle) {
			throw GlobalUtils.createInternalError("web driver internal error!");
		} else {
			return windowTitle;
		}
	}

	// To close all the other windows except the main window.
	/**
	 * Close all other windows.
	 *
	 * @param openWindowHandle
	 *            the open window handle
	 * @return true, if successful
	 */
	public boolean closeAllOtherWindows(String openWindowHandle) {

		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String currentWindowHandle : allWindowHandles) {
			if (!currentWindowHandle.equals(openWindowHandle)) {
				driver.switchTo().window(currentWindowHandle);
				driver.close();
			}
		}

		driver.switchTo().window(openWindowHandle);
		boolean retVal;
		if (driver.getWindowHandles().size() == 1) { // NOPMD
			retVal = true;
		} else {
			retVal = false;
		}
		return retVal;
	}

	/**
	 * @return the mainWindowHandler
	 */
	public String getMainWindowHandler() {
		return mainWindowHandler;
	}

	/**
	 * Switch to window.
	 *
	 * @param title
	 *            the title
	 * @return true, if successful
	 */
	public boolean switchToWindowUsingTitle(String title) {
		String currentWindow = driver.getWindowHandle(); // NOPMD
		Set<String> availableWindows = driver.getWindowHandles();
		boolean switchSuccess;
		if (availableWindows.isEmpty()) {
			switchSuccess = false;
		} else {
			switchSuccess = false; // NOPMD
			for (String windowId : availableWindows) {
				if (driver.switchTo().window(windowId).getTitle().equals(title)) {
					switchSuccess = true;
					break;
				} else {
					driver.switchTo().window(currentWindow);
				}
			}

		}
		return switchSuccess;
	}

	/**
	 * Retrive window handle using title.
	 *
	 * @param title the title
	 * @return the string
	 */
	@Nullable
	public String retriveWindowHandleUsingTitle(String title) {
		String currentWindow = driver.getWindowHandle(); // NOPMD
		Set<String> availableWindows = driver.getWindowHandles();
		String retVal = null; //NOPMD
		if (!availableWindows.isEmpty()) {
			for (String windowId : availableWindows) {
				if (driver.switchTo().window(windowId).getTitle().equals(title)) {
					retVal = driver.getWindowHandle();
					break;
				} else {
					driver.switchTo().window(currentWindow);
				}
			}

		}
		return retVal;
	}
}
