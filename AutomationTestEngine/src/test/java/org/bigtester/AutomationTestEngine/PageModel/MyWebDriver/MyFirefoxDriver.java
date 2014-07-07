package org.bigtester.AutomationTestEngine.PageModel.MyWebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

public class MyFirefoxDriver extends WebDriverBase implements IMyWebDriver{
	
	public MyFirefoxDriver() {
		//TODO create multi browsers and remote web driver handler
		wd = new FirefoxDriver();
	}
	
	
}
