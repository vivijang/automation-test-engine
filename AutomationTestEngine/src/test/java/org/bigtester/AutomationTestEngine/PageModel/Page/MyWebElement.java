package org.bigtester.AutomationTestEngine.PageModel.Page;

import org.bigtester.AutomationTestEngine.PageModel.ElementAction.IElementAction;
import org.bigtester.AutomationTestEngine.PageModel.ElementFind.IElementFind;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration("classpath:applicationContext.xml")

public class MyWebElement {
	
	private IElementAction ea;
	
	
	private IElementFind ef;
	public MyWebElement(IElementFind ef, IElementAction ea){
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
