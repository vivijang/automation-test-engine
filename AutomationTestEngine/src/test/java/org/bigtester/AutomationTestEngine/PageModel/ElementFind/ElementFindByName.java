package org.bigtester.AutomationTestEngine.PageModel.ElementFind;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ElementFindByName extends _ElementFind {

	@Override
	public WebElement doFind(String findByValue) {
		return mywd.getWd().findElement(By.name(findByValue));
	}

}
