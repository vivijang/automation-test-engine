package org.bigtester.AutomationTestEngine.PageModel.ElementFind;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

public class ElementFindByName extends _ElementFind implements IElementFind {
	@Autowired
	private String findByValue;
	
	public String getFindByValue() {
		return findByValue;
	}
	public void setFindByValue(String findByValue) {
		this.findByValue = findByValue;
	}
	@Override
	public WebElement doFind(String findByValue) {
		return mywd.getWd().findElement(By.name(findByValue));
	}
	
}
