package org.bigtester.AutomationTestEngine.PageModel;

import org.bigtester.AutomationTestEngine.PageModel.MyWebDriver.IMyWebDriver;


public abstract class _PageModelBase {
	protected IMyWebDriver iMyWd;

	public IMyWebDriver getiMyWd() {
		return iMyWd;
	}

	public void setiMyWd(IMyWebDriver iMyWd) {
		this.iMyWd = iMyWd;
	}
	
}
