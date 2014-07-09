package org.bigtester.AutomationTestEngine.PageModel;

import org.bigtester.AutomationTestEngine.PageModel.MyWebDriver.IMyWebDriver;
import org.springframework.beans.factory.annotation.Autowired;


public abstract class _PageModelBase {
//	@Autowired
//	protected MyFirefoxDriver iMyWd;
	@Autowired
	protected IMyWebDriver iMyWd;

	public IMyWebDriver getiMyWd() {
		return iMyWd;
	}

	public void setiMyWd(IMyWebDriver iMyWd) {
		this.iMyWd = iMyWd;
	}
	
}
