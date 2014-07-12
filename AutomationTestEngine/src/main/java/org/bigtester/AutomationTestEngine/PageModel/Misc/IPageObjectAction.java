package org.bigtester.AutomationTestEngine.PageModel.Misc;

import org.bigtester.AutomationTestEngine.DataModel.DataSet.DataSet;
import org.bigtester.AutomationTestEngine.PageModel.ElementAction._ElementAction;
import org.bigtester.AutomationTestEngine.PageModel.Page.PageObject;


public interface IPageObjectAction {
	public PageObject doAction(_ElementAction at, DataSet ds);
}
