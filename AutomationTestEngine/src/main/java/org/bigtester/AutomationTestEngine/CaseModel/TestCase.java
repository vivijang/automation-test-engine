package org.bigtester.AutomationTestEngine.CaseModel;

import java.util.List;

public class TestCase {
	
	private List<ITestStep> lTs;
	public void goSteps() {
		for (ITestStep tempStep : lTs) {
			tempStep.doStep();
		}
	}
	public List<ITestStep> getlTs() {
		return lTs;
	}
	public void setlTs(List<ITestStep> lTs) {
		this.lTs = lTs;
	}
	

}
