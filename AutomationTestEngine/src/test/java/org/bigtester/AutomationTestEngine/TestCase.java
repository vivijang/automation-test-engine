package org.bigtester.AutomationTestEngine;

import java.util.List;

import org.bigtester.AutomationTestEngine.TestStep.ITestStep;
import org.springframework.beans.factory.annotation.Autowired;

public class TestCase {
	@Autowired
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
