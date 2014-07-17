package org.bigtester.ate.model.page.page;

import org.bigtester.ate.model.page.elementaction.IElementAction;
import org.bigtester.ate.model.page.elementfind.IElementFind;

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
