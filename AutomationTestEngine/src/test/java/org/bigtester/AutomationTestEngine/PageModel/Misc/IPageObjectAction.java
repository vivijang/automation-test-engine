package org.bigtester.AutomationTestEngine.PageModel.Misc;

import org.bigtester.AutomationTestEngine.DataModel.DataSet.DataSet;
import org.bigtester.AutomationTestEngine.PageModel.ElementAction._ElementAction;
import org.bigtester.AutomationTestEngine.PageModel.Page.PageObject;

//this class is useless for demoing the BDD and Spring
public interface IPageObjectAction {
	public PageObject doAction(_ElementAction at, DataSet ds);
}
