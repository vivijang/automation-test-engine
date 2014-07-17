package org.bigtester.ate.model.page.elementaction;

import org.openqa.selenium.WebElement;


public class ClickAction extends _ElementAction implements IElementAction {

	@Override
	public void doAction(WebElement we) {
		we.click();
	}
	

}
