package org.bigtester.AutomationTestEngine.PageModel.Page;

import org.bigtester.AutomationTestEngine.PageModel._PageModelBase;

public class Lastpage extends _PageModelBase{
	
	
		
	public Lastpage()
	{
		
	}
	
	public void closeLastpage(){
		super.iMyWd.getWd().close();
	}
}
