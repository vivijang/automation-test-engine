package org.bigtester.ate.model.page.elementaction;

import org.openqa.selenium.WebElement;

public class SendKeysAction extends _ElementAction implements IElementAction{
	
		
	public SendKeysAction()
	{
		
	}
	
	@Override
	public void doAction(WebElement we) {
		// TODO Auto-generated method stub
		we.sendKeys(getDataValue());
		
	}

}
