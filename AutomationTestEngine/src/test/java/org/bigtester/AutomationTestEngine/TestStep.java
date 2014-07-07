package org.bigtester.AutomationTestEngine;

import org.bigtester.AutomationTestEngine.PageModel.Page.MyWebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component
@Scope("prototype")
public class TestStep implements ITestStep{
	//TOTO add pageObject as another member.
	
	private MyWebElement myWe;
	
	public TestStep(MyWebElement myWe){
		this.myWe = myWe;
	}
	
	public MyWebElement getMyWe() {
		return myWe;
	}


	public void setMyWe(MyWebElement myWe) {
		this.myWe = myWe;
	}


	public void doStep() {
		
		myWe.doAction();
	}
}
