package org.bigtester.AutomationTestEngine.PageModel.ElementFind;

import org.bigtester.AutomationTestEngine.PageModel._PageModelBase;
import org.openqa.selenium.WebElement;

public abstract class _ElementFind extends _PageModelBase{
	
	public abstract WebElement doFind(String findByValue);
	
}
