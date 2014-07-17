package org.bigtester.ate.model.casestep;

import org.bigtester.ate.model.page.page.Homepage;

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
