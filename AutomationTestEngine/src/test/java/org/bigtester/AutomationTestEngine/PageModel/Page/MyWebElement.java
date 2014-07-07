package org.bigtester.AutomationTestEngine.PageModel.Page;

import org.bigtester.AutomationTestEngine.PageModel.ElementAction.IElementAction;
import org.bigtester.AutomationTestEngine.PageModel.ElementFind.IElementFind;

public class MyWebElement {

	private IElementAction ea;

	private IElementFind ef;

	public MyWebElement(IElementFind ef, IElementAction ea) {
		this.ea = ea;
		this.ef = ef;
	}

	public void doAction() {
		ea.doAction(ef.doFind(ef.getFindByValue()));
	}

	public IElementAction getEa() {
		return ea;
	}

	public void setEa(IElementAction ea) {
		this.ea = ea;
	}

	public IElementFind getEf() {
		return ef;
	}

	public void setEf(IElementFind ef) {
		this.ef = ef;
	}

}
