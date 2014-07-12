package org.bigtester.AutomationTestEngine.PageModel.ElementFind;

import org.openqa.selenium.WebElement;

public interface IElementFind {
	public WebElement doFind(String findByValue);
	public String getFindByValue();
}
