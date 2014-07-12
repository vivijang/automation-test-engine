package org.bigtester.AutomationTestEngine.PageModel.ElementAction;

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
