package org.bigtester.AutomationTestEngine.CaseModel;

import org.bigtester.AutomationTestEngine.PageModel.Page.MyWebElement;

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
