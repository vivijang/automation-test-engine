package org.bigtester.ate.model.page.misc;

import org.bigtester.ate.model.data.DataSet;
import org.bigtester.ate.model.page.elementaction._ElementAction;
import org.bigtester.ate.model.page.page.PageObject;


public interface IPageObjectAction {
	public PageObject doAction(_ElementAction at, DataSet ds);
}
