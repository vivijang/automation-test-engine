package org.bigtester.ate.model.casestep;

import org.bigtester.ate.model.page.page.MyWebElement;

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
