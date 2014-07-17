package org.bigtester.ate.model.project;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

public class TestProject {
	public List<TestSuite> getlSuite() {
		return lSuite;
	}

	public void setlSuite(List<TestSuite> lSuite) {
		this.lSuite = lSuite;
	}

	private List<TestSuite> lSuite;

	public void runSuites() {
		
		
		TestListenerAdapter tla = new TestListenerAdapter();
		TestNG testng = new TestNG();
		testng.addListener(tla);
	
		List<XmlSuite> suites = new ArrayList<XmlSuite>();
		
		
		for (TestSuite tempSuite: lSuite) {
			
			XmlSuite suite = new XmlSuite();
			suite.setName(tempSuite.getSuiteName());
			
			for (TestCase tempTC: tempSuite.getlTestcase()) {
				
				XmlClass xmlClass = new XmlClass("org.bigtester.ate.model.project.CaseRunner");
			
				List<XmlClass> classes = new ArrayList<XmlClass>();
				classes.add(xmlClass);
				
				XmlTest test = new XmlTest(suite);
				test.setName(tempTC.getTcname());
				test.setXmlClasses(classes) ;
			}
			suites.add(suite);
			System.out.println(suite.toXml());
		}
		if (!suites.isEmpty()) {
			testng.setXmlSuites(suites);

			testng.run();
		} else {
			//TODO add exception handling
		}

	}

}
