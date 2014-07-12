package org.bigtester.AutomationTestEngine.CaseModel;

import org.bigtester.AutomationTestEngine.PageModel.Page.Lastpage;

public class LastStep implements ITestStep{
	
	private Lastpage lP;

	
	
	public Lastpage getlP() {
		return lP;
	}



	public void setlP(Lastpage lP) {
		this.lP = lP;
	}



	public void doStep(){
		lP.closeLastpage();
	}

}
