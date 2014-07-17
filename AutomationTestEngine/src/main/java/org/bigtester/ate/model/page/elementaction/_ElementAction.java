package org.bigtester.ate.model.page.elementaction;


import org.bigtester.ate.model.page._PageModelBase;
import org.openqa.selenium.WebElement;


public abstract class _ElementAction extends _PageModelBase{
	private String dataValue;
	
	public String getDataValue() {
		return dataValue;
	}

	public void setDataValue(String dataValue) {
		this.dataValue = dataValue;
	}

	public abstract void doAction(WebElement we);

	
	
}
