package org.bigtester.ate.model.page.elementfind;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ElementFindByName extends _ElementFind implements IElementFind {
	
	private String findByValue;
	
	public String getFindByValue() {
		return findByValue;
	}
	public void setFindByValue(String findByValue) {
		this.findByValue = findByValue;
	}
	@Override
	public WebElement doFind(String findByValue) {
		return iMyWd.getWd().findElement(By.name(findByValue));
	}
	
}
