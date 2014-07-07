package org.bigtester.AutomationTestEngine.PageModel.ElementFind;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ElementFindById extends _ElementFind implements IElementFind {

	@Override
	public WebElement doFind(String findByValue) {
		return mywd.getWd().findElement(By.id(findByValue));
	}

}
