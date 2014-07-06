package org.bigtester.AutomationTestEngine.PageModel.Page;

import java.io.File;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.bigtester.AutomationTestEngine.PageModel.WebElementXmlObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class PageXmlObject {

	private File fXmlFile;
	private List<WebElementXmlObject> WebEs;
	public PageXmlObject(File pageXml) {
		fXmlFile = pageXml;
		readWebElementsInfo();
	}
	
	private void readWebElementsInfo()
	{
		try {
			
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
		 
			//optional, but recommended
			//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
			doc.getDocumentElement().normalize();
		 
			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
		 
			NodeList nList = doc.getElementsByTagName("WebElement");
		 
			System.out.println("----------------------------");
		 
			for (int temp = 0; temp < nList.getLength(); temp++) {
				WebElementXmlObject weo = new WebElementXmlObject(); 
				Node nNode = nList.item(temp);
		 
				System.out.println("\nCurrent Element :" + nNode.getNodeName());
		 
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		 
					Element eElement = (Element) nNode;
					weo.setName(eElement.getAttribute("name"));
					weo.setType(eElement.getAttribute("type"));
					weo.setFindby(eElement.getAttribute("findby"));
					weo.setFindbyvalue(eElement.getAttribute("findbyvalue"));
					NodeList actionList = eElement.getElementsByTagName("Action");
					String[] actions = new String[20];
					for (int actiontemp = 0; actiontemp < actionList.getLength(); actiontemp++)
					{
						Node actionNode = actionList.item(actiontemp);
						if (actionNode.getNodeType() == Node.ELEMENT_NODE)
						{
							Element actionElement = (Element) actionNode;
							actions[actiontemp] = actionElement.getTextContent();
						}
					}
					weo.setActions(actions);
					System.out.println("Staff id : " + eElement.getAttribute("name"));
					System.out.println("First Name : " + eElement.getAttribute("type"));
					System.out.println("Last Name : " + eElement.getAttribute("findby"));
					System.out.println("Nick Name : " + eElement.getAttribute("findbyvalue"));
					System.out.println("Salary : " + eElement.getElementsByTagName("Action").getLength());
		 
				}
				WebEs.add(weo);
			}
		    } catch (Exception e) {
			e.printStackTrace();
		    }
	}
	public File getfXmlFile() {
		return fXmlFile;
	}

	public void setfXmlFile(File fXmlFile) {
		this.fXmlFile = fXmlFile;
	}

	public List<WebElementXmlObject> getWebEs() {
		return WebEs;
	}

	public void setWebEs(List<WebElementXmlObject> webEs) {
		WebEs = webEs;
	}
}
