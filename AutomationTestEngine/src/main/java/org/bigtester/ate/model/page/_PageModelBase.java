package org.bigtester.ate.model.page;

import org.bigtester.ate.model.page.atewebdriver.IMyWebDriver;


public abstract class _PageModelBase {
	protected IMyWebDriver iMyWd;

	public IMyWebDriver getiMyWd() {
		return iMyWd;
	}

	public void setiMyWd(IMyWebDriver iMyWd) {
		this.iMyWd = iMyWd;
	}
	
}
