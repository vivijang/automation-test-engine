package org.bigtester.ate.model.page.page;

import org.bigtester.ate.model.page._PageModelBase;

public class Lastpage extends _PageModelBase{
	
	
		
	public Lastpage()
	{
		
	}
	
	public void closeLastpage(){
		super.iMyWd.getWd().close();
	}
}
