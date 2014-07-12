package org.bigtester.AutomationTestEngine.ProjectModel;

import java.util.List;

public class TestSuite {
	public List<TestCase> getlTestcase() {
		return lTestcase;
	}
	public void setlTestcase(List<TestCase> lTestcase) {
		this.lTestcase = lTestcase;
	}
	private List<TestCase> lTestcase;
	private String suiteName;
	public String getSuiteName() {
		return suiteName;
	}
	public void setSuiteName(String suiteName) {
		this.suiteName = suiteName;
	}
	public TestSuite () {
		
	}
}
