package org.bigtester.AutomationTestEngine.CaseModel;

import org.bigtester.AutomationTestEngine.PageModel.Page.Homepage;

public class HomeStep implements ITestStep{
	
	private Homepage hP;

	public Homepage gethP() {
		return hP;
	}

	public void sethP(Homepage hP) {
		this.hP = hP;
	}
	
	public void doStep(){
		hP.startHomepage();
	}

}
