package org.bigtester.ate.model.casestep;

import org.bigtester.ate.model.page.page.Lastpage;

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
