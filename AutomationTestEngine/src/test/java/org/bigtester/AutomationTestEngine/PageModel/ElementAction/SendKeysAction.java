package org.bigtester.AutomationTestEngine.PageModel.ElementAction;

import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

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
