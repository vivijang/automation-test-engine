package org.bigtester.ate.model.page.elementfind;

import org.bigtester.ate.model.page._PageModelBase;
import org.openqa.selenium.WebElement;

public abstract class _ElementFind extends _PageModelBase{
	
	private String findByValue;
	public abstract WebElement doFind(String findByValue);
	public String getFindByValue() {
		return findByValue;
	}
	public void setFindByValue(String findByValue) {
		this.findByValue = findByValue;
	}
	
}
