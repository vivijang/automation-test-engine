package org.bigtester.AutomationTestEngine.PageModel.ElementAction;

import org.openqa.selenium.WebElement;

public class SendKeysAction extends _ElementAction {
	CharSequence keys;
	
	public SendKeysAction(CharSequence cs)
	{
		keys = cs;
	}
	@Override
	public void doAction(WebElement we) {
		// TODO Auto-generated method stub
		we.sendKeys(keys);
	}

}
