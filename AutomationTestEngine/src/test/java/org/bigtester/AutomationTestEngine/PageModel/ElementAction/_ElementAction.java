package org.bigtester.AutomationTestEngine.PageModel.ElementAction;


import org.bigtester.AutomationTestEngine.PageModel._PageModelBase;
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
