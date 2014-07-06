package org.bigtester.AutomationTestEngine.PageModel;
//this class is useless for demoing the BDD and Spring
public class WebElementXmlObject {
	//TOTO handle the Select type 
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getFindby() {
		return findby;
	}
	public void setFindby(String findby) {
		this.findby = findby;
	}
	public String getFindbyvalue() {
		return findbyvalue;
	}
	public void setFindbyvalue(String findbyvalue) {
		this.findbyvalue = findbyvalue;
	}
	public String[] getActions() {
		return actions;
	}
	public void setActions(String[] actions) {
		this.actions = actions;
	}
	private String type;
	private String findby;
	private String findbyvalue;
	private String[] actions;

}
