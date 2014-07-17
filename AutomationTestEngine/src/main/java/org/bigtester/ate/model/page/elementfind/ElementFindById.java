package org.bigtester.ate.model.page.elementfind;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ElementFindById extends _ElementFind implements IElementFind {

	@Override
	public WebElement doFind(String findByValue) {
		return iMyWd.getWd().findElement(By.id(findByValue));
	}

}
