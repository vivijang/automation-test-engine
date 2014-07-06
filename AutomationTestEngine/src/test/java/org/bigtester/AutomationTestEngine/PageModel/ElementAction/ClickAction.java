package org.bigtester.AutomationTestEngine.PageModel.ElementAction;

import org.openqa.selenium.WebElement;


public class ClickAction extends _ElementAction {

	@Override
	public void doAction(WebElement we) {
		we.click();
	}
	

}
