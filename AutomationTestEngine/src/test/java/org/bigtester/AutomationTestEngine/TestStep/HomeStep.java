package org.bigtester.AutomationTestEngine.TestStep;

import org.bigtester.AutomationTestEngine.PageModel.Page.Homepage;
import org.springframework.beans.factory.annotation.Autowired;

public class HomeStep implements ITestStep{
	@Autowired
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
